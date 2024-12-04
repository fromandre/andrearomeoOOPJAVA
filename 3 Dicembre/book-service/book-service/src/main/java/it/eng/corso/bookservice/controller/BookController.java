package it.eng.corso.bookservice.controller;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.groups.Step1;
import it.eng.corso.bookservice.groups.Step2;
import it.eng.corso.bookservice.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin
public class BookController {

    @Autowired
    @Qualifier("primo")
    private BookService bookService;

    @GetMapping
    public List<BookDTO> findAll( ){
        return bookService.findAll();
    }

    @GetMapping("/search")
    public List<BookDTO> findByAuthor(@RequestParam String author ){
        return bookService.findByAuthor( author );
    }

    @GetMapping("/{uuid}")
    public BookDTO findById( @PathVariable String uuid ){
        return bookService.findByUuid( uuid );
    }

    @PostMapping
    public BookDTO save( @RequestBody @Validated(Step2.class) BookDTO book ){
        return bookService.save( book );
    }

    @PutMapping("/{uuid}")
    public BookDTO update( @PathVariable String uuid, @RequestBody BookDTO book ){
        return bookService.update(uuid, book );
    }

    @PatchMapping("/{uuid}")
    public BookDTO partialUpdate( @PathVariable String uuid, @RequestBody BookDTO book ){
        return bookService.partialUpdate(uuid, book );
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete( @PathVariable String uuid ){
        bookService.delete( uuid );
    }

}

package it.eng.corso.bookservice.controller;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
@CrossOrigin
public class BookController {

    @Autowired
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
    public BookDTO save( @RequestBody BookDTO book ){
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
    public void delete( @PathVariable String uuid ){
        bookService.delete( uuid );
    }

}

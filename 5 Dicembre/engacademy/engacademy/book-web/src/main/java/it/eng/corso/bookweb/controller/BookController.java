package it.eng.corso.bookweb.controller;

import it.eng.corso.bookweb.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/")
    public String listBook(Model model){
        model.addAttribute("books",bookService.findAll());
        return "home";
    }
}

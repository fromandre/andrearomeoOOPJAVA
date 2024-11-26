package it.eng.corso.bookservice.service;

import it.eng.corso.bookservice.model.Book;

import java.util.List;

public interface BookService {

    Book save(Book book);

    List<Book> findAll();

}

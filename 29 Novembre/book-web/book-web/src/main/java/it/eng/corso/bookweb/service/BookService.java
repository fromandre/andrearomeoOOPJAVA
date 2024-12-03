package it.eng.corso.bookweb.service;

import it.eng.corso.bookweb.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookService {

    Book save(Book book);

    List<Book> findAll();

    List<Book> findByAuthor(String author );

    Book findById( Long id );

    void delete(Long id);

    Book update(Long id, Book book);

    Book partialUpdate(Long id, Book book);
}


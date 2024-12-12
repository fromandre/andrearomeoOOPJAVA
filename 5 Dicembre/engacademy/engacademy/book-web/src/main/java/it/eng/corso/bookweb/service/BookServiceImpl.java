package it.eng.corso.bookweb.service;

import it.eng.corso.bookweb.model.Book;
import it.eng.corso.bookweb.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book save(Book book) {
        return bookRepository.save( book );
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase( author );
    }

    @Override
    public Book findById(Long id) {
        return bookRepository.findById(id).get();
    }

    @Override
    public void delete(Long id) {
        bookRepository.deleteById( id );
    }

    @Override
    public Book update(Long id, Book book) {
        Book bookToUpdate = bookRepository.findById( id ).get();

        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPrice(book.getPrice());

        return bookRepository.save( bookToUpdate );
    }

    @Override
    public Book partialUpdate(Long id, Book book) {
        Book bookToUpdate = bookRepository.findById( id ).get();

        if(book.getAuthor()!=null)
            bookToUpdate.setAuthor(book.getAuthor());
        if(book.getTitle()!=null)
            bookToUpdate.setTitle(book.getTitle());
        if(book.getPrice()!=null)
            bookToUpdate.setPrice(book.getPrice());

        return bookRepository.save( bookToUpdate );
    }

}

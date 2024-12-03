package it.eng.corso.bookservice.service;

import it.eng.corso.bookservice.model.Book;

import java.util.List;

public interface BookService {

    BookDTO save(BookDTO book);

    List<BookDTO> findAll();

    BookDTO  findByUuid(String uuid);

    void delete(String uuid);


}

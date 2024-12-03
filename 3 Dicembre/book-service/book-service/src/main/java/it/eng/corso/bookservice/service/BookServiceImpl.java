package it.eng.corso.bookservice.service;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private WebClient webClient;
/*    @Autowired
    private BookService bookService;*/


    @Override
    public BookDTO save(BookDTO book) {
        book.setUuid( String.valueOf(UUID.randomUUID()) );
        return modelToDTO( bookRepository.save( dtoToModel( book ) ) );
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(this::modelToDTO)
                .toList();
    }

    @Override
    public List<BookDTO> findByAuthor(String author) {
        return bookRepository.findByAuthorContainingIgnoreCase( author )
                .stream()
                .map(this::modelToDTO)
                .toList();
    }

    @Override
    public BookDTO findByUuid(String uuid) {
        BookDTO ret = modelToDTO(bookRepository.findByUuid(uuid).orElseThrow());

        ret.setStars(
                webClient.get()
                        .uri("http://localhost:8081/api/v1/reviews/average"
                        ,uriBuilder -> uriBuilder.queryParam("uuidBook", uuid).build())
                        .retrieve()
                        .bodyToMono(Double.class)
                        .block()
        );
        return ret;
    }

    @Override
    public void delete(String uuid) {
        Book bookToDelete = bookRepository.findByUuid(uuid).orElseThrow();
        bookRepository.delete(bookToDelete);
    }

    @Override
    public BookDTO update(String uuid, BookDTO book) {
        Book bookToUpdate = bookRepository.findByUuid(uuid).get();

        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPrice(book.getPrice());

        return modelToDTO( bookRepository.save( bookToUpdate ) );
    }

    @Override
    public BookDTO partialUpdate(String uuid, BookDTO book) {
        Book bookToUpdate = bookRepository.findByUuid(uuid).get();

        if(book.getAuthor()!=null)
            bookToUpdate.setAuthor(book.getAuthor());
        if(book.getTitle()!=null)
            bookToUpdate.setTitle(book.getTitle());
        if(book.getPrice()!=null)
            bookToUpdate.setPrice(book.getPrice());

        return modelToDTO( bookRepository.save( bookToUpdate ) );
    }

    private Book dtoToModel( BookDTO book ){
        return Book.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .build();
    }

    private BookDTO modelToDTO( Book book ){
        return BookDTO.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .build();
    }

}

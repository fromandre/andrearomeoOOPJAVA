package it.eng.corso.bookservice.service;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.exception.NoDataFoundException;
import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.sql.SQLException;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Profile("default")
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    private final WebClient.Builder webClientBuilder;

    @Override
    //@Transactional(propagation = Propagation.NESTED)
    public BookDTO save(BookDTO book) {
        book.setUuid( String.valueOf(UUID.randomUUID()) );
        BookDTO ret = modelToDTO( bookRepository.save( dtoToModel( book ) ) );

        return ret;
    }

    @Override
    @Transactional(rollbackFor = SQLException.class)
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
    @CircuitBreaker(name="book", fallbackMethod = "findByUuidOpen")
    public BookDTO findByUuid(String uuid) {
        BookDTO ret = modelToDTO( bookRepository.findByUuid(uuid).orElseThrow(() -> new NoDataFoundException() ) );

        ret.setStars(
                webClientBuilder.build().delete()
                        .uri("http://review-service/api/v1/reviews"
                        , uriBuilder -> uriBuilder.queryParam("uuidBook",uuid ).build())
                        .retrieve()
                        .bodyToMono(Double.class)
                        .block()
        );
        return ret;
    }

    public BookDTO findByUuidOpen(String uuid, RuntimeException e ) {
        BookDTO ret = modelToDTO( bookRepository.findByUuid(uuid).orElseThrow(() -> new NoDataFoundException() ) );

        return ret;
    }

    @Override
    public void delete(String uuid) {
        Book bookToDelete = bookRepository.findByUuid(uuid).orElseThrow(NoDataFoundException::new);
        bookRepository.delete(bookToDelete);
    }

    @Override
    public BookDTO update(String uuid, BookDTO book) {
        Book bookToUpdate = bookRepository.findByUuid(uuid).orElseThrow(NoDataFoundException::new);

        bookToUpdate.setAuthor(book.getAuthor());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPrice(book.getPrice());

        return modelToDTO( bookRepository.save( bookToUpdate ) );
    }

    @Override
    public BookDTO partialUpdate(String uuid, BookDTO book) {
        Book bookToUpdate = bookRepository.findByUuid(uuid).orElseThrow(NoDataFoundException::new);

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
                .isbn(book.getIsbn())
                .build();
    }

    private BookDTO modelToDTO( Book book ){
        return BookDTO.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .price(book.getPrice())
                .isbn(book.getIsbn())
                .build();
    }

}

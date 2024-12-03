package it.eng.corso.bookservice.service;
import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;

@Service
public class BookServiceImpl implements BookService{
    @Autowired
    private BookRepository bookRepository;

    @Override
    public BookDTO modelToDTO(Book book){
        return Book.DTO.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .prince(book.getPrice())
                .build();
    }

    @Override
    public Book dtoToModel(BookDTO book){
        return Book.DTO.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .author(book.getAuthor())
                .prince(book.getPrice())
                .build();
    }

    @Override
    public BookDTO save(BookDTO book){
        book.setUuid(String.valueUf(UUID.randomUUID()));
        return modelToDTO(bookRepository.save(dtoToModel(book)));
    }

    @Override
    public List<BookDTO> findAll() {
        return bookRepository.findAll()
                .stream()
                .map(this::modelToDTO)
                .toList();
    }

    @Override
    public List<BookDTO> findByAuthor(String author){
        return bookRepository.findByAuthoreContainingIgnoreCase(author)
                .stream()
                .map(this::modelToDTO)
                .toList();
    }

    @Override
    public BookDTO findByUuid(String uuid){
        return modelToDTO(bookRepository.findByUuid(uuid).orElseThrow());
    }

    @Override
    public void delete(String uuid){
        Book bookToDelete = bookRepository.findByUuid(uuid).orElseThrow();
        bookRepository.delete(bookToDelete);
    }

    @Override
    public BookDTO update (String uuid, BookDTO book){
        Book bookToUpdate = bookRepository.findByUuid(uuid).get();

        bookToUpdate.setAuthore(book.getAuthor());
        bookToUpdate.setTitle(book.getTitle());
        bookToUpdate.setPrice(book.getPrice());

        return modelToDTO(bookRepository.save(bookToUpdate));
    }
}

package it.eng.corso.bookservice;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.repository.BookRepository;
import it.eng.corso.bookservice.service.BookServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceMockTest {

    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookServiceImpl bookService;

    @Test
    void testSave(){
        Book bookSaved = Book.builder()
                .title("titolo del book saved")
                .author("autore del book saved")
                .price(9.99)
                .build();

        Mockito.when( bookRepository.save(Mockito.any()) )
                .thenReturn( bookSaved );

        BookDTO bookDTOSaved = bookService.save( BookDTO.builder().build() );

        Assertions.assertEquals( bookSaved.getAuthor(), bookDTOSaved.getAuthor());

        ArgumentCaptor<Book> uuidCaptor = ArgumentCaptor.forClass(Book.class);
        Mockito.verify(bookRepository).save( uuidCaptor.capture() );
        Assertions.assertNotNull(uuidCaptor.getValue().getUuid());


        Mockito.verify(bookRepository, Mockito.times(1)).save(Mockito.any());

    }

}

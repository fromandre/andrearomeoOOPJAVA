package it.eng.corso.bookservice;

import it.eng.corso.bookservice.dto.BookDTO;
import it.eng.corso.bookservice.model.Book;
import it.eng.corso.bookservice.repository.BookRepository;
import it.eng.corso.bookservice.service.BookService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class BookServiceApplicationTests {

	@Autowired
	private BookService bookService;

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSave(){
		bookRepository.deleteAll();

		BookDTO bookToSave = BookDTO.builder()
				.title("Titolo del libro di test")
				.author("autore del libro di test")
				.price(9.99)
				.build();

		BookDTO bookSaved = bookService.save( bookToSave );

		List<Book> books = bookRepository.findAll();

		Assertions.assertNotNull(bookSaved.getUuid());
		Assertions.assertEquals(1, books.size() );
	}

	@Test
	void testStars(){
		BookDTO bookToSave = BookDTO.builder()
				.title("Titolo del libro di test")
				.author("autore del libro di test")
				.price(9.99)
				.build();

		BookDTO bookSaved = bookService.save( bookToSave );

		BookDTO book = bookService.findByUuid( bookSaved.getUuid() );

		Assertions.assertNotNull(book.getStars());
	}

	@Test
	void testModelToDTOtoModel(){
		BookDTO bookToSave = BookDTO.builder()
				.title("Titolo del libro di test")
				.author("autore del libro di test")
				.price(9.99)
				.isbn("1234567890")
				.build();

		BookDTO bookSaved = bookService.save( bookToSave );

		Assertions.assertEquals(bookToSave.getAuthor(), bookSaved.getAuthor() );
		Assertions.assertEquals(bookToSave.getTitle(), bookSaved.getTitle() );
		Assertions.assertEquals(bookToSave.getPrice(), bookSaved.getPrice() );
		Assertions.assertEquals(bookToSave.getIsbn(), bookSaved.getIsbn() );
	}

}

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
class BookRepositoryTests {

	@Autowired
	private BookRepository bookRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testSave(){
		bookRepository.deleteAll();

		Book bookToSave = Book.builder()
				.title("Titolo del libro di test")
				.author("autore del libro di test")
				.price(9.99)
				.build();

		Book bookSaved = bookRepository.save(bookToSave);

		Assertions.assertNotNull(bookSaved.getId());
		Assertions.assertEquals(bookSaved.getAuthor(), bookToSave.getAuthor() );
		Assertions.assertEquals(bookSaved.getTitle(), bookToSave.getTitle() );
		Assertions.assertEquals(bookSaved.getPrice(), bookToSave.getPrice() );
	}
}

package it.eng.corso.bookweb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BookWebApplication extends SpringBootServletInitializer  {

	public static void main(String[] args) {
		SpringApplication.run(BookWebApplication.class, args);
	}

}

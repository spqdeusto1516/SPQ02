package com.deusto;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

import com.deusto.builders.BookBuilder;
import com.deusto.model.Book;
import com.deusto.repository.BookRepository;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
public class BookitApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(BookitApplication.class, args);
	}
	public void run(String... arg0) throws Exception {
//		repository.deleteAll();
//		Book book1 = new BookBuilder().build();
//		book1.setTitle("LOTR");
//		book1.setId("1234");
//		repository.save(book1);
//		System.out.println("Books found with findAll():");
//		System.out.println("-------------------------------");
//		for (Book books : repository.findAll()) {
//			System.out.println(books.getTitle());
//		}
//		System.out.println();
		
	}
}

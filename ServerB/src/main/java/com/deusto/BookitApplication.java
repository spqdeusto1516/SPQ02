package com.deusto;


import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import com.deusto.model.Book;
import com.deusto.repository.BookRepository;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
@SpringBootApplication
public class BookitApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository bRepository;
	public List<Book> books;
	
	private static final Logger log = LoggerFactory.getLogger(BookitApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(BookitApplication.class, args);

	}


	@Override
	public void run(String... arg0) throws Exception { }

}

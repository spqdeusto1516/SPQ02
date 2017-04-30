package org.ClientP;


import org.mongeez.Mongeez;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.ModelAndView;

import com.mongodb.Mongo;
import com.deusto.model.Book;
import com.deusto.repository.BookRepository;
@Controller
public class App 
{
//	@Autowired
//	 BookRepository bRepository;
//	@GetMapping(path = "/hola", produces = MediaType.APPLICATION_JSON_VALUE)
//    public HttpEntity<?> json(){
//    	return new ResponseEntity(bRepository.findAll(),HttpStatus.OK);
//    }
	
    public static void main( String[] args )
    {
    	Book book = new Book("Hola", "Fred");
    	System.out.println("ID: "+book.getId()+" Title: "+book.getTitle());
//		System.out.println("Books found with findAll():");
//		System.out.println("-------------------------------");
//		for (Book books : bRepository.findAll()) {
//			System.out.println(books.getTitle());
//		}
    }
}

package org.ClientP;



import java.util.List;

import com.deusto.BookitApplication;
import com.deusto.model.Book;

public class App
{ 

	public static void main(String args[]) {
		BookitApplication bookit = new BookitApplication();
		bookit.main(args);
//		List<Book> books = bookit.getBooks();
//		System.out.println(bookit.getBooks().get(0).toString());
//		for(Book book: books){
//			System.out.println(book.toString());
//		}
	}



//    public static void main( String[] args )
//    {
    
//    	Book book = new Book("Hola", "Fred");
//    	System.out.println("ID: "+book.getId()+" Title: "+book.getTitle());
//    	
//    	RestTemplate restTemplate = new RestTemplate();
//        Book book1 = restTemplate.getForObject("http://localhost:8080/", Book.class);
//        log.info(book1.toString());
//		System.out.println("Books found with findAll():");
//		System.out.println("-------------------------------");
//		for (Book books : bRepository.findAll()) {
//			System.out.println(books.getTitle());
//		}
//    }
//	@Bean
//	public RestTemplate restTemplate(RestTemplateBuilder builder) {
//		return builder.build();
//	}
//
//	@Bean
//	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
//		return args -> {
//			Book book1 = restTemplate.getForObject("http://localhost:8080/", Book.class);
//			log.info(book1.toString());
//		};
//	}

}

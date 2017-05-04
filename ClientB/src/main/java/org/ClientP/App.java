package org.ClientP;



import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.bson.Document;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.mongodb.core.geo.GeoJson;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.test.web.servlet.MvcResult;

import com.deusto.controllers.BookController;
import com.deusto.integration.test.ReserveControllerITest;
import com.deusto.models.Book;
import com.deusto.repositories.BookRepository;
import com.deusto.services.BookService;
import com.mongodb.*;
import com.mongodb.client.*;

public class App
{ 	
	@SuppressWarnings( "resource" )
	public static void main(String args[]) {
		BookService bookit = new BookService();
		System.out.println(bookit.findAll().get(0).getTitle());
//		 MongoClient client = new MongoClient("localhost",27017); 
//		 MongoDatabase db = client.getDatabase("bookit_db");
//		 MongoCollection<Document> collection = db.getCollection("books");
//
//		 FindIterable<Document> iterable = collection.find();
//		 MongoCursor<Document> cursor =  iterable.iterator();
//		 ObjectMapper mapper = new ObjectMapper();
//		 
//		 String jsonInString;
//		 int i = 0;
//		 ArrayList<Book> books = new ArrayList<>();
//		 while(cursor.hasNext()){
//			 jsonInString = cursor.tryNext().toJson();
//			 try {
//				books.add(i,mapper.readValue(jsonInString, Book.class));
//				i++;
//			} catch (JsonParseException e) {
//				e.printStackTrace();
//			} catch (JsonMappingException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		 }
//		 ArrayList<Book> bookByTitle = new ArrayList<>();
//		 int j = 0;
//		 for(Book book:books){
//			 if(book.getTitle().equals("hola")){
//				 bookByTitle.add(j, book);
//				 j++;
//			 }
//		 }
//		 for(Book book:bookByTitle){
//			 System.out.println(book.getId());
//		 }
	}

}

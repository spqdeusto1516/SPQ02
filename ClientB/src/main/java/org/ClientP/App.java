package org.ClientP;

import java.io.IOException;
import java.util.ArrayList;

import org.bson.Document;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.*;

import com.deusto.models.Book;
import com.mongodb.*;
import com.mongodb.client.*;

public class App
{ 	
	@SuppressWarnings( "resource" )
	public static void main(String args[]) {
		 MongoClient client = new MongoClient("localhost",27017); 
		 MongoDatabase db = client.getDatabase("bookit_db");
		 MongoCollection<Document> collection = db.getCollection("books");

		 FindIterable<Document> iterable = collection.find();
		 MongoCursor<Document> cursor =  iterable.iterator();
		 ObjectMapper mapper = new ObjectMapper();
		 
		 String jsonInString;
		 int i = 0;
		 ArrayList<Book> books = new ArrayList<>();
		 while(cursor.hasNext()){
			 jsonInString = cursor.tryNext().toJson();
			 try {
				books.add(i,mapper.readValue(jsonInString, Book.class));
				i++;
			} catch (JsonParseException e) {
				e.printStackTrace();
			} catch (JsonMappingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		 }
		 ArrayList<Book> bookByTitle = new ArrayList<>();
		 int j = 0;
		 for(Book book:books){
			 if(book.getTitle().equals("hola")){
				 bookByTitle.add(j, book);
				 j++;
			 }
		 }
		 for(Book book:bookByTitle){
			 System.out.println(book.getId());
		 }
	}

}

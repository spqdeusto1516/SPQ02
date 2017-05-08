package org.ClientP;


import java.io.*;
import java.util.ArrayList;
import com.deusto.models.Book;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.map.ObjectMapper;
import org.apache.http.*;

public class Application {
		
	
	public HttpEntity startConnection(String url){
		
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGetRequest = new HttpGet(url);
		HttpEntity entity = null;
	    try {
			HttpResponse httpResponse = httpClient.execute(httpGetRequest);
			entity = httpResponse.getEntity();
			System.out.println("----------------------------------------");
			System.out.println(httpResponse.getStatusLine());
			System.out.println("----------------------------------------");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	    return entity;
	}
	
	public ArrayList<Book> getBooks(HttpEntity entity){
		ArrayList<Book> books = new ArrayList<>();
	    ObjectMapper mapper = new ObjectMapper();
	    byte[] buffer = new byte[1024];
	    if (entity != null) {
	        InputStream inputStream = null;
			try {
				inputStream = entity.getContent();
			} catch (UnsupportedOperationException e1) {
				e1.printStackTrace();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
	        try {
	          BufferedInputStream bis = new BufferedInputStream(inputStream);
	          int i = 0;
	          int j = 0;
	          while((buffer[i] = (byte) bis.read()) != -1){
	        	  if(buffer[i] == 125){
	        		  String chunk = new String(buffer, 1, i);
	        		  System.out.println(chunk);
	        		  books.add(j,mapper.readValue(chunk, Book.class));
	        		  j++;
	        		  i = 0;  
	        	  }
	        	  else{
	        		  i++;
	        	  }
	          }
	        } catch (Exception e) {
	            e.printStackTrace();
	       } finally {
	          try { inputStream.close(); } catch (Exception ignore) {}
	      }}
		return books;
	}
	
	public final static void main(String[] args)  {
		Application app = new Application();
		HttpEntity entity = app.startConnection("http://localhost:8080/book");
		ArrayList<Book> books = app.getBooks(entity);
		System.out.println(books.get(0).getTags().get(0));
		System.out.println(books.get(0).getTags().get(1));
		 
	}
 }
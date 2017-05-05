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
	 
  public final static void main(String[] args)  {
	
    HttpClient httpClient = HttpClientBuilder.create().build();
    try {
      HttpGet httpGetRequest = new HttpGet("http://localhost:8080/book");
      HttpResponse httpResponse = httpClient.execute(httpGetRequest);

      System.out.println("----------------------------------------");
      System.out.println(httpResponse.getStatusLine());
      System.out.println("----------------------------------------");

      HttpEntity entity = httpResponse.getEntity();
      ArrayList<Book> books = new ArrayList<>();
      ObjectMapper mapper = new ObjectMapper();

      byte[] buffer = new byte[1024];
      if (entity != null) {
        InputStream inputStream = entity.getContent();
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
          System.out.println(books.get(0).getId());
          System.out.println(books.get(1).getId());
          System.out.println(books.get(2).getId());
          System.out.println(books.get(3).getId());
          System.out.println(books.get(4).getId());
          System.out.println(books.get(5).getId());
          System.out.println(books.get(6).getTitle());
          System.out.println(books.get(6).getGenre());
        
        } catch (Exception e) {
          e.printStackTrace();
        } finally {
          try { inputStream.close(); } catch (Exception ignore) {}
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
    	httpClient.getConnectionManager().shutdown();
    }
  }
 }
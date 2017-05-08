package org.ClientP;


import java.io.*;
import java.util.ArrayList;

import org.models.Book;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.dtos.FilterDTO;
import org.apache.http.*;

public class Application {
		
	
	public HttpEntity startConnectionGet(String url) throws ClientProtocolException, IOException{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpGet httpGetRequest = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGetRequest);
		HttpEntity entity = httpResponse.getEntity();
		System.out.println("----------------------------------------");
		System.out.println(httpResponse.getStatusLine());
		System.out.println("----------------------------------------");
	    return entity;
	}
	
	
	public HttpEntity getBooksFilter(String url, FilterDTO filter) throws ClientProtocolException, IOException{
		HttpClient httpClient = HttpClientBuilder.create().build();
		HttpPost httpPostRequest = new HttpPost(url);
		ObjectMapper mapper = new ObjectMapper();
		String json= mapper.writeValueAsString(filter);
		System.out.println(json);
		StringEntity entity = new StringEntity(json);
		httpPostRequest.setEntity(entity);
	    httpPostRequest.setHeader("Accept", "application/json");
	    httpPostRequest.setHeader("Content-type", "application/json");
		return httpClient.execute(httpPostRequest).getEntity();
	}
	
	public ArrayList<Book> getBooks(HttpEntity entity) throws JsonParseException, JsonMappingException, IOException{
		ArrayList<Book> books = new ArrayList<>();
	    ObjectMapper mapper = new ObjectMapper();
	    byte[] buffer = new byte[1024];
	    if (entity != null) {
	        InputStream inputStream = null;
			inputStream = entity.getContent();
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
	    }
		return books;
	}
	
	
	public final static void main(String[] args) throws ClientProtocolException, IOException  {
		Application app = new Application();
		HttpEntity entity = app.startConnectionGet("http://localhost:8080/book");
		ArrayList<Book> books = app.getBooks(entity);
		System.out.println(books.get(0).getTags().get(0));
		System.out.println(books.get(0).getTags().get(1));
		FilterDTO filter = new FilterDTO();
		filter.setTitle("hello");
		HttpEntity entity2 = app.getBooksFilter("http://localhost:8080/book/filter", filter);
		app.getBooks(entity2);
		 
	}
 }
package org.ClientP;


import java.io.*;
import java.util.ArrayList;

import org.models.Address;
import org.models.Book;
import org.models.Token;
import org.models.User;
import org.security.SecurityUser;
import org.security.TokenUtils;

import com.mongodb.util.JSON;

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
import org.dtos.*;
import org.apache.http.*;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class Application {
		private HttpClient httpClient = HttpClientBuilder.create().build();
	
	public HttpEntity startConnectionGet(String url) throws ClientProtocolException, IOException{
		
		HttpGet httpGetRequest = new HttpGet(url);
		HttpResponse httpResponse = httpClient.execute(httpGetRequest);
		HttpEntity entity = httpResponse.getEntity();
		System.out.println("----------------------------------------");
		System.out.println(httpResponse.getStatusLine());
		System.out.println("----------------------------------------");
	    return entity;
	}
	
	
	public HttpEntity getBooksFilter(FilterDTO filter) throws ClientProtocolException, IOException{
		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/book/filter");
		ObjectMapper mapper = new ObjectMapper();
		String json= mapper.writeValueAsString(filter);
		System.out.println(json);
		StringEntity entity = new StringEntity(json);
		httpPostRequest.setEntity(entity);
	    httpPostRequest.setHeader("Accept", "application/json");
	    httpPostRequest.setHeader("Content-type", "application/json");
		return httpClient.execute(httpPostRequest).getEntity();
	}
	public void registr1(RegistrDTO registr) throws ClientProtocolException, IOException{
		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/registration");
		ObjectMapper mapper = new ObjectMapper();
		String json= mapper.writeValueAsString(registr);
		System.out.println(json);
		StringEntity entity = new StringEntity(json);
		httpPostRequest.setEntity(entity);
	    httpPostRequest.setHeader("Accept", "application/json");
	    httpPostRequest.setHeader("Content-type", "application/json");
	    httpClient.execute(httpPostRequest);
	}
	
	public void registr2(User user) throws ClientProtocolException, IOException{
		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/registration/person");
		ObjectMapper mapper = new ObjectMapper();
		String json= mapper.writeValueAsString(user);
		System.out.println(json);
		StringEntity entity = new StringEntity(json);
		httpPostRequest.setEntity(entity);
	    httpPostRequest.setHeader("Accept", "application/json");
	    httpPostRequest.setHeader("Content-type", "application/json");
	    httpClient.execute(httpPostRequest);
	}
	
	public Boolean login(LoginDTO login){
		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/login");
		ObjectMapper mapper = new ObjectMapper();
		String json;
		try {
			json = mapper.writeValueAsString(login);
			System.out.println(json);
			StringEntity entity = new StringEntity(json);
			httpPostRequest.setEntity(entity);
		    httpPostRequest.setHeader("Accept", "application/json");
		    httpPostRequest.setHeader("Content-type", "application/json");
		    Token token;
			try {
				token = getToken(httpClient.execute(httpPostRequest).getEntity());
				TokenUtils tUtils = new TokenUtils();
				System.out.println(tUtils.getUsernameFromToken(token.getToken()));
				return true;
			} catch (ClientProtocolException e) {
				return false;
				// TODO Auto-generated catch block
			} catch (IOException e) {
				return false;
				// TODO Auto-generated catch block
			}
		} catch (JsonGenerationException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (JsonMappingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return false;
	
	}
	
	public Token getToken(HttpEntity entity) throws IOException{
		Token token = new Token();
		ObjectMapper mapper = new ObjectMapper();
	    byte[] buffer = new byte[65536];
	    if (entity != null) {
	        InputStream inputStream = null;
			inputStream = entity.getContent();
	        BufferedInputStream bis = new BufferedInputStream(inputStream);
	        int i = 0;
	        int j = 0;
	        while((buffer[i] = (byte) bis.read()) != -1){
	        	if(buffer[i] == 125){
	        		String chunk = new String(buffer, 0, i+1);
	        		System.out.println(chunk);
	        		token = mapper.readValue(chunk, Token.class);
	        		System.out.println(token.getToken());
	        		j++;
	        		i = 0; 
	        	}
	        	else{
	        		i++;
	        	}
	       }
	    }
		return token;
		
	}
	public void reserve(ReserveDTO reserv) throws JsonGenerationException, JsonMappingException, IOException{
		HttpPost httpPostRequest = new HttpPost("http://localhost:8080/reservation/create");
		ObjectMapper mapper = new ObjectMapper();
		String json= mapper.writeValueAsString(reserv);
		System.out.println(json);
		StringEntity entity = new StringEntity(json);
		httpPostRequest.setEntity(entity);
	    httpPostRequest.setHeader("Accept", "application/json");
	    httpPostRequest.setHeader("Content-type", "application/json");
	    httpClient.execute(httpPostRequest);
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
//		ArrayList<Book> books = app.getBooks(entity);
//		System.out.println(books.get(0).getTags().get(0));
//		System.out.println(books.get(0).getId());
//		FilterDTO filter = new FilterDTO();
//		filter.setTitle("hello");
//		HttpEntity entity2 = app.getBooksFilter(filter);
//		app.getBooks(entity2);
//		RegistrDTO registr = new RegistrDTO();
//		registr.setEmail("anderareizaga1996@gmail.com");
//		registr.setFirstname("Ander");
//		registr.setLastname("Areizaga");
//		app.registr1(registr);
//		Address adrs = new Address("Rafaela Ybarra", 5, 2, "48014", "Bilbao", "Spain");
//		User user = new User("anderareizaga1996@gmail.com", 120696, "48014", 633419296, "1234", adrs);
//		app.registr2(user);
		LoginDTO login = new LoginDTO();
		login.setEmail("ander.areizagab@opendeusto.es");
		login.setEncryptedPassword("1234");
		System.out.println(app.login(login));
//		Token token = app.getToken(entity3);
//		TokenUtils tk = new TokenUtils();
	}
 }
package org.ClientP;


import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.boot.json.*;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.codehaus.jackson.map.ObjectMapper;
import com.deusto.model.Book;

import springfox.documentation.spring.web.json.Json;

import org.hamcrest.Matchers.*;
import org.json.JSONObject;
import org.apache.http.*;


/**
 * This class is the same as the ApacheHttpRestClient2 class, but with
 * fewer try/catch clauses, and fewer comments.
*/
public class Application {
	 
  public final static void main(String[] args)  {
	
    HttpClient httpClient = HttpClientBuilder.create().build();
    try {
      HttpGet httpGetRequest = new HttpGet("http://localhost:8080/");
      HttpResponse httpResponse = httpClient.execute(httpGetRequest);

      System.out.println("----------------------------------------");
      System.out.println(httpResponse.getStatusLine());
      System.out.println("----------------------------------------");

      HttpEntity entity = httpResponse.getEntity();
      ArrayList<Book> books = new ArrayList<>();
      ObjectMapper mapper = new ObjectMapper();

      byte[] buffer = new byte[500];
      byte[] buffer2 = new byte[200];
      byte[] buffer3 = new byte[200];
      if (entity != null) {
        InputStream inputStream = entity.getContent();
        try {
          int bytesRead = 0;
          BufferedInputStream bis = new BufferedInputStream(inputStream);
          int i = 0;
          int j = 0;
          while((buffer[i] = (byte) bis.read()) != -1){
        	  if(buffer[i] == 125){
        		  String chunk = new String(buffer, 1, i);
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
package org.controllers;

import java.io.IOException;
import java.util.Arrays;

import org.codehaus.jackson.map.ObjectMapper;
import org.dtos.RegistrDTO;
import org.models.User;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RegistrController {
	public static final String REST_SERVICE_URI = "http://localhost:8080/";
	/**
     * Makes the first step for registering
     * @return RegistrDTO
     */
	public static void registrStep1(RegistrDTO register) throws IOException{
		System.out.println("------------ Registration step 1 ----------");
        RestTemplate restTemplate = new RestTemplate();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(register);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/registration",
                        HttpMethod.POST, entity, new ParameterizedTypeReference<String>() {
                        });
        String body = rateResponse.getBody();
        System.out.println(body);
	}
	/**
     * Makes the third step for registering after the email confirmation
     * @return User
     */
	public static void registrStep2(User user) throws IOException{
		System.out.println("------------ Registration step 2 ----------");
        RestTemplate restTemplate = new RestTemplate();
        
        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(user);
        
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);
        ResponseEntity<String> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/registration/person",
                        HttpMethod.POST, entity, new ParameterizedTypeReference<String>() {
                        });
        String body = rateResponse.getBody();
        System.out.println(body);
	}
}

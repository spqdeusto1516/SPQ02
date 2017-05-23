package org.controllers;

import org.codehaus.jackson.map.ObjectMapper;
import org.dtos.LoginDTO;
import org.models.Token;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

public class LoginController {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";
    /**
     * Logins to the application.
     * @param LoginDTO
     * @return Token
     */
    public static Token login(LoginDTO loginDTO) throws IOException {
        System.out.println("------------ Login ----------");
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(loginDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        ResponseEntity<Token> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/login",
                        HttpMethod.POST, entity, new ParameterizedTypeReference<Token>() {
                        });

        Token token = rateResponse.getBody();
        return token;
    }
}

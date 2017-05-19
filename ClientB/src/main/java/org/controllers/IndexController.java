package org.controllers;

import org.models.Bookk;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

public class IndexController {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    public static void getAuth() {
        System.out.println("------------Get auth ----------");
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X_AUTH_TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWFuYS5hcnRpb21Ab3BlbmRldXN0by5lcyIsImNyZWF0ZWQiOjE0OTUyMzEzMzEzNTEsImV4cCI6MTU4MTYzMTMzMX0.EjBpAiMc2X2kmmdPNU97aDSbbpojAIQvmPR2RoiAP9afpKihSmEi5_k4fgryC5N10NSVbCUaWYAcaAgmKIkY5g");

        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<Bookk> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/index/auth",
                        HttpMethod.GET, entity, new ParameterizedTypeReference<Bookk>() {
                        });

        Bookk bookk = rateResponse.getBody();
        System.out.println(bookk.getAgeLimit());
    }
}

package org.controllers;

import org.dtos.ReserveDTO;
import org.codehaus.jackson.map.ObjectMapper;
import org.models.Reserve;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.Arrays;

public class ReserveController {

    public static final String REST_SERVICE_URI = "http://localhost:8080/";

    public static void create(ReserveDTO reserveDTO) throws IOException {
        System.out.println("------------ Reserve ----------");
        RestTemplate restTemplate = new RestTemplate();

        ObjectMapper mapper = new ObjectMapper();
        String json = mapper.writeValueAsString(reserveDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("X_AUTH_TOKEN", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJkaWFuYS5hcnRpb21Ab3BlbmRldXN0by5lcyIsImNyZWF0ZWQiOjE0OTUyMzEzMzEzNTEsImV4cCI6MTU4MTYzMTMzMX0.EjBpAiMc2X2kmmdPNU97aDSbbpojAIQvmPR2RoiAP9afpKihSmEi5_k4fgryC5N10NSVbCUaWYAcaAgmKIkY5g");
        HttpEntity<String> entity = new HttpEntity<String>(json, headers);

        ResponseEntity<Reserve> rateResponse =
                restTemplate.exchange(REST_SERVICE_URI + "/reservation/create",
                        HttpMethod.POST, entity, new ParameterizedTypeReference<Reserve>() {
                        });

        Reserve body = rateResponse.getBody();

        System.out.println(body.getBook().getTitle());
    }
}

package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.entity.Cat;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CatControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/cat";
    private final String ADD = "/add";
    private final String GET_BY_ID = "/get";

    @Test
    public void addCat() {
        Cat cat = createCat();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());
    }

    private Cat createCat() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Cat cat = prefillCat("Barsik");

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Cat createdCat = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Cat.class
        ).getBody();
        assertNotNull(createdCat);
        assertEquals(cat.getName(), createdCat.getName());
        assertEquals(cat.getDescription(), createdCat.getDescription());
        return createdCat;
    }

    private Cat prefillCat(String name) {
        Cat cat = new Cat();
        cat.setName(name);
        cat.setDescription("Angry cat");
        return cat;
    }
}

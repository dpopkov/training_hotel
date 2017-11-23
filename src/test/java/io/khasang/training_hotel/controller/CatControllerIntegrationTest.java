package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.entity.Cat;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CatControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/cat";
    private final String ADD = "/add";
    private final String UPDATE = "/update";
    private final String DELETE = "/delete";
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

    @Test
    public void updateCat() {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                13L
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat cat = responseEntity.getBody();

        cat.setDescription("Funny " + cat.getDescription());

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, httpHeaders);
        Cat updatedCat = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Cat.class
        ).getBody();

        assertNotNull(updatedCat);
        assertEquals(cat.getDescription(), updatedCat.getDescription());
    }

    /*@Test
    public void updateCat(){
        Cat cat = createCat();
        cat.setName("Snegok");

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        HttpEntity<Cat> httpEntity = new HttpEntity<>(cat, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + UPDATE,
                HttpMethod.POST,
                httpEntity,
                Cat.class
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());
        assertEquals("Snegok", receivedCat.getName());
    }*/

    @Test
//    @Ignore
    public void deleteCat() {
        Cat cat = new Cat();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Cat> responseEntity = restTemplate.exchange(
                ROOT + DELETE + "?id=" + "{id}",
                HttpMethod.DELETE,
                null,
                Cat.class,
                cat.getId()
        );

        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Cat receivedCat = responseEntity.getBody();
        assertNotNull(receivedCat.getDescription());

        ResponseEntity<Cat> responseEntityForDeletedCat = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Cat.class,
                cat.getId()
        );
        assertEquals("OK", responseEntityForDeletedCat.getStatusCode().getReasonPhrase());
        assertNull(responseEntityForDeletedCat.getBody());
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

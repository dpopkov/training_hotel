package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.dto.CarDTO;
import io.khasang.training_hotel.entity.Car;
import io.khasang.training_hotel.entity.Employee;
import org.junit.Test;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class CarControllerIntegrationTest {
    private final String ROOT = "http://localhost:8080/car";
    private final String ADD = "/add";
    private final String ALL = "/all";
    private final String GET_BY_ID = "/get";

    @Test
    public void addCar() {
        Car car = createCar();
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Car> responseEntity = restTemplate.exchange(
                ROOT + GET_BY_ID + "/{id}",
                HttpMethod.GET,
                null,
                Car.class,
                car.getId()
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Car receivedCar = responseEntity.getBody();

        assertNotNull(receivedCar.getModel());
        assertEquals(car.getId(), receivedCar.getId());
        assertEquals(car.getYear(), receivedCar.getYear());
    }

    @Test
    public void getCars() {
        createCar();  // assuming that db contains at least 2 cars
        createCar();

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Set<CarDTO>> responseEntity = restTemplate.exchange(
                ROOT + ALL,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<Set<CarDTO>>() {}
        );
        assertEquals("OK", responseEntity.getStatusCode().getReasonPhrase());
        Set<CarDTO> carSet = responseEntity.getBody();
        assertNotNull(carSet);
    }

    private Car createCar() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON_UTF8);

        Car car = prefillCar();

        HttpEntity<Car> httpEntity = new HttpEntity<>(car, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        Car createdCar = restTemplate.exchange(
                ROOT + ADD,
                HttpMethod.PUT,
                httpEntity,
                Car.class
        ).getBody();

        assertNotNull(createdCar);
        assertEquals(car.getModel(), createdCar.getModel());
        return createdCar;

    }

    private Car prefillCar() {
        Car car = new Car();
        car.setModel("Lada");
        car.setYear(LocalDate.of(2017, 1, 22));

        Employee employee1 = new Employee();
        employee1.setFirstName("Jack");
        employee1.setLastName("Sparrow");

        Employee employee2 = new Employee();
        employee2.setFirstName("Mick");
        employee2.setLastName("Jagger");

        Set<Employee> employees = new HashSet<>();
        employees.add(employee1);
        employees.add(employee2);

        car.setEmployeeSet(employees);

        /*car.getEmployeeSet().add(employee1);
        employee1.getCarSet().add(car);
        car.getEmployeeSet().add(employee2);
        employee2.getCarSet().add(car);*/

        return car;
    }
}

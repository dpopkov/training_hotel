package io.khasang.training_hotel.service;

import io.khasang.training_hotel.entity.Car;

import java.util.Set;

public interface CarService {
    /**
     * Method for receiving all cars.
     *
     * @return list of all cars
     */
    Set<Car> getSet();

    /**
     * @param id car id
     * @return Car with specified id
     */
    Car getCarById(long id);

    /**
     * @param car car that should be added to DB
     * @return car
     */
    Car addCar(Car car);

}

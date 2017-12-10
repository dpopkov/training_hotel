package io.khasang.training_hotel.dao.impl;

import io.khasang.training_hotel.dao.CarDao;
import io.khasang.training_hotel.entity.Car;

public class CarDaoImpl extends BasicDaoImpl<Car> implements CarDao {
    public CarDaoImpl() {
        super(Car.class);
    }
}

package io.khasang.training_hotel.service.impl;

import io.khasang.training_hotel.dao.CarDao;
import io.khasang.training_hotel.entity.Car;
import io.khasang.training_hotel.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Set;

@Service("CarService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;

    @Override
    public Set<Car> getSet() {
        return carDao.getSet();
    }

    @Override
    public Car getCarById(long id) {
//        return null;
        throw new NotImplementedException();
    }

    @Override
    public Car addCar(Car car) {
        return carDao.add(car);
    }
}

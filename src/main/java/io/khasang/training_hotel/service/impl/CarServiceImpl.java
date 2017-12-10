package io.khasang.training_hotel.service.impl;

import io.khasang.training_hotel.dao.CarDao;
import io.khasang.training_hotel.dto.CarDTO;
import io.khasang.training_hotel.entity.Car;
import io.khasang.training_hotel.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.HashSet;
import java.util.Set;

@Service("CarService")
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Autowired
    private CarDTO carDTO;

    @Override
    public Set<CarDTO> getSet() {
        Set<Car> carSet = carDao.getSet();
        Set<CarDTO> carDTOSet = new HashSet<>();

        for (Car car : carSet) {
            carDTOSet.add(carDTO.getCarDTO(car));
        }
        return carDTOSet;
    }

    @Override
    public CarDTO getCarById(long id) {
        Car car = carDao.getById(id);
        CarDTO dto = carDTO.getCarDTO(car);
        return dto;
    }

    @Override
    public Car addCar(Car car) {
        return carDao.add(car);
    }
}

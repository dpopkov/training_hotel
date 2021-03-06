package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.dto.CarDTO;
import io.khasang.training_hotel.entity.Car;
import io.khasang.training_hotel.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
@RequestMapping("/car")
public class CarController {
    @Autowired
    private CarService carService;

    @RequestMapping(value = "/add", method = RequestMethod.PUT, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Car addCar(@RequestBody Car car) {
        return carService.addCar(car);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    @ResponseBody
    public Set<CarDTO> getCars() {
        return carService.getSet();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public CarDTO getCarById(@PathVariable("id") String id) {
        return carService.getCarById(Long.parseLong(id));
    }
}

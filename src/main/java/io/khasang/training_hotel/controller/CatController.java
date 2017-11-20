package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.entity.Cat;
import io.khasang.training_hotel.service.CatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/cat")
public class CatController {
    @Autowired
    private CatService catService;

    @RequestMapping(value = "/all", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public List<Cat> getAllCats() {
        return catService.getAllCats();
    }

    @RequestMapping(value = "/get/{id}", method = RequestMethod.GET, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Cat getCatById(@PathVariable("id") String id) {
        return catService.getCatById(Long.parseLong(id));
    }
}

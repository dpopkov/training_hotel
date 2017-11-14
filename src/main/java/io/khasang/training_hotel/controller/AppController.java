package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {
    private CreateTable createTable;

    @Autowired
    public AppController(CreateTable createTable) {
        this.createTable = createTable;
    }

    // http://localhost:8080
    @RequestMapping("/")
    public String helloPage(Model model) {
        model.addAttribute("name", "Jack Sparrow");
        return "hello";
    }

    @RequestMapping("/create")
    public String tableCreationInfo(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "status";
    }
}

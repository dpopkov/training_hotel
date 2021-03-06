package io.khasang.training_hotel.controller;

import io.khasang.training_hotel.model.CreateTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppController {
    private CreateTable createTable;

    @Autowired
    public AppController(CreateTable createTable) {
        this.createTable = createTable;
    }

    // http://localhost:8080
    @RequestMapping("/")
    public String helloPage() {
        return "cat";
    }

    @RequestMapping("/create")
    public String tableCreationInfo(Model model) {
        model.addAttribute("status", createTable.createTableStatus());
        return "status";
    }

    @ResponseBody
    @RequestMapping("/user")
    public String userPage() {
        return "user-response-body";
    }

    @ResponseBody
    @RequestMapping("/admin")
    public String adminPage() {
        return "admin-response-body";
    }

    @ResponseBody
    @RequestMapping(value = {"/password/{password}"}, method = RequestMethod.GET)
    public String getPassword(@PathVariable("password") String password) {
        return new BCryptPasswordEncoder().encode(password);
    }
}

package io.khasang.training_hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AppController {

    // http://localhost:8080
    @RequestMapping("/")
    public String helloPage(Model model) {
        model.addAttribute("name", "Jack Sparrow");
        return "hello";
    }
}

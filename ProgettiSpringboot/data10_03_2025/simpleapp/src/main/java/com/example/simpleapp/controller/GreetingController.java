package com.example.simpleapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.simpleapp.service.GreetingService;

@RestController
@RequestMapping("/api") // mappiamo la funzione in modo che si occupi delle pagine dallo /api in poi
public class GreetingController {
    private final GreetingService greetingService;

    // Injection
    public GreetingController(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    @GetMapping("/greet")
    public String greet() {
        return greetingService.getGreeting();
    }
}

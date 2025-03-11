package com.example.simpleapp.service;

import org.springframework.stereotype.Service;

@Service
public class GreetingService {
    public String getGreeting() {
        return "Ciao, benvenuto nella gang potent";
    }
}

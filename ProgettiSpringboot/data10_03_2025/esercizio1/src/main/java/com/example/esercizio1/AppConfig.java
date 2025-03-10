package com.example.esercizio1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public IShippingService ExpressShippingService() {
        return new CustomShippingService();
    }
}

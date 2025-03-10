package com.example.esercizio1;

import org.springframework.beans.factory.annotation.Qualifier;

public class OrderService {
    private final IShippingService standardIShippingService;
    private final IShippingService expressIShippingService;

    public OrderService(@Qualifier("standardShippingService") IShippingService standardIShippingService,
            @Qualifier("expressShippingService") IShippingService expressIShippingService) {
        this.standardIShippingService = standardIShippingService;
        this.expressIShippingService = expressIShippingService;
    }

    public double getTotalShippingCost(String shipmentType, String country, double weight) {

        if (shipmentType.equalsIgnoreCase("standard"))
            return standardIShippingService.calculateShippingCost(country, weight);

        else if (shipmentType.equalsIgnoreCase("express"))
            return expressIShippingService.calculateShippingCost(country, weight);

        else
            return 0.0;

    }
}

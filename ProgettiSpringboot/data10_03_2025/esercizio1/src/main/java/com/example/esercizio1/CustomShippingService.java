package com.example.esercizio1;

public class CustomShippingService implements IShippingService {

    @Override
    public double calculateShippingCost(String country, double weight) {
        double shippingCost = 0;

        switch (country) {
            case "EUROPE":
                shippingCost = 25 + weight * 3;
                break;

            case "USA":
                shippingCost = 20 + weight * 2.5;
                break;

            case "OTHER":
                shippingCost = 35 + weight * 3.5;
                break;

            default:
                shippingCost = weight * 10;
                break;
        }

        return shippingCost;
    }

}

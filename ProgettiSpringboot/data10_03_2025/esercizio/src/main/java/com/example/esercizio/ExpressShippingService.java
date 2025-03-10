package com.example.esercizio;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("expressShippingService")
public class ExpressShippingService implements IShippingService {
    private final double TARIFFA_FISSA = 100.0;

    @Override
    public double calculateShippingCost(String country, double weight) {
        double shippingCost = 0;

        switch (country) {
            case "EUROPE":
                shippingCost = TARIFFA_FISSA + (weight * 0.10);
                break;

            case "USA":
                shippingCost = TARIFFA_FISSA + (weight * 0.50);
                break;

            case "OTHER":
                shippingCost = TARIFFA_FISSA + (weight * 0.30);
                break;

            default:
                shippingCost = TARIFFA_FISSA * 3;
                break;
        }

        return shippingCost;
    }

}

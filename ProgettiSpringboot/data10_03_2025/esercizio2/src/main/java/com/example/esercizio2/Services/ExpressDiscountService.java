package com.example.esercizio2.Services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.example.esercizio2.Interfaces.IDiscountService;

@Service
@Qualifier("expressDiscountService")
public class ExpressDiscountService implements IDiscountService {

    @Override
    public double applyDiscount(double orderTotal) {
        if (orderTotal < 100) {
            return 0;
        } else if (orderTotal < 200) {
            return orderTotal * 0.07;
        } else {
            return orderTotal * 0.12;
        }
    }
}
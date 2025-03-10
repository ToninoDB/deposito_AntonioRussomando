package com.example.esercizio2.Services;

import org.springframework.beans.factory.annotation.Qualifier;

import com.example.esercizio2.Interfaces.IDiscountService;
import com.example.esercizio2.Interfaces.IShippingService;

public class OrderService {

    private final IDiscountService standardDiscountService;
    private final IDiscountService expressDiscountService;
    private final IShippingService standardShippingService;
    private final IShippingService expressShippingService;

    public OrderService(@Qualifier("standardDiscountService") IDiscountService standardDiscountService,
            @Qualifier("expressDiscountService") IDiscountService expressDiscountService,
            @Qualifier("standardShippingService") IShippingService standardShippingService,
            @Qualifier("expressShippingService") IShippingService expressShippingService) {

        this.standardDiscountService = standardDiscountService;
        this.standardShippingService = standardShippingService;
        this.expressDiscountService = expressDiscountService;
        this.expressShippingService = expressShippingService;
    }

    @SuppressWarnings("null")
    public double getTotalOrder(double orderTotal, String discountType, String shippingType, String country,
            double weight) {
        IDiscountService discount = null;
        IShippingService shipping = null;
        double discountApply;
        double shippingApply;

        switch (discountType) {
            case "standard":
                discount = standardDiscountService;
                break;

            case "express":
                discount = expressDiscountService;
                break;

            default:
                break;
        }

        switch (shippingType) {
            case "standard":
                shipping = standardShippingService;
                break;

            case "express":
                shipping = expressShippingService;
                break;

            default:
                break;
        }

        discountApply = discount.applyDiscount(orderTotal);
        shippingApply = shipping.calculateShippingCost(country, weight);

        return orderTotal - discountApply + shippingApply;
    }
}

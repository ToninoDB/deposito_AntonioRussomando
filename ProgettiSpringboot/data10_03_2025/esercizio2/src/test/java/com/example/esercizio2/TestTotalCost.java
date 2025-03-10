package com.example.esercizio2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.esercizio2.Interfaces.IDiscountService;
import com.example.esercizio2.Interfaces.IShippingService;
import com.example.esercizio2.Services.ExpressDiscountService;
import com.example.esercizio2.Services.ExpressShippingService;
import com.example.esercizio2.Services.OrderService;
import com.example.esercizio2.Services.StandardDiscountService;
import com.example.esercizio2.Services.StandardShippingService;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) // ✅ Correct way to exclude DB auto-config
public class TestTotalCost {

    private final IShippingService standardShippingService = new StandardShippingService();
    private final IShippingService expressShippingService = new ExpressShippingService();
    private final IDiscountService standardDiscountService = new StandardDiscountService();
    private final IDiscountService expressDiscountService = new ExpressDiscountService();
    private final OrderService orderService = new OrderService(standardDiscountService, expressDiscountService,
            standardShippingService, expressShippingService);

    @Test
    public void testTotalORderCost() {
        double result = orderService.getTotalOrder(100, "standard", "standard", "europe", 4);
        assertEquals(118, result);
    }
}

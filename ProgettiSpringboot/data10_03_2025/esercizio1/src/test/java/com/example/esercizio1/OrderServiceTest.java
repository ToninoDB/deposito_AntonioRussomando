package com.example.esercizio1;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@ImportAutoConfiguration(exclude = DataSourceAutoConfiguration.class) // ✅ Correct way to exclude DB auto-config
public class OrderServiceTest {

    private final IShippingService standardShippingService = new StandardShippingService();
    private final IShippingService expressShippingService = new ExpressShippingService();
    private final OrderService orderService = new OrderService(standardShippingService, expressShippingService);

    @Test
    public void testStandardShippingService() {
        double result = standardShippingService.calculateShippingCost("EUROPE", 10);
        assertEquals(35, result);
    }

    @Test
    public void testExpressShippingService() {
        double result = expressShippingService.calculateShippingCost("EUROPE", 10);
        assertEquals(65, result);
    }

    @Test
    public void testOrderService() {
        double result = orderService.getTotalShippingCost("express", "europe", 10);
        assertEquals(65, result);
    }
}
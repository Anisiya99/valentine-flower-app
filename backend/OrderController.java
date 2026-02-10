package com.valentine.flowers.controller;

import com.valentine.flowers.model.Order;
import com.valentine.flowers.service.OrderService;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @PostMapping("/order")
    public String placeOrder(@RequestBody Order order) {
        return service.placeOrder(order);
    }
}


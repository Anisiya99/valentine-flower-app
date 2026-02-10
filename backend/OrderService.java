package com.valentine.flowers.service;

import com.valentine.flowers.model.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    public String placeOrder(Order order) {
        return "Order confirmed for " + order.receiverName + " ❤️";
    }
}


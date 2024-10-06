package com.walker.spring.boot.desafio1.devsuperior.service;

import com.walker.spring.boot.desafio1.devsuperior.entity.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final ShippingService shippingService;

    public OrderService(ShippingService shippingService, Order order) {
        this.shippingService = shippingService;
    }

    public Double total(Order order) {
        return order.getBasic() - (order.getDiscount() * order.getBasic() / 100) + shippingService.shipment(order);
    }


}

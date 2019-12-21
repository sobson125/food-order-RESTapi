package com.example.foodorderrestapi.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    @PostMapping
    public void addOrder(@RequestBody CreateOrderRequest orderRequest) {
        orderService.addOrder(orderRequest.getStreet());
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable Long id, @RequestBody UpdateOrderRequest orderRequest) {
        orderService.updateOrder(id, orderRequest.getStreet());
    }

    @DeleteMapping("/{id}")
    public void updateOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }
}

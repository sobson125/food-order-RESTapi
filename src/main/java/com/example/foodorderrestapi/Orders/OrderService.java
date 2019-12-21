package com.example.foodorderrestapi.Orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private final AtomicLong nextTaskId = new AtomicLong(0L);

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    public Order getOrderById(Long id) {
        return orderRepository.findById(id).get();
    }

    public void addOrder(String street) {
        Order order = new Order();
        order.setLocalDateTime(LocalDateTime.now());
        order.setStreet(street);
        orderRepository.save(order);
    }

    public void updateOrder(Long id, String street) {
        Order orderById = getOrderById(id);
        orderById.setStreet(street);
        orderRepository.save(orderById);
    }

    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

package com.example.foodorderrestapi.Orders;

import com.example.foodorderrestapi.Orders.DTO.CreateOrderRequest;
import com.example.foodorderrestapi.Orders.DTO.OrderResponse;
import com.example.foodorderrestapi.Orders.DTO.UpdateOrderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<OrderResponse> getAllOrders(@RequestParam(required = false) String query) {
        List<Order> response;
        if (query != null) {
            response = orderService.getAllOrdersByQuery(query);
        } else {
            response = orderService.getAllOrders();
        }
        return response
                .stream()
                .map(this::createOrderResponse
                )
                .collect(toList());
    }

    @GetMapping("/{id}")
    public OrderResponse getOrder(@PathVariable Long id) {
        Order orderById = orderService.getOrderById(id);
        return createOrderResponse(orderById);
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

    //METHODS THAT DON'T MANAGE MAPPING
    private OrderResponse createOrderResponse(Order order) {
        return new OrderResponse(
                order.getId(),
                order.getStreet(),
                order.getLocalDateTime(),
                order.getDishes());
    }
}

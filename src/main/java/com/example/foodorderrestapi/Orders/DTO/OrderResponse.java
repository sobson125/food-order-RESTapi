package com.example.foodorderrestapi.Orders.DTO;

import com.example.foodorderrestapi.Dishes.Dish;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class OrderResponse {
    private Long id;
    private String street;
    private LocalDateTime localDateTime;
    private List<Dish> dishes;
}

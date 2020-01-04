package com.example.foodorderrestapi.Dishes.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DishResponse {
    private Long id;
    private String name;
    private Float price;
}

package com.example.foodorderrestapi.Dishes.DTO;

import lombok.Data;

@Data
public class CreateDishRequest {
    private String name;
    private Float price;
}

package com.example.foodorderrestapi.Dishes;

import lombok.Data;

@Data
public class UpdateDishRequest {
    private String name;
    private Float price;
}

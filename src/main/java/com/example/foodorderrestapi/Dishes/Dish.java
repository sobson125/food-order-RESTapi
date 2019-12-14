package com.example.foodorderrestapi.Dishes;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Dish {

    private String id;
    private String name;
    private Float price;


//   public enum FoodName {
//       PIZZA, BURGER, CHEESEBURGER, SPAGHETTI, SALAD, FRIES
//    }
}

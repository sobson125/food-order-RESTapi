package com.example.foodorderrestapi.Dishes;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {


    @GetMapping
    public List<Dish> getDishes() {
        return List.of(
                new Dish("1", "pizza", 20f),
                new Dish("2", "spaghetti", 20f),
                new Dish("3", "cheeseburger", 20f)
        );
    }
}

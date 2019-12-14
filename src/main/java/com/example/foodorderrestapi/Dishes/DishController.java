package com.example.foodorderrestapi.Dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/dishes")
public class DishController {

    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping
    public List<Dish> getAllDishes() {
        return dishService.getAllDishes();
    }

    @GetMapping("/{id}")
    public Dish getDish(@PathVariable String id){
        return dishService.getDishById(id);
    }

    @PostMapping
    public void addDish(@RequestBody Dish dish){
        dishService.addDish(dish);
    }
}

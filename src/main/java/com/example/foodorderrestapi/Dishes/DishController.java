package com.example.foodorderrestapi.Dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController(value = "api/orders")
public class DishController {

    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping(value = "/{orderId}/dishes")
    public List<Dish> getAllDishes(@PathVariable Long orderId) {
        return dishService.getAllDishes(orderId);
    }


    @GetMapping("/{orderid}/dishes/{id}")
    public Dish getDish(@PathVariable Long id) {
        return dishService.getDishById(id);
    }

    @PostMapping("/api/orders/{orderid}/dishes")
    public void addDish(@PathVariable Long orderid, @RequestBody CreateDishRequest dishRequest) {
        dishService.addDish(dishRequest);
    }

    @PutMapping("/{orderid}/dishes/{id}")
    public void updateDish(@PathVariable Long id, @RequestBody Dish dish) {
        dishService.updateDish(id, dish);
    }

    @DeleteMapping("/{id}")
    public void updateDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}

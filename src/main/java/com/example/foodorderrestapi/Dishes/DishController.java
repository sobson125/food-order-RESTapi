package com.example.foodorderrestapi.Dishes;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders/{orderid}")
@Slf4j
public class DishController {

    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @GetMapping("/dishes")
    public List<Dish> getAllDishes(@PathVariable Long orderid) {
        log.info("printing all dishes in orders with id: {}", orderid);
        return dishService.getAllDishes(orderid);
    }


    @GetMapping("/dishes/{id}")
    public Dish getDish(@PathVariable Long id, @PathVariable Long orderid) {
        log.info("printing dish with id: {} in orders with id: {}", id, orderid);
        return dishService.getDishById(id);
    }

    @PostMapping("/dishes")
    public void addDish(@PathVariable Long orderid, @RequestBody CreateDishRequest dishRequest) {
        dishService.addDish(dishRequest, orderid);
    }

    @PutMapping("/dishes/{id}")
    public void updateDish(@PathVariable Long id, @RequestBody UpdateDishRequest dishRequest) {
        dishService.updateDish(id, dishRequest.getName(), dishRequest.getPrice());
    }

    @DeleteMapping("/dishes/{id}")
    public void updateDish(@PathVariable Long id) {
        dishService.deleteDish(id);
    }
}

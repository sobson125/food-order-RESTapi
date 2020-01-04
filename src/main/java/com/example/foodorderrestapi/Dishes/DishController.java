package com.example.foodorderrestapi.Dishes;

import com.example.foodorderrestapi.Dishes.DTO.CreateDishRequest;
import com.example.foodorderrestapi.Dishes.DTO.DishResponse;
import com.example.foodorderrestapi.Dishes.DTO.UpdateDishRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

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
    public List<DishResponse> getAllDishes(@PathVariable Long orderid) {
        log.info("printing all dishes in orders with id: {}", orderid);
        return dishService.getAllDishes(orderid)
                .stream()
                .map(dish -> createDishResponse(dish)
                )
                .collect(toList());
    }

    private DishResponse createDishResponse(Dish dish) {
        return new DishResponse(
                dish.getId(),
                dish.getName(),
                dish.getPrice());
    }


    @GetMapping("/dishes/{id}")
    public DishResponse getDish(@PathVariable Long id, @PathVariable Long orderid) {
        log.info("printing dish with id: {} in orders with id: {}", id, orderid);
        Dish dishById = dishService.getDishById(id);
        return createDishResponse(dishById);
    }

    @PostMapping("/dishes")
    public void addDish(@PathVariable Long orderid, @RequestBody CreateDishRequest dishRequest) {
        dishService.addDish(dishRequest.getName(), dishRequest.getPrice(), orderid);
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

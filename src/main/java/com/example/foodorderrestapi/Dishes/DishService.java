package com.example.foodorderrestapi.Dishes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DishService {

    private DishRepository dishRepository;

    @Autowired
    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public List<Dish> getAllDishes(Long id) {
        return dishRepository.findDishesByOrderId(id);
    }

    public Dish getDishById(Long id) {
        return dishRepository.findById(id).get();
    }

    public void addDish(CreateDishRequest dishRequest) {
        Dish dish = new Dish();
        dish.setName(dishRequest.getName());
        dish.setPrice(dishRequest.getPrice());
        dishRepository.save(dish);
    }

    public void updateDish(Long id, Dish newDish) {
        dishRepository.save(newDish);
    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}

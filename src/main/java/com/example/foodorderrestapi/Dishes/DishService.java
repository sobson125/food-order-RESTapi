package com.example.foodorderrestapi.Dishes;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DishService {

    private List<Dish> dishes = Stream.of(
            new Dish("1", "pizza", 20f),
            new Dish("2", "spaghetti", 20f),
            new Dish("3", "cheeseburger", 20f))
            .collect(Collectors.toList());


    public List<Dish> getAllDishes() {
        return dishes;
    }

    public Dish getDishById(String id) {
        return getDishStream(id)
                .findFirst()
                .get();
    }

    private Stream<Dish> getDishStream(String id) {
        return dishes.stream()
                .filter(dish -> dish.getId().equals(id));
    }

    public void addDish(Dish dish) {
        dishes.add(dish);
    }

    public void updateDish(String id, Dish newDish) {
        dishes.stream()
                .filter(oldDish -> oldDish.getId().equals(id))
                .forEach(oldDish -> dishes.set(dishes.indexOf(oldDish), newDish));
    }

    public void deleteDish(String id) {
        dishes.removeIf(dish -> dish.getId().equals(id));
    }
}

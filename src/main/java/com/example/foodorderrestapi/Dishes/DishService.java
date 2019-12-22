package com.example.foodorderrestapi.Dishes;

import com.example.foodorderrestapi.Orders.Order;
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
        return dishRepository.findByOrderId(id);
    }

    public Dish getDishById(Long id) {
        return dishRepository.findById(id).get();
    }

    public void addDish(CreateDishRequest dishRequest, long orderId) {
        Dish dish = new Dish();
        dish.setName(dishRequest.getName());
        dish.setPrice(dishRequest.getPrice());
        Order order = new Order();
        order.setId(orderId);
        dish.setOrder(order);
        dishRepository.save(dish);
    }

    public void updateDish(Long id, String name, Float price) {
        Dish dish = getDishById(id);
        dish.setPrice(price);
        dish.setName(name);
        dishRepository.save(dish);

    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }
}

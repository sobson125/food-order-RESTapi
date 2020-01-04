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

    public void addDish(String name, Float price, long orderId) {
        Dish dish = new Dish();
        setDishProperties(name, price, dish);
        Order order = new Order();
        order.setId(orderId);
        dish.setOrder(order);
        dishRepository.save(dish);
    }

    public void updateDish(Long id, String name, Float price) {
        Dish dish = getDishById(id);
        setDishProperties(name, price, dish);
        dishRepository.save(dish);

    }

    public void deleteDish(Long id) {
        dishRepository.deleteById(id);
    }

    private void setDishProperties(String name, Float price, Dish dish) {
        dish.setName(name);
        dish.setPrice(price);
    }
}

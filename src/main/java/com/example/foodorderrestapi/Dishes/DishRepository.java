package com.example.foodorderrestapi.Dishes;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish,Long> {
    List<Dish> findByOrderId(Long id);
}

package com.example.foodorderrestapi.Orders;

import com.example.foodorderrestapi.Dishes.Dish;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")

public class Order {

    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private LocalDateTime localDateTime;
    @OneToMany(mappedBy = "order")
    private List<Dish> dishes;
}

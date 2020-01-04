package com.example.foodorderrestapi.Dishes;

import com.example.foodorderrestapi.Orders.Order;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    @ManyToOne
    @JsonBackReference
    private Order order;


//   public enum FoodName {
//       PIZZA, BURGER, CHEESEBURGER, SPAGHETTI, SALAD, FRIES
//    }
}

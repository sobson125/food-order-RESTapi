package com.example.foodorderrestapi.Dishes;

import com.example.foodorderrestapi.Orders.Order;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Dishes")
public class Dish {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Float price;
    @ManyToOne
    private Order order;


//   public enum FoodName {
//       PIZZA, BURGER, CHEESEBURGER, SPAGHETTI, SALAD, FRIES
//    }
}

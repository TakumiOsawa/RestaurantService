package com.ftgo.RestaurantService.domain.restaurant.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "restaurants")
@Access(AccessType.FIELD)
@Data
public class Restaurant {
    @Id
    @Column(name = "restaurant_id")
    private Long id;

    @Column(name = "restaurant_name")
    private String name;

    @Embedded
    private RestaurantMenuOnDB menu;

    public Restaurant() {}

    public Restaurant(String name, RestaurantMenuOnDB menu) {
        id = Math.abs(new Random().nextLong());
        this.name = name;
        this.menu = menu;
    }
}
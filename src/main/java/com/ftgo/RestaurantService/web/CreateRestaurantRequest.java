package com.ftgo.RestaurantService.web;

import com.ftgo.RestaurantService.domain.Address;
import com.ftgo.RestaurantService.domain.restaurant.RestaurantMenu;
import lombok.Data;

@Data
public class CreateRestaurantRequest {
    private String name;
    private Address address;
    private RestaurantMenu menu;

    public CreateRestaurantRequest(String name, Address address, RestaurantMenu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
}

package com.ftgo.RestaurantService.web;

import com.ftgo.RestaurantService.domain.Address;
import com.ftgo.RestaurantService.domain.restaurant.MenuItem;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {
    private String name;
    private Address address;
    private List<MenuItem> menu;

    public CreateRestaurantRequest() {}

    public CreateRestaurantRequest(String name, Address address, List<MenuItem> menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
}

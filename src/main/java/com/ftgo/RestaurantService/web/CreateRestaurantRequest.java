package com.ftgo.RestaurantService.web;

import com.ftgo.RestaurantService.domain.Address;
import com.ftgo.RestaurantService.domain.restaurant.entity.MenuItemOnDB;
import lombok.Data;

import java.util.List;

@Data
public class CreateRestaurantRequest {
    private String name;
    private Address address;
    private List<MenuItemOnDB> menu;

    public CreateRestaurantRequest() {}

    public CreateRestaurantRequest(String name, Address address, List<MenuItemOnDB> menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
}

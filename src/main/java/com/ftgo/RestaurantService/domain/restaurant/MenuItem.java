package com.ftgo.RestaurantService.domain.restaurant;

import com.ftgo.RestaurantService.domain.Money;
import com.ftgo.RestaurantService.domain.restaurant.entity.MenuItemOnDB;
import lombok.Getter;

@Getter
public class MenuItem {
    private String id;
    private String name;
    private Money price;

    private MenuItem(String id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public MenuItem create(String id, String name, Money price) {
        return new MenuItem(id, name, price);
    }

    public MenuItemOnDB transformEmbeddable() {
        return new MenuItemOnDB(id, name, price);
    }
}

package com.ftgo.RestaurantService.domain.restaurant;

import com.ftgo.RestaurantService.domain.restaurant.entity.RestaurantMenuOnDB;
import lombok.Data;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

public class RestaurantMenu {
    @Getter
    private List<MenuItem> menuItems;

    private RestaurantMenu(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    public RestaurantMenu create(List<MenuItem> menuItems) {
        return new RestaurantMenu(menuItems);
    }

    public RestaurantMenuOnDB transformEmbeddable() {
        return new RestaurantMenuOnDB(
                menuItems.stream()
                        .map(MenuItem::transformEmbeddable)
                        .collect(Collectors.toList()));
    }
}

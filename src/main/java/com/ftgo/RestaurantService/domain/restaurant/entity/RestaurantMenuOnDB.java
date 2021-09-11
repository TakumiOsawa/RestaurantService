package com.ftgo.RestaurantService.domain.restaurant.entity;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Embeddable;
import java.util.List;

@Embeddable
@Data
public class RestaurantMenuOnDB {
    @ElementCollection
    @CollectionTable(name = "menu_items")
    private List<MenuItemOnDB> menuItems;

    public RestaurantMenuOnDB() {}

    public RestaurantMenuOnDB(List<MenuItemOnDB> menuItems) {
        this.menuItems = menuItems;
    }
}

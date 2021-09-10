package com.ftgo.RestaurantService.domain.restaurant.entity;

import com.ftgo.RestaurantService.domain.Money;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Embedded;

@Data
@Embeddable
public class MenuItemOnDB {
    @Column(name = "menu_item_id")
    private String id;

    @Column(name = "menu_item_name")
    private String name;

    @Embedded
    private MoneyOnDB price;

    public MenuItemOnDB() {}

    public MenuItemOnDB(String id, String name, Money price) {
        this.id = id;
        this.name = name;
        this.price = price.transformEmbeddable();
    }
}

package com.ftgo.RestaurantService.domain.restaurant.entity;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class MoneyOnDB {
    @Getter
    @Column(name = "price")
    private long value;

    public MoneyOnDB() {}

    public MoneyOnDB(long value) {
        this.value = value;
    }
}

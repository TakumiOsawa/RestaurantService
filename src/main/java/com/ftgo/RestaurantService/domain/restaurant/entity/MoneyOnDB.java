package com.ftgo.RestaurantService.domain.restaurant.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@Data
public class MoneyOnDB {
    @Column(name = "price")
    private long value;

    public MoneyOnDB() {}

    public MoneyOnDB(long value) {
        this.value = value;
    }
}
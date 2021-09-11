package com.ftgo.RestaurantService.domain;

import com.ftgo.RestaurantService.domain.restaurant.entity.MoneyOnDB;
import lombok.Getter;

public class Money {
    @Getter
    private final long value;

    /**
     * Constructor
     * @param value value
     */
    private Money(long value) {
        this.value = value;
    }

    /**
     * Create Money.
     * @param value value
     * @return instance of Money.
     */
    public static Money create(long value) {
        return new Money(value);
    }

    public MoneyOnDB transformEmbeddable() {
        return new MoneyOnDB(value);
    }
}

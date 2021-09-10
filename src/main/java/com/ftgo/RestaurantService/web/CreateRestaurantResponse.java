package com.ftgo.RestaurantService.web;

import lombok.Data;

@Data
public class CreateRestaurantResponse {
    private long id;

    public CreateRestaurantResponse(long id) {
        this.id = id;
    }
}

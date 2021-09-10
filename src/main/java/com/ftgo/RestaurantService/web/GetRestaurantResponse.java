package com.ftgo.RestaurantService.web;

import lombok.Data;

@Data
public class GetRestaurantResponse {
    private Long id;
    private String name;

    public GetRestaurantResponse(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}

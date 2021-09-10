package com.ftgo.RestaurantService.event;

import com.ftgo.RestaurantService.domain.Address;
import com.ftgo.RestaurantService.domain.restaurant.RestaurantMenu;
import lombok.Data;

@Data
public class RestaurantCreated  implements RestaurantDomainEvent {
    private String name;
    private Address address;
    private RestaurantMenu menu;

    public RestaurantCreated(String name, Address address, RestaurantMenu menu) {
        this.name = name;
        this.address = address;
        this.menu = menu;
    }
}
package com.ftgo.RestaurantService.domain;

import lombok.Data;

@Data
public class Address {
    private String street1;
    private String street2;
    private String city;
    private String state;
    private String zip;

    private Address(String street1, String street2, String city, String state, String zip) {
        this.street1 = street1;
        this.street2 = street2;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public static Address create(String street1, String street2, String city, String state, String zip) {
        return new Address(street1, street2, city, state, zip);
    }
}

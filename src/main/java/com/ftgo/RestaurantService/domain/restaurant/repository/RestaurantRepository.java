package com.ftgo.RestaurantService.domain.restaurant.repository;

import com.ftgo.RestaurantService.domain.restaurant.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
}

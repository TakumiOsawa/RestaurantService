package com.ftgo.RestaurantService;

import com.ftgo.RestaurantService.domain.Money;
import com.ftgo.RestaurantService.domain.restaurant.MenuItem;
import com.ftgo.RestaurantService.domain.restaurant.RestaurantMenu;
import com.ftgo.RestaurantService.domain.restaurant.entity.Restaurant;
import com.ftgo.RestaurantService.domain.restaurant.repository.RestaurantRepository;
import com.ftgo.RestaurantService.event.RestaurantCreated;
import com.ftgo.RestaurantService.event.RestaurantDomainEventPublisher;
import com.ftgo.RestaurantService.web.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;
import java.util.stream.Collectors;

@Transactional
public class RestaurantService {
    private final RestaurantRepository restaurantRepository;
    private final RestaurantDomainEventPublisher domainEventPublisher;

    public RestaurantService(@Autowired RestaurantRepository restaurantRepository,
                             @Autowired RestaurantDomainEventPublisher domainEventPublisher) {
        this.restaurantRepository = restaurantRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public Restaurant create(CreateRestaurantRequest request) {
        RestaurantMenu menu = RestaurantMenu.create(request.getMenu().stream()
                .map(it -> MenuItem.create(it.getId(), it.getName(),
                        Money.create(it.getPrice().getValue())))
                .collect(Collectors.toList()));
        Restaurant restaurant = new Restaurant(request.getName(), menu.transformEmbeddable());
        restaurantRepository.save(restaurant);
        domainEventPublisher.publish(restaurant, Collections.singletonList(
                new RestaurantCreated(request.getName(), request.getAddress(), menu)));
        return restaurant;
    }

    public Optional<Restaurant> findById(long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }
}
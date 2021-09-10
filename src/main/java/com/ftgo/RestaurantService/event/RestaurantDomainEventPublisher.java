package com.ftgo.RestaurantService.event;

import com.ftgo.RestaurantService.domain.restaurant.entity.Restaurant;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

public class RestaurantDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Restaurant> {
    public RestaurantDomainEventPublisher(DomainEventPublisher eventPublisher) {
        super(eventPublisher, Restaurant.class, Restaurant::getId);
    }
}
package com.ftgo.RestaurantService.event;

import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.publisher.DomainEventPublisher;

import java.util.List;
import java.util.function.Function;

public class AbstractAggregateDomainEventPublisher<A> {
    private final Function<A, Object> idSupplier;
    private final DomainEventPublisher eventPublisher;
    private final Class<A> aggregateType;

    protected AbstractAggregateDomainEventPublisher(DomainEventPublisher eventPublisher,
                                                    Class<A> aggregateType,
                                                    Function<A, Object> idSupplier) {
        this.eventPublisher = eventPublisher;
        this.aggregateType = aggregateType;
        this.idSupplier = idSupplier;
    }

    public void publish(A aggregate, List<DomainEvent> events) {
        eventPublisher.publish(aggregateType, idSupplier.apply(aggregate), events);
    }
}
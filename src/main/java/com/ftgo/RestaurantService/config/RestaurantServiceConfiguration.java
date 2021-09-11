package com.ftgo.RestaurantService.config;

import com.ftgo.RestaurantService.RestaurantService;
import com.ftgo.RestaurantService.domain.restaurant.repository.RestaurantRepository;
import com.ftgo.RestaurantService.event.RestaurantDomainEventPublisher;
import io.eventuate.tram.consumer.common.DuplicateMessageDetector;
import io.eventuate.tram.consumer.common.NoopDuplicateMessageDetector;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import io.eventuate.tram.sagas.spring.participant.SagaParticipantConfiguration;
import io.eventuate.tram.spring.consumer.kafka.EventuateTramKafkaMessageConsumerConfiguration;
import io.eventuate.tram.spring.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.spring.messaging.producer.jdbc.TramMessageProducerJdbcConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({TramEventsPublisherConfiguration.class,
        TramMessageProducerJdbcConfiguration.class,
        EventuateTramKafkaMessageConsumerConfiguration.class,
        SagaParticipantConfiguration.class })
public class RestaurantServiceConfiguration {
    @Bean
    public RestaurantService restaurantService(RestaurantRepository restaurantRepository,
                                          RestaurantDomainEventPublisher eventPublisher) {
        return new RestaurantService(restaurantRepository, eventPublisher);
    }

    @Bean
    public RestaurantDomainEventPublisher restaurantAggregateEventPublisher(DomainEventPublisher eventPublisher) {
        return new RestaurantDomainEventPublisher(eventPublisher);
    }

    @Bean
    public DuplicateMessageDetector duplicateMessageDetector() {
        return new NoopDuplicateMessageDetector();
    }
}

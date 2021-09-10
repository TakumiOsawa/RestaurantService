package com.ftgo.RestaurantService.web;

import com.ftgo.RestaurantService.RestaurantService;
import com.ftgo.RestaurantService.domain.restaurant.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class RestaurantController {
    private final RestaurantService restaurantService;

    public RestaurantController(@Autowired RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/hcheck")
    @ResponseStatus(HttpStatus.OK)
    public HealthCheckResponse healthCheck() {
        return new HealthCheckResponse();
    }

    @PostMapping("/restaurants")
    public CreateRestaurantResponse create(@RequestBody CreateRestaurantRequest request) {
        Restaurant r = restaurantService.create(request);
        return new CreateRestaurantResponse(r.getId());
    }

    @GetMapping("/restaurants/{restaurantId}")
    public ResponseEntity<GetRestaurantResponse> get(@PathVariable long restaurantId) {
        return restaurantService.findById(restaurantId)
                .map(r -> new ResponseEntity<>(makeGetRestaurantResponse(r), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    private GetRestaurantResponse makeGetRestaurantResponse(Restaurant r) {
        return new GetRestaurantResponse(r.getId(), r.getName());
    }
}
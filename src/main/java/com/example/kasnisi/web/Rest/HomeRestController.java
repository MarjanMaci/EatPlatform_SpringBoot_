package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.service.RestaurantService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/home")
public class HomeRestController {
    private final RestaurantService restaurantService;

    public HomeRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping
    public List<Restaurants> getAll(){
        return restaurantService.getAllRestaurants();
    }
}

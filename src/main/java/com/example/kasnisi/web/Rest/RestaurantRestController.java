package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.model.dto.RestaurantDto;
import com.example.kasnisi.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/restaurant")
public class RestaurantRestController {
    private final RestaurantService restaurantService;

    public RestaurantRestController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @GetMapping("/{restName}")
    public List<MenuEntry> findAllByRestaurant(@PathVariable String restName){
        return restaurantService.getMealsByRestaurant(restName);
    }

    @PostMapping("/add")
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto) {
        if(this.restaurantService.addRestaurant(restaurantDto)!=null) {
                return ResponseEntity.ok().body(restaurantDto);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

}

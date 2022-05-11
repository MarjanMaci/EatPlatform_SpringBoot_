package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.model.dto.RestaurantDto;
import com.example.kasnisi.service.RestaurantService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping("/get/{id}")
    public ResponseEntity<Optional<Restaurants>> findRestaurant(@PathVariable Long id){
        if(this.restaurantService.findById(id).isPresent()){
            return ResponseEntity.ok().body(this.restaurantService.findById(id));
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/add")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RestaurantDto> save(@RequestBody RestaurantDto restaurantDto) {
        if(this.restaurantService.addRestaurant(restaurantDto)!=null) {
                return ResponseEntity.ok().body(restaurantDto);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<RestaurantDto> edit(@PathVariable Long id,@RequestBody RestaurantDto restaurantDto) {
        if(this.restaurantService.edit(id,restaurantDto.getName(), restaurantDto.getAddress(), restaurantDto.getOpens(), restaurantDto.getCloses(), restaurantDto.getAvgOrderComp(), restaurantDto.getImg())!=null) {
            return ResponseEntity.ok().body(restaurantDto);
        }else{
            return ResponseEntity.badRequest().build();
        }
    }

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity delete(@PathVariable Long id) {
       this.restaurantService.deleteRestaurant(id);
       if(this.restaurantService.findById(id).isEmpty())
           return ResponseEntity.ok().build();
       else
           return ResponseEntity.notFound().build();
    }

}

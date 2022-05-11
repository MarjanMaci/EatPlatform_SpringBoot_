package com.example.kasnisi.web;

import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.service.RestaurantService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("restaurant")
public class RestaurantController {
    public RestaurantService restaurantService;

    public RestaurantController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }

    @GetMapping()
    public String getRestaurants(Model model){
        model.addAttribute("restaurants",restaurantService.getAllRestaurants());
        return "restaurants";
    }

    @GetMapping("/add")
    public String addRestaurant(Model model){
        return "restaurantt-add";
    }

    @GetMapping("/delete/{id}")
    public String deleteRestaurant(@PathVariable Long id){
        this.restaurantService.deleteRestaurant(id);
        return "redirect:/restaurant";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
        model.addAttribute("restaurant",this.restaurantService.findById(id));
        return "restaurantt-add";
    }

    @GetMapping("/{restName}")
    public String getRestaurantMeals(@PathVariable String restName, Model model){
        model.addAttribute("restaurant",restaurantService.findByName(restName));
        model.addAttribute("mealsByRestaurant", restaurantService.getMealsByRestaurant(restName));
        return "rest-meals";
    }

    @PostMapping("/add")
    public String addRestaurant2(@RequestParam(required = false) Long id,
                                @RequestParam String name,
                                @RequestParam String address,
                                @RequestParam String opens,
                                @RequestParam String closes,
                                @RequestParam String avgOrderCompletion,
                                 @RequestParam String img) {
        Long avgOrderComp=Long.parseLong(avgOrderCompletion);
        if(id!=null){
            this.restaurantService.edit(id,name,address,opens,closes,avgOrderComp,img);
        }else {
            this.restaurantService.addRestaurant(new Restaurants(name,address,opens,closes,avgOrderComp,img));
        }
        return "redirect:/restaurant";
    }
}

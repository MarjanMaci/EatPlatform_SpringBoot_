package com.example.kasnisi.web;

import com.example.kasnisi.service.RestaurantService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping(value = {"/home", "/"})
public class HomeController {
    private final RestaurantService restaurantService;

    public HomeController(RestaurantService restaurantService){
        this.restaurantService=restaurantService;
    }

    @GetMapping
    public String getHomePage(Model model){
        model.addAttribute("restaurants", restaurantService.getAllRestaurants());
        return "home";
    }
}

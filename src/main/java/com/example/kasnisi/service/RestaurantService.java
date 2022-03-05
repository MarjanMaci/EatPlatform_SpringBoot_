package com.example.kasnisi.service;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;

import java.util.List;

public interface RestaurantService {
    List<Restaurants> getAllRestaurants();
    Restaurants findByName(String name);
    List<MenuEntry> getMealsByRestaurant(String name);
    void deleteRestaurant(Long id);
    Restaurants findById(Long id);
    Restaurants edit(Long id,String name, String address, String opens, String closes, Long avgOrderCompletition);
    Restaurants addRestaurant(String name, String address, String opens, String closes, Long avgOrderCompletition);
}


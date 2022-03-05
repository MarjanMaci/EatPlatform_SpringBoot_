package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.model.exceptions.RestaurantNotFound;
import com.example.kasnisi.repository.RestaurantRepository;
import com.example.kasnisi.service.RestaurantService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
    private final RestaurantRepository restaurantRepository;

    public RestaurantServiceImpl(RestaurantRepository restaurantRepository){
        this.restaurantRepository=restaurantRepository;
    }

    @Override
    public List<Restaurants> getAllRestaurants() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurants findByName(String name) {
        return restaurantRepository.findByName(name).orElseThrow(()->new RestaurantNotFound());
    }

    @Override
    public List<MenuEntry> getMealsByRestaurant(String name) {
        Restaurants mealsBy = restaurantRepository.findByName(name).orElseThrow(()->new RestaurantNotFound());
        List<MenuEntry> toReturn = mealsBy.getMenuEntries();
        return toReturn;
    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Restaurants findById(Long id) {
        return restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFound());
    }

    @Override
    public Restaurants addRestaurant(String name, String address, String opens, String closes, Long avgOrderCompletition) {
        Restaurants newone= new Restaurants(name,address,opens,closes,avgOrderCompletition);
        return restaurantRepository.save(newone);
    }

    @Override
    public Restaurants edit(Long id, String name, String address, String opens, String closes, Long avgOrderCompletition) {
        Restaurants toEdit = restaurantRepository.findById(id).orElseThrow(()->new RestaurantNotFound());
        toEdit.setName(name);
        toEdit.setAddress(address);
        toEdit.setOpens(opens);
        toEdit.setCloses(closes);
        toEdit.setAvgOrderCompletion(avgOrderCompletition);
        return restaurantRepository.save(toEdit);
    }
}
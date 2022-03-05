package com.example.kasnisi.repository;

import com.example.kasnisi.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RestaurantRepository extends JpaRepository<Restaurants,Long> {
    List<Restaurants> findAll();
    Optional<Restaurants> findByName(String name);
    Optional<Restaurants> findById(Long id);
    void deleteById(Long id);
}

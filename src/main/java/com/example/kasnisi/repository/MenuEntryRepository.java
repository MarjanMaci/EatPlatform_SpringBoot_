package com.example.kasnisi.repository;

import com.example.kasnisi.model.MenuCategories;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MenuEntryRepository extends JpaRepository<MenuEntry,Long> {
    Optional<MenuEntry> findById(Long id);
    List<MenuEntry> findAllByMenuCategory(MenuCategories menuCategories);
}

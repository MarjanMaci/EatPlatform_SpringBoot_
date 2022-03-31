package com.example.kasnisi.service;

import com.example.kasnisi.model.MenuCategories;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;

import java.util.List;

public interface MenuCategoriesService {
    MenuCategories findById(Long id);
    List<MenuEntry> findAllByMenuCategoryId(MenuCategories menuCategories);
    List<MenuCategories> findAll();
}

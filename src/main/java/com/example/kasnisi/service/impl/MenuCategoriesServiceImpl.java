package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.MenuCategories;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Restaurants;
import com.example.kasnisi.model.exceptions.menuEntryNotFound;
import com.example.kasnisi.repository.MenuCategoriesRepository;
import com.example.kasnisi.repository.MenuEntryRepository;
import com.example.kasnisi.service.MenuCategoriesService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuCategoriesServiceImpl implements MenuCategoriesService {
    private final MenuCategoriesRepository menuCategoriesRepository;
    private final MenuEntryRepository menuEntryRepository;

    public MenuCategoriesServiceImpl(MenuCategoriesRepository menuCategoriesRepository, MenuEntryRepository menuEntryRepository){
        this.menuCategoriesRepository=menuCategoriesRepository;
        this.menuEntryRepository = menuEntryRepository;
    }

    @Override
    public MenuCategories findById(Long id) {
        return menuCategoriesRepository.findById(id).orElseThrow(()->new menuEntryNotFound(id));
    }

    @Override
    public List<MenuEntry> findAllByMenuCategoryId(MenuCategories menuCategories) {
        return menuEntryRepository.findAllByMenuCategory(menuCategories);
    }

    @Override
    public List<MenuCategories> findAll() {
        return menuCategoriesRepository.findAll();
    }
}

package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.MenuCategories;
import com.example.kasnisi.model.exceptions.menuEntryNotFound;
import com.example.kasnisi.repository.MenuCategoriesRepository;
import com.example.kasnisi.service.MenuCategoriesService;
import org.springframework.stereotype.Service;

@Service
public class MenuCategoriesServiceImpl implements MenuCategoriesService {
    private final MenuCategoriesRepository menuCategoriesRepository;

    public MenuCategoriesServiceImpl(MenuCategoriesRepository menuCategoriesRepository){
        this.menuCategoriesRepository=menuCategoriesRepository;
    }

    @Override
    public MenuCategories findById(Long id) {
        return menuCategoriesRepository.findById(id).orElseThrow(()->new menuEntryNotFound(id));
    }
}

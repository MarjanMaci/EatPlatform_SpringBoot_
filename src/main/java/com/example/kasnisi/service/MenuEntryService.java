package com.example.kasnisi.service;

import com.example.kasnisi.model.Ingredients;
import com.example.kasnisi.model.MenuEntry;

import java.util.List;

public interface MenuEntryService {
    List<Ingredients> listAllIngredients(Long id);
    MenuEntry findById(Long id);
    String[] transliterate(String id);
}

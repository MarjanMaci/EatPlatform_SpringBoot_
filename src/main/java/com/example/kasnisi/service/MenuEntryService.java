package com.example.kasnisi.service;

import com.example.kasnisi.model.MenuEntry;

public interface MenuEntryService {
    MenuEntry findById(Long id);
    String[] transliterate(String id);
}

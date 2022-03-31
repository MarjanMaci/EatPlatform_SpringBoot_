package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.MenuCategories;
import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.service.MenuCategoriesService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/menu-categories")
public class MenuCategoriesRestController {
    private final MenuCategoriesService menuCategoriesService;

    public MenuCategoriesRestController(MenuCategoriesService menuCategoriesService) {
        this.menuCategoriesService = menuCategoriesService;
    }

    @GetMapping
    public List<MenuCategories> getMenuCategoriesNames(){
        return this.menuCategoriesService.findAll();
    }

    @GetMapping("/{id}")
    public List<MenuEntry> getMenuEntries(@PathVariable Long id){
        return this.menuCategoriesService.findAllByMenuCategoryId(menuCategoriesService.findById(id));
    }


}

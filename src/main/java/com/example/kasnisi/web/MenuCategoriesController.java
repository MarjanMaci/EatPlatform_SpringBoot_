package com.example.kasnisi.web;

import com.example.kasnisi.service.MenuCategoriesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("menu-categories")
public class MenuCategoriesController {
    public MenuCategoriesService menuCategoriesService;

    public MenuCategoriesController(MenuCategoriesService menuCategoriesService){
        this.menuCategoriesService=menuCategoriesService;
    }

    @GetMapping("/{id}")
    public String getMeal(@PathVariable Long id, Model model){
        model.addAttribute("menuCategory", menuCategoriesService.findById(id).getMenuEntryList());
        return "menu-categories";
    }
}

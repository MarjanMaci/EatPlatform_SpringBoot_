package com.example.kasnisi.web;

import com.example.kasnisi.service.MenuEntryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/meal")
public class MealController {
    public MenuEntryService menuEntryService;

    public MealController(MenuEntryService menuEntryService){
        this.menuEntryService=menuEntryService;
    }

    @GetMapping("/{id}")
    public String getMeal(@PathVariable Long id, Model model){
        model.addAttribute("ingredients", menuEntryService.transliterate(menuEntryService.findById(id).getDescription()));
        model.addAttribute("meal", menuEntryService.findById(id));
        return "meal";
    }
}

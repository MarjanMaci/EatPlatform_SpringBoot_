package com.example.kasnisi.web.Rest;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.service.MenuEntryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/meal")
public class MealRestController {
    private final MenuEntryService menuEntryService;

    public MealRestController(MenuEntryService menuEntryService) {
        this.menuEntryService = menuEntryService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<MenuEntry> findById(@PathVariable Long id) {
        MenuEntry menuEntry= this.menuEntryService.findById(id);
        if(menuEntry!=null){
            return ResponseEntity.ok().body(menuEntry);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}

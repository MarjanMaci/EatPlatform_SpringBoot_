package com.example.kasnisi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MenuCategories {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "menuCategory", fetch = FetchType.EAGER)
    private List<MenuEntry> menuEntryList;

    public MenuCategories(String name, List<MenuEntry> menuEntryList) {
        this.name = name;
        this.menuEntryList = menuEntryList;
    }

    public MenuCategories() {
    }
}

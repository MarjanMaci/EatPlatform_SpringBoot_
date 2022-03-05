package com.example.kasnisi.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
public class MenuEntry {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long price;
    @ManyToOne()
    private Restaurants inRestaurant;
    @ManyToMany
    private List<Orders> entryInOrders;
    @ManyToOne
    private MenuCategories menuCategory;

    public MenuEntry() {
    }

    public MenuEntry(String name, String description, MenuCategories menuCategory,Long price) {
        this.name = name;
        this.description = description;
        this.menuCategory=menuCategory;
        this.price=price;
    }
}

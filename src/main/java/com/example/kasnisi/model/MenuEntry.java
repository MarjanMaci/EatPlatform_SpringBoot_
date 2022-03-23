package com.example.kasnisi.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
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
    @ManyToOne
    private MenuCategories menuCategory;
    @OneToMany(mappedBy = "menuEntry", fetch = FetchType.EAGER)
    private List<CartItem> inCartItems;

    public MenuEntry() {
    }

    public MenuEntry(String name, String description, MenuCategories menuCategory,Long price) {
        this.name = name;
        this.description = description;
        this.menuCategory=menuCategory;
        this.price=price;
    }
}

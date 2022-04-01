package com.example.kasnisi.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    private Long price;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private Restaurants inRestaurant;
    @ManyToOne
    @JsonIgnore
    private MenuCategories menuCategory;
    @OneToMany(mappedBy = "menuEntry", fetch = FetchType.EAGER)
    @JsonIgnore
    private List<CartItem> inCartItems;
    @ManyToMany
    private List<Ingredients> ingredients;
    private String img;

    public MenuEntry() {
    }

    public MenuEntry(String name, MenuCategories menuCategory,Long price) {
        this.name = name;
        this.menuCategory=menuCategory;
        this.price=price;
    }
}

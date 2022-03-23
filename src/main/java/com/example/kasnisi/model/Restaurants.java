package com.example.kasnisi.model;

import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Restaurants {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String address;
    private String opens;
    private String closes;
    private Long avgOrderCompletion;
    @OneToMany(mappedBy = "inRestaurant")
    private List<MenuEntry> menuEntries;

    public Restaurants() {
    }

    public Restaurants(String name, String address, String opens, String closes, Long avgOrderCompletion) {
        this.name = name;
        this.address = address;
        this.opens = opens;
        this.closes = closes;
        this.avgOrderCompletion = avgOrderCompletion;
        this.menuEntries=new ArrayList<>();
    }
}

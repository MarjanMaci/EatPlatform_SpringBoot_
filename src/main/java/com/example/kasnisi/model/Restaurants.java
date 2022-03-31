package com.example.kasnisi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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
    @OneToMany(mappedBy = "inRestaurant",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonIgnore
    private List<MenuEntry> menuEntries;
    private String img;

    public Restaurants() {
    }

    public Restaurants(String name, String address, String opens, String closes, Long avgOrderCompletion,String img) {
        this.name = name;
        this.address = address;
        this.opens = opens;
        this.closes = closes;
        this.avgOrderCompletion = avgOrderCompletion;
        this.img=img;
        this.menuEntries=new ArrayList<>();
    }
}

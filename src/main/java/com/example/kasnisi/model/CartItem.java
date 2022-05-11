package com.example.kasnisi.model;
import lombok.Data;
import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne()
    private MenuEntry menuEntry;

    private Integer ammount;

    @ManyToOne
    private Orders inOrder;

    public CartItem() {}

    public CartItem(MenuEntry menuEntry) {
        this.menuEntry = menuEntry;
        this.ammount=1;
    }
    public CartItem(MenuEntry menuEntry, Integer ammount) {
        this.menuEntry = menuEntry;
        this.ammount=1;
    }
}
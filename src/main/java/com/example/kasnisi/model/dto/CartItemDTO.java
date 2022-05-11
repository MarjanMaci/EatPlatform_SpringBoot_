package com.example.kasnisi.model.dto;

import lombok.Data;

@Data
public class CartItemDTO {
    private String username;
    private Long mealId;
    private Integer ammount;

    public CartItemDTO() {
    }

    public CartItemDTO(String username, Long mealId, Integer ammount) {
        this.username = username;
        this.mealId = mealId;
        this.ammount = ammount;
    }
}

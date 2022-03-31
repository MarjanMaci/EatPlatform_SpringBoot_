package com.example.kasnisi.model.dto;

import lombok.Data;

@Data
public class RestaurantDto {

    private String name;

    private String address;

    private String opens;

    private String closes;

    private Long avgOrderComp;

    private String img;

    public RestaurantDto() {
    }

    public RestaurantDto(String name, String address, String opens, String closes, Long avgOrderComp,String img) {
        this.name = name;
        this.address = address;
        this.opens = opens;
        this.closes = closes;
        this.avgOrderComp = avgOrderComp;
        this.img=img;
    }
}

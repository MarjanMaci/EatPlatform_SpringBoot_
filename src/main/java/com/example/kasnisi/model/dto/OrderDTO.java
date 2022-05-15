package com.example.kasnisi.model.dto;

import com.example.kasnisi.model.CartItem;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Data
public class OrderDTO {
    private String discountCode;
    private String orderTotal;
    private List<CartItem> cartItems;
    private String emailUser;

    public OrderDTO() {
    }

    public OrderDTO(String discountCode, String orderTotal, List<CartItem> cartItems, String emailUser) {
        this.discountCode = discountCode;
        this.orderTotal = orderTotal;
        this.cartItems = cartItems;
        this.emailUser = emailUser;
    }
}

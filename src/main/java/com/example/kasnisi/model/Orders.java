package com.example.kasnisi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.awt.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private boolean delivered;
    private Date dateOfOrder;
    private String discountCode;
    private Long orderTotal;
    @OneToMany(mappedBy = "inOrder", fetch = FetchType.EAGER)
    private List<CartItem> itemsInOrder;
    @ManyToOne
    @JsonIgnore
    private User clientThatOrdered;
    @ManyToOne
    @JsonIgnore
    private Employees employeeThatDeliveres;

    public Orders() {
    }

    public Orders(boolean delivered, Date dateOfOrder, String discountCode, Long orderTotal, User clientThatOrdered, Employees employeeThatDeliveres) {
        this.delivered = delivered;
        this.dateOfOrder = dateOfOrder;
        this.discountCode = discountCode;
        this.orderTotal = orderTotal;
        this.clientThatOrdered = clientThatOrdered;
        this.employeeThatDeliveres = employeeThatDeliveres;
    }

    public Orders(Date date, String discountCode, Long orderTotal, List<CartItem> items, User user, Employees employeeThatDeliveres) {
        this.delivered=false;
        this.dateOfOrder=date;
        this.discountCode=discountCode;
        this.orderTotal=orderTotal;
        this.itemsInOrder=items;
        this.clientThatOrdered=user;
        this.employeeThatDeliveres=employeeThatDeliveres;
    }
}

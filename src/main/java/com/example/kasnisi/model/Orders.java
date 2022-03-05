package com.example.kasnisi.model;

import lombok.Data;

import javax.persistence.*;
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
    @ManyToMany
    private List<MenuEntry> menuEntries;
    @ManyToOne
    private User clientThatOrdered;
    @ManyToOne
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
}

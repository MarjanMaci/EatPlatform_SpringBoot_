package com.example.kasnisi.service;

import com.example.kasnisi.model.CartItem;
import com.example.kasnisi.model.Employees;
import com.example.kasnisi.model.Orders;
import com.example.kasnisi.model.User;

import java.util.Date;
import java.util.List;

public interface OrderService {
    Orders makeAnOrder(Date dateOfOrder, String discountCode, Long orderTotal, List<CartItem> items, User user);
    List<Orders> listAllOrders(User user);
    List<Orders> allOrders();
    void changeStatus(Long id);
}

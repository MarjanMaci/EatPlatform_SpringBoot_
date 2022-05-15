package com.example.kasnisi.repository;

import com.example.kasnisi.model.MenuEntry;
import com.example.kasnisi.model.Orders;
import com.example.kasnisi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Orders,Long> {
    List<Orders> getAllByClientThatOrdered(User user);
}

package com.example.kasnisi.repository;

import com.example.kasnisi.model.ShoppingCart;
import com.example.kasnisi.model.ShoppingCartStatus;
import com.example.kasnisi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShoppingCartRepository extends JpaRepository<ShoppingCart, Long> {
    Optional<ShoppingCart> findByUserAndStatus(User user, ShoppingCartStatus status);
    Optional<ShoppingCart> findByUser(User user);
}

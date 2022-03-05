package com.example.kasnisi.repository;

import com.example.kasnisi.model.MenuCategories;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuCategoriesRepository extends JpaRepository<MenuCategories,Long> {
    Optional<MenuCategories> findById(Long id);
}

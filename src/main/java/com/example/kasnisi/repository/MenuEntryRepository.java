package com.example.kasnisi.repository;

import com.example.kasnisi.model.MenuEntry;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MenuEntryRepository extends JpaRepository<MenuEntry,Long> {
    Optional<MenuEntry> findById(Long id);
}

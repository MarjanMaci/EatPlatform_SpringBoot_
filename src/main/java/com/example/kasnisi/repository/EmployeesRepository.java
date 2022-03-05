package com.example.kasnisi.repository;

import com.example.kasnisi.model.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {
    List<Employees> findAll();
    void deleteById(Long id);
    Optional<Employees> findById(Long id);
}

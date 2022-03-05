package com.example.kasnisi.service;

import com.example.kasnisi.model.Employees;

import java.util.Date;
import java.util.List;

public interface EmployeesService {
    List<Employees> getAllEmployees();
    void deleteEmployee(Long id);
    Employees findById(Long id);
    Employees edit(Long id,String name, String surname, Long EMBG, String vehicle, String dateOfEmployment);
    Employees addEmployee(String name, String surname, Long EMBG, String vehicle, String dateOfEmployment);
}

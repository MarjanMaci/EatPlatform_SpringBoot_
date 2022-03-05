package com.example.kasnisi.service.impl;

import com.example.kasnisi.model.Employees;
import com.example.kasnisi.model.exceptions.employeeNotFoundException;
import com.example.kasnisi.repository.EmployeesRepository;
import com.example.kasnisi.service.EmployeesService;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmployeesServiceImpl implements EmployeesService {
    public EmployeesRepository employeesRepository;

    public EmployeesServiceImpl(EmployeesRepository employeesRepository){
        this.employeesRepository=employeesRepository;
    }

    @Override
    public List<Employees> getAllEmployees() {
        return employeesRepository.findAll();
    }

    @Override
    public Employees addEmployee(String name, String surname, Long EMBG, String vehicle, String dateOfEmployment) {
        Employees newEmployee = new Employees(name,surname,EMBG,vehicle,dateOfEmployment);
        return employeesRepository.save(newEmployee);
    }

    @Override
    public Employees edit(Long id, String name, String surname, Long EMBG, String vehicle, String dateOfEmployment) {
        Employees toEdit= employeesRepository.findById(id).orElseThrow(()->new employeeNotFoundException());
        toEdit.setName(name);
        toEdit.setSurname(surname);
        toEdit.setEMBG(EMBG);
        toEdit.setVehicle(vehicle);
        toEdit.setDateOfEmployment(dateOfEmployment);
        return employeesRepository.save(toEdit);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeesRepository.deleteById(id);
    }

    @Override
    public Employees findById(Long id) {
        Employees toReturn = employeesRepository.findById(id).orElseThrow(()->new employeeNotFoundException());
        return toReturn;
    }
}

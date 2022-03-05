package com.example.kasnisi.web;

import com.example.kasnisi.service.EmployeesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Controller
@RequestMapping("/employees")
public class EmployeesController {
    public EmployeesService employeesService;

    public EmployeesController(EmployeesService employeesService){
        this.employeesService=employeesService;
    }

    @GetMapping
    public String getAllEmployees(Model model){
        model.addAttribute("employees", employeesService.getAllEmployees());
        return "employees";
    }

    @GetMapping("/add")
    public String addEmployees(Model model){
        return "employees-add";
    }

    @PostMapping("/add")
    public String addEmployees2(@RequestParam(required = false) Long id,
                                @RequestParam String name,
                                @RequestParam String surname,
                                @RequestParam String embg,
                                @RequestParam String vehicle,
                                @RequestParam String dateOfEmployment) {
        Long embgg=Long.parseLong(embg);
        if(id!=null){
            this.employeesService.edit(id,name,surname,embgg,vehicle,dateOfEmployment);
        }else {
            this.employeesService.addEmployee(name, surname, embgg, vehicle, dateOfEmployment);
        }
        return "redirect:/employees";
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        this.employeesService.deleteEmployee(id);
        return "employees";
    }

    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable Long id,Model model){
        model.addAttribute("employee",this.employeesService.findById(id));
        return "employees-add";
    }
}

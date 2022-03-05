package com.example.kasnisi.model;

import lombok.Data;
import lombok.Generated;
import org.hibernate.annotations.GenerationTime;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@Entity
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String surname;
    private Long EMBG;
    private String vehicle;
    private String dateOfEmployment;
    @OneToMany(mappedBy = "employeeThatDeliveres", fetch = FetchType.EAGER)
    private List<Orders> ordersList;

    public Employees(String name, String surname, Long EMBG, String vehicle, String dateOfEmployment) {
        this.id=(long) (Math.random()*1000);
        this.name = name;
        this.surname = surname;
        this.EMBG = EMBG;
        this.vehicle = vehicle;
        this.dateOfEmployment = dateOfEmployment;
        this.ordersList=new ArrayList<>();
    }

    public Employees() {
    }
}

package com.payin.payinsoft.entitylayer;

import java.util.Date;

import jakarta.persistence.Entity;
//import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Employee_hours_daywise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int recordid;

    @ManyToOne()
    @JoinColumn(
        name = "employee_code",
        referencedColumnName = "employee_code"
    )
    private Employeeinfo empinfo;

    private Date date;
    private int hours; // hours always in min
    
}
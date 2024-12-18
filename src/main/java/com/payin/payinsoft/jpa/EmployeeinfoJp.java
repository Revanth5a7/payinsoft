package com.payin.payinsoft.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.payin.payinsoft.entitylayer.Employeeinfo;

@Repository
public interface EmployeeinfoJp extends JpaRepository<Employeeinfo, Integer> {

    @Query("SELECT e.employeeName FROM Employeeinfo e")  
    List<String> findEmployeeNames();

    Employeeinfo findByEmployeeNameIgnoreCase(String empname);

    Employeeinfo findByEmployeeCode(Integer enteredpin);
    
}

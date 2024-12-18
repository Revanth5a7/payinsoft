package com.payin.payinsoft.svc;

import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payin.payinsoft.entitylayer.Employeeinfo;
import com.payin.payinsoft.entitylayer.Todaypunch;
import com.payin.payinsoft.jpa.EmployeeinfoJp;
import com.payin.payinsoft.jpa.Todaypunchjp;

@Service
public class Start {
    @Autowired
    EmployeeStatus employeestatus;

    @Autowired
    Todaypunchjp tpj;

    @Autowired
    EmployeeinfoJp pj;
    
    public String startwork(String empname, Integer enteredpin, LocalTime intime) {
       boolean employeeIn = employeestatus.isEmployeePunchedIN(enteredpin);
       if(employeeIn == false)
       {
        //check employee and get employee, if employee doesnt exist then return error
        Employeeinfo emp = pj.findByEmployeeCode(enteredpin);
        if (emp == null) return "employee not found";
        //insert in time in db
            Todaypunch tp = Todaypunch.builder()
                            .empinfo(emp)
                            .intime(intime)
                            .build();          
            tpj.save(tp);
            return "successful";//intime recorded
       }
       else if(employeeIn == true) return "employee already in" ;
       else return "failed";
    }
}

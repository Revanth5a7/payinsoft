package com.payin.payinsoft.svc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payin.payinsoft.entitylayer.Employeeinfo;
import com.payin.payinsoft.jpa.EmployeeinfoJp;

@Service
public class Verifyemployee {
    @Autowired
    EmployeeinfoJp pj;

    public Boolean doValidation(String empname, Integer enteredpin) {
        // employee pin in db is never null
        Employeeinfo em = pj.findByEmployeeNameIgnoreCase(empname.toLowerCase());
        if (em.getEmployeeCode().equals(enteredpin))
            return true;
        else
            return false;
    }

}
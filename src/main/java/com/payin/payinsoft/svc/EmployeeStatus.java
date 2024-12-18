package com.payin.payinsoft.svc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payin.payinsoft.entitylayer.Todaypunch;
import com.payin.payinsoft.jpa.Todaypunchjp;

@Service
public class EmployeeStatus {
    
    @Autowired
    Todaypunchjp tpj;

    public Boolean isEmployeePunchedIN(Integer code){
        //this method checks if the employee is punchedin already or not
       // List<Todaypunch> mypunchlisttoday = tpj.findAllByEmpid(code);
        List<Todaypunch> mypunchlisttoday = tpj.findAllByEmpinfo_EmployeeCode(code);
        long count = mypunchlisttoday.stream()
                                        .filter(punch -> punch.getOuttime() == null)
                                        .count();                                
        /*if outtime is empty-not clocked out
        - which means emp is currently in and working. 
        so true reflecting isEmployeePunchedIN */                                 
        if(count>0) return true;
        else return false;

    }
}

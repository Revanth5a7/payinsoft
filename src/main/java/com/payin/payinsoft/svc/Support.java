package com.payin.payinsoft.svc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payin.payinsoft.jpa.Todaypunchjp;


@Service
public class Support {
    @Autowired
    Todaypunchjp tp;

    public String dayclose(){
        //long countOfEmployeesToday = tp.countDistinctEmpinfo_EmployeeCode();
         


        return "success";
    }

    

}

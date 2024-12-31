package com.payin.payinsoft.svc;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.payin.payinsoft.dto.EmployeeHoursDTO;
import com.payin.payinsoft.jpa.Todaypunchjp;


@Service
public class Support {
    @Autowired
    Todaypunchjp tpj;


    public String dayclose(){
        //long countOfEmployeesToday = tp.countDistinctEmpinfo_EmployeeCode();
         
        return "success";
    }

    public List<EmployeeHoursDTO> GenerateReportForRequiredDates(LocalDate from, LocalDate to) {
        return tpj.findEmpidDateAndTotalHoursByDateRange(from, to);
    }


}

package com.payin.payinsoft;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.payin.payinsoft.dto.EmployeeHoursDTO;
import com.payin.payinsoft.svc.EmpNames;
import com.payin.payinsoft.svc.End;
import com.payin.payinsoft.svc.Start;
import com.payin.payinsoft.svc.Support;

@RestController
public class Paycontroller {
    @Autowired
    EmpNames empnames;

    @Autowired
    Start start;

    @Autowired
    End end;

    @Autowired
    Support sup;
    
    @GetMapping("/names")
    public List<String> getallnames()
    {     
        return empnames.listnames(); 
    }

    //IN CODE HERE
    @PostMapping("/start")
    public String in(@RequestParam String empname, 
                      @RequestParam Integer enteredpin,
                      @RequestParam LocalTime intime)
    {     
        return start.startwork(empname,enteredpin, intime); 
    }

    //OUT
    @PostMapping("/end")
    public String out(@RequestParam String empname, 
                      @RequestParam Integer enteredpin,
                      @RequestParam LocalTime outtime)
    {     
        return end.endwork(empname,enteredpin, outtime); 
    }

    // //validate entered employee
    // @GetMapping("/validate/{empname}/{enteredpin}")
    // public Boolean validatePinEntered(@PathVariable String empname, @PathVariable Integer enteredpin)
    // {     
    //     return ps.doValidation(empname,enteredpin); 
    // }

    //report all staff (from date - to date)
    @GetMapping("/reportforgivendates")
    public List<EmployeeHoursDTO> getallstaffhours(@RequestParam LocalDate from, 
                                                  @RequestParam LocalDate to)
    {     
        return sup.GenerateReportForRequiredDates(from, to); 
    }


   
}






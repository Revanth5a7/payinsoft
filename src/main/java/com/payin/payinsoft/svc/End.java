package com.payin.payinsoft.svc;
import java.time.Duration;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payin.payinsoft.entitylayer.Todaypunch;
import com.payin.payinsoft.jpa.Todaypunchjp;

@Service
public class End {

    @Autowired
    EmployeeStatus employeestatus;

    @Autowired
    Todaypunchjp tpj;

    public String endwork(String empname, Integer enteredpin, LocalTime outtime) {
        boolean employeeIn = employeestatus.isEmployeePunchedIN(enteredpin);
        if(employeeIn == true)
       {
            //List<Todaypunch> tplist = tpj.findAllByEmpid(enteredpin);//.orElseThrow(() -> new ResourceNotFoundException("Employee not found")); 
            List<Todaypunch> tplist = tpj.findAllByEmpinfo_EmployeeCode(enteredpin);
            Optional<Todaypunch> empRecordWithEmptyOutime = tplist.stream()
                                         .filter(punch -> punch.getOuttime() == null)
                                         .findFirst();

            if (empRecordWithEmptyOutime.isPresent()) 
            { 
                Todaypunch emptyout = empRecordWithEmptyOutime.get();
                emptyout.setOuttime(outtime);  
                
                /*calculate hours worked. we take result in min just to be accurate and 
                easy for calculation at closing*/
                LocalTime inTime = emptyout.getIntime();
                emptyout.setNumberOfHours(Duration.between(inTime,outtime).toMinutes()); 
                tpj.save(emptyout);          
            } 
            else 
                return "No punch found with empty outtime"; 
            
            return "success";
       }
       else return "you are not in --- please sign in";
    }
}

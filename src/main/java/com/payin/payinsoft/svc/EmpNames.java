package com.payin.payinsoft.svc;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.payin.payinsoft.jpa.EmployeeinfoJp;

@Service
public class EmpNames {
    @Autowired
    EmployeeinfoJp pj;

    public List<String> listnames() {
       return pj.findEmployeeNames();
       
    }
}

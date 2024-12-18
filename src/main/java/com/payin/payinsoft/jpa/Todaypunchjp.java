package com.payin.payinsoft.jpa;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.payin.payinsoft.entitylayer.Todaypunch;

@Repository
public interface Todaypunchjp extends JpaRepository<Todaypunch, Integer> {

    //List<Todaypunch> findAllByEmpid(Integer empid);

    List<Todaypunch> findAllByEmpinfo_EmployeeCode(Integer code);
   
}
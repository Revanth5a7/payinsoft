package com.payin.payinsoft.jpa;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.payin.payinsoft.dto.EmployeeHoursDTO;
import com.payin.payinsoft.entitylayer.Todaypunch;

@Repository
public interface Todaypunchjp extends JpaRepository<Todaypunch, Integer> {

    //List<Todaypunch> findAllByEmpid(Integer empid);

    List<Todaypunch> findAllByEmpinfo_EmployeeCode(Integer code);

    @Query("SELECT new com.payin.payinsoft.dto.EmployeeHoursDTO(t.empinfo.employeeCode, t.date, SUM(t.numberOfHours))"
    + " FROM Todaypunch t WHERE t.date BETWEEN :from AND :to "
    + "GROUP BY t.empinfo.employeeCode, t.date")
    List<EmployeeHoursDTO> findEmpidDateAndTotalHoursByDateRange(LocalDate from, LocalDate to);

    //long countDistinctEmpinfo_EmployeeCode();
   
}
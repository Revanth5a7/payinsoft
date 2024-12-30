package com.payin.payinsoft.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.payin.payinsoft.entitylayer.Employee_hours_daywise;

@Repository
public interface Employee_hours_daywiseJp extends JpaRepository<Employee_hours_daywise, Integer> {

}

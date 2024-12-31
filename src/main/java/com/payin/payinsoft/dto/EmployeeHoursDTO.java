package com.payin.payinsoft.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeHoursDTO {
    private Integer employeeCode;
    private LocalDate date;
    private Long totalHoursinMinutes;
}

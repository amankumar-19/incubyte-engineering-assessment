package com.acme.salary.dto;
import java.math.BigDecimal; import java.time.*;
public record EmployeeResponse(Long id,String employeeCode,String firstName,String lastName,String email,
 String department,String jobTitle,String country,String currency,BigDecimal baseSalary,BigDecimal bonus,
 BigDecimal totalCompensation,LocalDate joiningDate,LocalDateTime createdAt,LocalDateTime updatedAt){}

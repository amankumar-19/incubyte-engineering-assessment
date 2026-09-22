package com.acme.salary.dto;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
public record EmployeeRequest(
 @NotBlank @Size(max=30) String employeeCode,
 @NotBlank @Size(max=80) String firstName,
 @NotBlank @Size(max=80) String lastName,
 @NotBlank @Email @Size(max=180) String email,
 @NotBlank @Size(max=100) String department,
 @NotBlank @Size(max=120) String jobTitle,
 @NotBlank @Size(max=80) String country,
 @NotBlank @Pattern(regexp="^[A-Z]{3}$",message="currency must be a 3-letter ISO code") String currency,
 @NotNull @DecimalMin("0.00") @Digits(integer=16,fraction=2) BigDecimal baseSalary,
 @NotNull @DecimalMin("0.00") @Digits(integer=16,fraction=2) BigDecimal bonus,
 @NotNull @PastOrPresent LocalDate joiningDate){}

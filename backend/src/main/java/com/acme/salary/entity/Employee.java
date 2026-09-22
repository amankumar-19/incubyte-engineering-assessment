package com.acme.salary.entity;
import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.*;
@Entity
@Table(name="employees", indexes={
 @Index(name="idx_employee_code",columnList="employee_code",unique=true),
 @Index(name="idx_employee_email",columnList="email",unique=true),
 @Index(name="idx_employee_department",columnList="department"),
 @Index(name="idx_employee_country",columnList="country")})
public class Employee {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(name="employee_code",nullable=false,unique=true,length=30) private String employeeCode;
 @Column(nullable=false,length=80) private String firstName;
 @Column(nullable=false,length=80) private String lastName;
 @Column(nullable=false,unique=true,length=180) private String email;
 @Column(nullable=false,length=100) private String department;
 @Column(nullable=false,length=120) private String jobTitle;
 @Column(nullable=false,length=80) private String country;
 @Column(nullable=false,length=3) private String currency;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal baseSalary;
 @Column(nullable=false,precision=19,scale=2) private BigDecimal bonus;
 @Column(nullable=false) private LocalDate joiningDate;
 @Column(nullable=false,updatable=false) private LocalDateTime createdAt;
 @Column(nullable=false) private LocalDateTime updatedAt;
 @PrePersist void create(){createdAt=updatedAt=LocalDateTime.now();}
 @PreUpdate void update(){updatedAt=LocalDateTime.now();}
 public BigDecimal getTotalCompensation(){return baseSalary.add(bonus);}
 public Long getId(){return id;} public void setId(Long v){id=v;}
 public String getEmployeeCode(){return employeeCode;} public void setEmployeeCode(String v){employeeCode=v;}
 public String getFirstName(){return firstName;} public void setFirstName(String v){firstName=v;}
 public String getLastName(){return lastName;} public void setLastName(String v){lastName=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getDepartment(){return department;} public void setDepartment(String v){department=v;}
 public String getJobTitle(){return jobTitle;} public void setJobTitle(String v){jobTitle=v;}
 public String getCountry(){return country;} public void setCountry(String v){country=v;}
 public String getCurrency(){return currency;} public void setCurrency(String v){currency=v;}
 public BigDecimal getBaseSalary(){return baseSalary;} public void setBaseSalary(BigDecimal v){baseSalary=v;}
 public BigDecimal getBonus(){return bonus;} public void setBonus(BigDecimal v){bonus=v;}
 public LocalDate getJoiningDate(){return joiningDate;} public void setJoiningDate(LocalDate v){joiningDate=v;}
 public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;}
}

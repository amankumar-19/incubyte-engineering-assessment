package com.acme.salary.dto;
import java.math.BigDecimal;
import java.util.List;
public final class AnalyticsDtos {
 private AnalyticsDtos(){}
 public record CurrencySummary(String currency,long employeeCount,BigDecimal averageBaseSalary,BigDecimal minimumBaseSalary,BigDecimal maximumBaseSalary){}
 public record Dashboard(long totalEmployees,List<CurrencySummary> currencySummaries){}
 public record SalaryAggregate(String label,String currency,long employeeCount,BigDecimal averageBaseSalary,BigDecimal minimumBaseSalary,BigDecimal maximumBaseSalary){}
}

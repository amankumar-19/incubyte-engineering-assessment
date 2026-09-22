package com.acme.salary.service;
import com.acme.salary.dto.AnalyticsDtos.*; import com.acme.salary.repository.EmployeeRepository;
import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
import java.math.*; import java.util.*;
@Service @Transactional(readOnly=true)
public class AnalyticsService{
 private final EmployeeRepository repo; public AnalyticsService(EmployeeRepository r){repo=r;}
 public Dashboard summary(){return new Dashboard(repo.count(),repo.currencySummary().stream().map(r->new CurrencySummary((String)r[0],((Number)r[1]).longValue(),m(r[2]),m(r[3]),m(r[4]))).toList());}
 public List<SalaryAggregate> byDepartment(){return agg(repo.salaryByDepartment());}
 public List<SalaryAggregate> byCountry(){return agg(repo.salaryByCountry());}
 private List<SalaryAggregate> agg(List<Object[]> rows){return rows.stream().map(r->new SalaryAggregate((String)r[0],(String)r[1],((Number)r[2]).longValue(),m(r[3]),m(r[4]),m(r[5]))).toList();}
 private BigDecimal m(Object v){return new BigDecimal(v.toString()).setScale(2,RoundingMode.HALF_UP);}
}

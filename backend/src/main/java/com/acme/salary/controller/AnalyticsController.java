package com.acme.salary.controller;
import com.acme.salary.dto.AnalyticsDtos.*; import com.acme.salary.service.AnalyticsService; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/analytics")
public class AnalyticsController{
 private final AnalyticsService s; public AnalyticsController(AnalyticsService s){this.s=s;}
 @GetMapping("/summary") public Dashboard summary(){return s.summary();}
 @GetMapping("/by-department") public List<SalaryAggregate> departments(){return s.byDepartment();}
 @GetMapping("/by-country") public List<SalaryAggregate> countries(){return s.byCountry();}
}

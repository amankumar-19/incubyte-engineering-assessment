package com.acme.salary.controller;
import com.acme.salary.repository.EmployeeRepository; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/api/metadata")
public class MetadataController{
 private final EmployeeRepository r; public MetadataController(EmployeeRepository r){this.r=r;}
 @GetMapping("/departments") public List<String> departments(){return r.findDistinctDepartments();}
 @GetMapping("/countries") public List<String> countries(){return r.findDistinctCountries();}
}

package com.acme.salary.controller;
import com.acme.salary.dto.*; import com.acme.salary.service.EmployeeService; import jakarta.validation.Valid;
import org.springframework.data.domain.*; import org.springframework.http.*; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/employees")
public class EmployeeController{
 private final EmployeeService service; public EmployeeController(EmployeeService s){service=s;}
 @GetMapping public Page<EmployeeResponse> all(@RequestParam(required=false)String search,@RequestParam(required=false)String department,
  @RequestParam(required=false)String country,@RequestParam(defaultValue="0")int page,@RequestParam(defaultValue="20")int size,
  @RequestParam(defaultValue="lastName")String sortBy,@RequestParam(defaultValue="asc")String direction){
  int ss=Math.min(Math.max(size,1),100); Sort.Direction dir="desc".equalsIgnoreCase(direction)?Sort.Direction.DESC:Sort.Direction.ASC;
  String sort=switch(sortBy){case "firstName","lastName","employeeCode","department","country","baseSalary","joiningDate"->sortBy;default->"lastName";};
  return service.findAll(search,department,country,PageRequest.of(Math.max(page,0),ss,Sort.by(dir,sort)));}
 @GetMapping("/{id}") public EmployeeResponse one(@PathVariable Long id){return service.findById(id);}
 @PostMapping public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody EmployeeRequest r){return ResponseEntity.status(HttpStatus.CREATED).body(service.create(r));}
 @PutMapping("/{id}") public EmployeeResponse update(@PathVariable Long id,@Valid @RequestBody EmployeeRequest r){return service.update(id,r);}
 @DeleteMapping("/{id}") @ResponseStatus(HttpStatus.NO_CONTENT) public void delete(@PathVariable Long id){service.delete(id);}
}

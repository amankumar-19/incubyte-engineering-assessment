package com.acme.salary.service;
import com.acme.salary.dto.*; import com.acme.salary.entity.Employee; import com.acme.salary.exception.*; import com.acme.salary.repository.*;
import org.springframework.data.domain.*; import org.springframework.stereotype.Service; import org.springframework.transaction.annotation.Transactional;
@Service @Transactional
public class EmployeeService{
 private final EmployeeRepository repo; public EmployeeService(EmployeeRepository r){repo=r;}
 @Transactional(readOnly=true) public Page<EmployeeResponse> findAll(String s,String d,String c,Pageable p){return repo.findAll(EmployeeSpecifications.matches(s,d,c),p).map(this::map);}
 @Transactional(readOnly=true) public EmployeeResponse findById(Long id){return map(entity(id));}
 public EmployeeResponse create(EmployeeRequest r){unique(r.employeeCode(),r.email(),null);Employee e=new Employee();apply(e,r);return map(repo.save(e));}
 public EmployeeResponse update(Long id,EmployeeRequest r){Employee e=entity(id);unique(r.employeeCode(),r.email(),id);apply(e,r);return map(repo.save(e));}
 public void delete(Long id){repo.delete(entity(id));}
 private Employee entity(Long id){return repo.findById(id).orElseThrow(()->new EmployeeNotFoundException(id));}
 private void unique(String code,String email,Long id){
  boolean dc=id==null?repo.existsByEmployeeCodeIgnoreCase(code):repo.existsByEmployeeCodeIgnoreCaseAndIdNot(code,id);
  if(dc)throw new DuplicateEmployeeException("Employee code already exists");
  boolean de=id==null?repo.existsByEmailIgnoreCase(email):repo.existsByEmailIgnoreCaseAndIdNot(email,id);
  if(de)throw new DuplicateEmployeeException("Email already exists");}
 private void apply(Employee e,EmployeeRequest r){e.setEmployeeCode(r.employeeCode().trim());e.setFirstName(r.firstName().trim());e.setLastName(r.lastName().trim());
  e.setEmail(r.email().trim().toLowerCase());e.setDepartment(r.department().trim());e.setJobTitle(r.jobTitle().trim());e.setCountry(r.country().trim());
  e.setCurrency(r.currency().trim().toUpperCase());e.setBaseSalary(r.baseSalary());e.setBonus(r.bonus());e.setJoiningDate(r.joiningDate());}
 private EmployeeResponse map(Employee e){return new EmployeeResponse(e.getId(),e.getEmployeeCode(),e.getFirstName(),e.getLastName(),e.getEmail(),e.getDepartment(),
  e.getJobTitle(),e.getCountry(),e.getCurrency(),e.getBaseSalary(),e.getBonus(),e.getTotalCompensation(),e.getJoiningDate(),e.getCreatedAt(),e.getUpdatedAt());}
}

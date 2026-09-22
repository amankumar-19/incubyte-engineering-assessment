package com.acme.salary.repository;
import com.acme.salary.entity.Employee;
import org.springframework.data.jpa.domain.Specification;
public final class EmployeeSpecifications{
 private EmployeeSpecifications(){}
 public static Specification<Employee> matches(String search,String department,String country){
  Specification<Employee> s=Specification.where(null);
  if(search!=null&&!search.isBlank()){String v="%"+search.trim().toLowerCase()+"%";
   s=s.and((r,q,c)->c.or(c.like(c.lower(r.get("firstName")),v),c.like(c.lower(r.get("lastName")),v),
    c.like(c.lower(r.get("email")),v),c.like(c.lower(r.get("employeeCode")),v),c.like(c.lower(r.get("jobTitle")),v)));}
  if(department!=null&&!department.isBlank()) s=s.and((r,q,c)->c.equal(c.lower(r.get("department")),department.trim().toLowerCase()));
  if(country!=null&&!country.isBlank()) s=s.and((r,q,c)->c.equal(c.lower(r.get("country")),country.trim().toLowerCase()));
  return s;
 }
}

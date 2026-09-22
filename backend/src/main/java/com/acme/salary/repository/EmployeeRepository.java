package com.acme.salary.repository;
import com.acme.salary.entity.Employee;
import org.springframework.data.jpa.repository.*;
import java.util.List;
public interface EmployeeRepository extends JpaRepository<Employee,Long>,JpaSpecificationExecutor<Employee>{
 boolean existsByEmployeeCodeIgnoreCase(String code);
 boolean existsByEmailIgnoreCase(String email);
 boolean existsByEmployeeCodeIgnoreCaseAndIdNot(String code,Long id);
 boolean existsByEmailIgnoreCaseAndIdNot(String email,Long id);
 @Query("select distinct e.department from Employee e order by e.department") List<String> findDistinctDepartments();
 @Query("select distinct e.country from Employee e order by e.country") List<String> findDistinctCountries();
 @Query("select e.currency,count(e),avg(e.baseSalary),min(e.baseSalary),max(e.baseSalary) from Employee e group by e.currency order by e.currency")
 List<Object[]> currencySummary();
 @Query("select e.department,e.currency,count(e),avg(e.baseSalary),min(e.baseSalary),max(e.baseSalary) from Employee e group by e.department,e.currency order by e.department,e.currency")
 List<Object[]> salaryByDepartment();
 @Query("select e.country,e.currency,count(e),avg(e.baseSalary),min(e.baseSalary),max(e.baseSalary) from Employee e group by e.country,e.currency order by e.country,e.currency")
 List<Object[]> salaryByCountry();
}

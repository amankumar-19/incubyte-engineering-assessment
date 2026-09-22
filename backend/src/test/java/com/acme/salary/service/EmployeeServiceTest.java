package com.acme.salary.service;
import com.acme.salary.dto.*; import com.acme.salary.entity.Employee; import com.acme.salary.exception.*; import com.acme.salary.repository.EmployeeRepository;
import org.junit.jupiter.api.*; import org.mockito.*; import java.math.*; import java.time.*; import java.util.*;
import static org.junit.jupiter.api.Assertions.*; import static org.mockito.ArgumentMatchers.*; import static org.mockito.Mockito.*;
class EmployeeServiceTest{
 @Mock EmployeeRepository repo; EmployeeService service;
 @BeforeEach void setup(){MockitoAnnotations.openMocks(this);service=new EmployeeService(repo);}
 @Test void createsAndCalculatesTotal(){when(repo.existsByEmployeeCodeIgnoreCase(anyString())).thenReturn(false);when(repo.existsByEmailIgnoreCase(anyString())).thenReturn(false);
  when(repo.save(any(Employee.class))).thenAnswer(i->{Employee e=i.getArgument(0);e.setId(1L);return e;});
  assertEquals(new BigDecimal("110000.00"),service.create(req()).totalCompensation());}
 @Test void rejectsDuplicateCode(){when(repo.existsByEmployeeCodeIgnoreCase("ACME-TEST")).thenReturn(true);assertThrows(DuplicateEmployeeException.class,()->service.create(req()));}
 @Test void missingEmployee(){when(repo.findById(99L)).thenReturn(Optional.empty());assertThrows(EmployeeNotFoundException.class,()->service.findById(99L));}
 private EmployeeRequest req(){return new EmployeeRequest("ACME-TEST","Aman","Kumar","aman@example.com","Engineering","Software Engineer","India","INR",
  new BigDecimal("100000.00"),new BigDecimal("10000.00"),LocalDate.of(2024,1,1));}
}

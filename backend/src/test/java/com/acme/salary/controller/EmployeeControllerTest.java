package com.acme.salary.controller;
import com.acme.salary.dto.EmployeeResponse; import com.acme.salary.service.EmployeeService; import org.junit.jupiter.api.Test; import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest; import org.springframework.boot.test.mock.mockito.MockBean; import org.springframework.data.domain.*;
import org.springframework.test.web.servlet.MockMvc; import java.math.*; import java.time.*; import java.util.*;
import static org.mockito.ArgumentMatchers.*; import static org.mockito.Mockito.when; import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
@WebMvcTest(EmployeeController.class)
class EmployeeControllerTest{
 @Autowired MockMvc mvc; @MockBean EmployeeService service;
 @Test void page() throws Exception{
  EmployeeResponse e=new EmployeeResponse(1L,"ACME-00001","Aman","Kumar","a@x.com","Engineering","Engineer","India","INR",new BigDecimal("100"),BigDecimal.ZERO,new BigDecimal("100"),LocalDate.of(2024,1,1),LocalDateTime.now(),LocalDateTime.now());
  when(service.findAll(isNull(),isNull(),isNull(),any(Pageable.class))).thenReturn(new PageImpl<>(List.of(e)));
  mvc.perform(get("/api/employees")).andExpect(status().isOk()).andExpect(jsonPath("$.content[0].employeeCode").value("ACME-00001"));
 }
}

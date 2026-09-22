package com.acme.salary.config;
import com.acme.salary.entity.Employee; import com.acme.salary.repository.EmployeeRepository; import org.springframework.boot.CommandLineRunner; import org.springframework.stereotype.Component;
import java.math.*; import java.time.*; import java.util.*;
@Component
public class DataSeeder implements CommandLineRunner{
 private final EmployeeRepository repo; public DataSeeder(EmployeeRepository r){repo=r;}
 private static final String[] F={"Aarav","Aditi","Aman","Ananya","Arjun","Diya","Ishaan","Kavya","Rohan","Sara","Emma","Olivia","Liam","Noah","Lucas","Mia","Sofia","Ethan","Maya","Leo"};
 private static final String[] L={"Sharma","Patel","Kumar","Singh","Mehta","Gupta","Smith","Brown","Martin","Garcia","Wilson","Taylor","Lee","Clark","Walker","Young","Hall","Allen","King","Wright"};
 private static final String[] D={"Engineering","Product","Sales","Marketing","Finance","People","Operations","Customer Success"};
 private static final String[] T={"Software Engineer","Senior Software Engineer","Engineering Manager","Product Manager","Business Analyst","Sales Manager","Financial Analyst","HR Specialist","Operations Analyst","Customer Success Manager"};
 private record C(String n,String c,int min,int max){}
 private static final C[] CS={new C("India","INR",700000,4500000),new C("United States","USD",65000,190000),new C("United Kingdom","GBP",45000,125000),
  new C("Germany","EUR",50000,130000),new C("France","EUR",45000,115000),new C("Singapore","SGD",65000,180000),new C("Australia","AUD",70000,175000),new C("Canada","CAD",60000,155000)};
 public void run(String...a){if(repo.count()>0)return;Random x=new Random(42);List<Employee>b=new ArrayList<>(500);
  for(int i=1;i<=10000;i++){C c=CS[x.nextInt(CS.length)];Employee e=new Employee();e.setEmployeeCode("ACME-"+String.format("%05d",i));e.setFirstName(F[x.nextInt(F.length)]);
   e.setLastName(L[x.nextInt(L.length)]);e.setEmail("employee"+i+"@acme.example");e.setDepartment(D[x.nextInt(D.length)]);e.setJobTitle(T[x.nextInt(T.length)]);
   e.setCountry(c.n());e.setCurrency(c.c());int sal=c.min()+x.nextInt(c.max()-c.min()+1);BigDecimal base=BigDecimal.valueOf(sal);e.setBaseSalary(base);
   e.setBonus(base.multiply(BigDecimal.valueOf(x.nextInt(21))).divide(BigDecimal.valueOf(100)));e.setJoiningDate(LocalDate.now().minusDays(x.nextInt(3650)+1));b.add(e);
   if(b.size()==500){repo.saveAll(b);b.clear();}} if(!b.isEmpty())repo.saveAll(b);}
}

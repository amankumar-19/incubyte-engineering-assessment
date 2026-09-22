import {Injectable} from '@angular/core'; import {HttpClient,HttpParams} from '@angular/common/http'; import {Observable} from 'rxjs'; import {Dashboard,Employee,EmployeeRequest,PageResponse,SalaryAggregate} from './models';
@Injectable({providedIn:'root'}) export class ApiService{
 private base='http://localhost:8080/api'; constructor(private http:HttpClient){}
 employees(q:{page:number;size:number;search?:string;department?:string;country?:string;sortBy?:string;direction?:string}):Observable<PageResponse<Employee>>{
  let p=new HttpParams().set('page',q.page).set('size',q.size).set('sortBy',q.sortBy??'lastName').set('direction',q.direction??'asc');
  if(q.search)p=p.set('search',q.search);if(q.department)p=p.set('department',q.department);if(q.country)p=p.set('country',q.country);
  return this.http.get<PageResponse<Employee>>(`${this.base}/employees`,{params:p});}
 employee(id:number){return this.http.get<Employee>(`${this.base}/employees/${id}`)}
 createEmployee(r:EmployeeRequest){return this.http.post<Employee>(`${this.base}/employees`,r)}
 updateEmployee(id:number,r:EmployeeRequest){return this.http.put<Employee>(`${this.base}/employees/${id}`,r)}
 deleteEmployee(id:number){return this.http.delete<void>(`${this.base}/employees/${id}`)}
 summary(){return this.http.get<Dashboard>(`${this.base}/analytics/summary`)}
 byDepartment(){return this.http.get<SalaryAggregate[]>(`${this.base}/analytics/by-department`)}
 byCountry(){return this.http.get<SalaryAggregate[]>(`${this.base}/analytics/by-country`)}
 departments(){return this.http.get<string[]>(`${this.base}/metadata/departments`)}
 countries(){return this.http.get<string[]>(`${this.base}/metadata/countries`)}
}

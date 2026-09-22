export interface Employee{id:number;employeeCode:string;firstName:string;lastName:string;email:string;department:string;jobTitle:string;country:string;currency:string;baseSalary:number;bonus:number;totalCompensation:number;joiningDate:string;createdAt:string;updatedAt:string}
export type EmployeeRequest=Omit<Employee,'id'|'totalCompensation'|'createdAt'|'updatedAt'>;
export interface PageResponse<T>{content:T[];totalElements:number;totalPages:number;size:number;number:number;first:boolean;last:boolean}
export interface CurrencySummary{currency:string;employeeCount:number;averageBaseSalary:number;minimumBaseSalary:number;maximumBaseSalary:number}
export interface Dashboard{totalEmployees:number;currencySummaries:CurrencySummary[]}
export interface SalaryAggregate{label:string;currency:string;employeeCount:number;averageBaseSalary:number;minimumBaseSalary:number;maximumBaseSalary:number}

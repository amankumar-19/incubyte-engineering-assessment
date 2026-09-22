# ACME Salary Management — Requirements

## Goal
Replace spreadsheet-based salary management for approximately 10,000 employees with a web application that lets an HR Manager maintain compensation data and answer common questions about how the organization pays people.

## Primary user
HR Manager.

## Core scope
- Paginated employee list.
- Search by name, employee code, email or job title.
- Filter by country and department; sort results.
- Create, view, update and delete salary records.
- Dashboard with employee count and salary statistics by currency.
- Salary analysis by department and country.
- Deterministic seed of 10,000 employees.
- Input validation and clear API errors.

## Data
Employee code, name, email, department, job title, country, currency, base salary, bonus, joining date and timestamps.

## Product decision
Salaries in different currencies are **not combined into a misleading global average**. Analytics preserve currency boundaries. Currency normalization needs an explicit FX-rate and effective-date policy.

## Non-functional requirements
Server-side pagination, deterministic tests, decimal money types, maintainable layered code, database-side aggregation, responsive UI.

## Deliberately out of scope
Payroll execution, tax calculation, real-time FX conversion, SSO/RBAC, Excel import/export, microservices/Kafka/Redis, and full salary-change audit history. These either belong to separate domains or add complexity not justified by the assessment's current scale.

## Success criteria
HR can quickly find and maintain salary records and understand compensation patterns by country, department and currency.

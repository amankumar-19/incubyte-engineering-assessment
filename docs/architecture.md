# Architecture

```text
Angular SPA -> HTTP/JSON -> Spring Boot Controllers -> Services -> Spring Data JPA -> H2
```

A modular monolith is intentional: 10,000 records and one cohesive domain do not justify distributed-system complexity.

Backend packages: `controller`, `service`, `repository`, `entity`, `dto`, `exception`, `config`.

Frontend uses standalone Angular components for Dashboard, Employee List, Employee Form and Employee Details, with API calls isolated in one service.

# Performance

10,000 employees is modest for a relational database. The UI uses server-side pagination (20 rows by default). Search/filter executes in the database via JPA Specifications. Indexes cover employee code, email, department and country. Analytics aggregate in SQL/JPA rather than loading all rows into Java.

At much larger scale, next steps would be query-plan inspection, measured composite indexes, production DB tuning, and caching only demonstrated hot queries.

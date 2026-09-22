# Decisions and Trade-offs

- **Modular monolith:** simplest architecture that meets current scale.
- **H2:** zero-setup relational DB for reviewers; JPA keeps migration to PostgreSQL straightforward.
- **BigDecimal:** avoids floating-point money errors.
- **Currency-aware analytics:** currencies are never silently averaged together.
- **Server-side pagination:** browser never needs all 10,000 rows.
- **Deterministic seed:** fixed random seed makes demos repeatable.
- **No authentication in assessment:** only one persona was specified. Real production release would require SSO/RBAC, audit logging and stronger security controls.

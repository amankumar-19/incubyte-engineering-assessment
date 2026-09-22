# Running

## Prerequisites
- Java 17+
- Maven 3.9+
- Node.js 20+
- npm 10+
- Git

Angular CLI does not need to be globally installed because the project uses the local CLI through npm scripts.

## VS Code: recommended local run

### Terminal 1 — backend
```bash
cd backend
mvn clean test
mvn spring-boot:run
```
Backend: `http://localhost:8080`

First startup seeds 10,000 employees. The local H2 file DB is under `backend/data/`.

### Terminal 2 — frontend
```bash
cd frontend
npm install
npm start
```
Frontend: `http://localhost:4200`

Open `http://localhost:4200`.

## Reset local data
Stop backend, delete `backend/data/`, then restart.

## Tests
```bash
cd backend
mvn test
```

```bash
cd frontend
npm test -- --watch=false
```

## Docker alternative
From repository root:
```bash
docker compose up --build
```
Open `http://localhost:4200`.

Stop:
```bash
docker compose down
```

Reset Docker data:
```bash
docker compose down -v
```

## Suggested incremental commits
Recreate commits in meaningful stages rather than submitting one generated commit:
1. `docs: define product requirements and scope`
2. `docs: document architecture and trade-offs`
3. `chore: initialize Spring Boot backend`
4. `feat: add employee persistence and validation`
5. `feat: implement employee CRUD and pagination`
6. `test: cover employee service and API`
7. `feat: add salary analytics and deterministic seed`
8. `chore: initialize Angular application`
9. `feat: implement salary dashboard`
10. `feat: implement employee management UI`
11. `test: add frontend API tests`
12. `chore: add docker packaging`
13. `docs: document AI workflow and demo`

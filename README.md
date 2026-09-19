# TaskFlow

<img align="left" width="40%" src="https://raw.githubusercontent.com/kubrvk/portfolio/main/img/galeri/site/10a.jpg"/>

<h3><a href="https://github.com/kubrvk/TaskFlow"><img src="https://img.shields.io/badge/GitHub-kubrvk%2FTaskFlow-000000?style=flat-square&logo=github&logoColor=white" height="25"/></a></h3>

![Java](https://img.shields.io/badge/Java_17-ED8B00?style=for-the-badges&logo=openjdk&logoColor=white) ![Spring Boot](https://img.shields.io/badge/Spring_Boot-6DB33F?style=for-the-badges&logo=springboot&logoColor=white) ![PostgreSQL](https://img.shields.io/badge/PostgreSQL-316192?style=for-the-badges&logo=postgresql&logoColor=white) ![React](https://img.shields.io/badge/React-61DAFB?style=for-the-badges&logo=react&logoColor=black) ![Docker](https://img.shields.io/badge/Docker-2496ED?style=for-the-badges&logo=docker&logoColor=white)

<br>

Enterprise HR & task management system with role-based authorization, hierarchical approvals, and audit logging.

<br clear="left"/>

---

## Technical Details

| Component | Specification |
|---|---|
| Backend Framework | Java 17, Spring Boot 3.x (Spring Web, Spring Data JPA) |
| Security & Auth | Spring Security, JWT (JSON Web Tokens), Role-Based Access Control |
| Database | PostgreSQL (Schema Migrations, Audit Trail Table Triggers) |
| Frontend Client | React, Modular Component Architecture, Axios |
| Containerization | Docker & Docker Compose |
| Audit Logging | Immutable User Action & Status Transition History |

---

## Code Overview & Architecture

```text
TaskFlow/
├── backend/
│   ├── src/main/java/com/taskflow/
│   │   ├── config/        # Security, JWT & CORS filters
│   │   ├── controllers/   # REST endpoints for users, tasks, approvals
│   │   ├── models/        # JPA Entities (User, Role, Task, AuditLog)
│   │   ├── repository/    # Spring Data JPA interfaces
│   │   └── services/      # Business logic & workflow validation
│   └── pom.xml
├── frontend/
│   ├── src/
│   │   ├── components/    # Reusable UI widgets & status badges
│   │   ├── pages/         # Dashboard, TaskBoard, ApprovalQueue
│   │   └── services/      # API communication layer
│   └── package.json
├── docker-compose.yml
└── README.md
```

---

## License & Author

Developed by **[Beraat Yetkin](https://github.com/kubrvk)**. All rights reserved.

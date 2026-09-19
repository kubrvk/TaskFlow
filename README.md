# TaskFlow — Enterprise Personnel & Task Orchestration Platform

![Build Status](https://img.shields.io/badge/Build-Passing-brightgreen?style=flat-square)
![Java](https://img.shields.io/badge/Java-17-orange?style=flat-square&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.2.3-green?style=flat-square&logo=springboot)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-16-blue?style=flat-square&logo=postgresql)
![Docker](https://img.shields.io/badge/Docker-Ready-2496ED?style=flat-square&logo=docker)
![License](https://img.shields.io/badge/License-MIT-purple?style=flat-square)

TaskFlow is a robust, production-grade enterprise task management and personnel workflow orchestration backend and dashboard. Designed with high-throughput micro-architecture principles, stateless JWT authentication, hierarchical approval gates, and an immutable audit trail for full compliance.

---

## 🏛️ System Architecture

```
                    +------------------------------------------+
                    |            React SPA Client              |
                    |        (Vite + Tailwind / TS)            |
                    +--------------------+---------------------+
                                         | REST / HTTPS
                                         v
+--------------------------------------------------------------------------------+
|                         Spring Boot 3 Core Backend                             |
|                                                                                |
|   +------------------------------------------------------------------------+   |
|   |                       Spring Security & JWT Filter                     |   |
|   +------------------------------------+-----------------------------------+   |
|                                        |                                       |
|                  +---------------------+---------------------+                 |
|                  |                                           |                 |
|                  v                                           v                 |
|      +-----------------------+                   +-----------------------+     |
|      |    Task Controller    |                   |   Audit Controller    |     |
|      +-----------+-----------+                   +-----------+-----------+     |
|                  |                                           |                 |
|                  v                                           v                 |
|      +-----------------------+                   +-----------------------+     |
|      |      Task Service     | <---------------- |   Audit Trail Engine  |     |
|      +-----------+-----------+                   +-----------+-----------+     |
|                  |                                           |                 |
|                  v                                           v                 |
|      +---------------------------------------------------------------+         |
|      |                   Spring Data JPA Layer                       |         |
|      +-------------------------------+-------------------------------+         |
+--------------------------------------|-----------------------------------------+
                                       |
                                       v
                       +-------------------------------+
                       |      PostgreSQL 16 Engine     |
                       | (Partitioned Tasks & Audits)  |
                       +-------------------------------+
```

---

## 🚀 Key Features

- **Role-Based Access Control (RBAC)**: Fine-grained permission model (`ADMIN`, `MANAGER`, `LEAD_DEVELOPER`, `DEVELOPER`, `AUDITOR`).
- **Immutable Audit Logging**: Every state transition, assignment change, and deletion automatically records caller metadata, IP, and timestamp.
- **Dynamic Task Board**: Full lifecycle tracking (`TODO` -> `IN_PROGRESS` -> `IN_REVIEW` -> `COMPLETED` -> `ARCHIVED`).
- **Stateless Authentication**: JJWT token evaluation with automatic revocation handling.
- **Containerized Deployment**: Ready-to-deploy Docker Compose topology with automated database health-checking.

---

## 📊 Database Schema (ERD Overview)

| Table | Primary Key | Key Foreign Keys | Purpose |
|---|---|---|---|
| `users` | `id (BIGSERIAL)` | `department_id -> departments(id)` | Authentication, roles, identity |
| `departments` | `id (BIGSERIAL)` | None | Organizational grouping |
| `tasks` | `id (BIGSERIAL)` | `assignee_id, reporter_id -> users(id)` | Task lifecycle & metadata |
| `audit_logs` | `id (BIGSERIAL)` | None | Immutable compliance journal |

---

## 🔌 REST API Endpoints

### Authentication (`/api/v1/auth`)
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| `POST` | `/api/v1/auth/login` | Authenticate credentials & retrieve JWT | No |
| `POST` | `/api/v1/auth/refresh` | Exchange refresh token | Yes |

### Tasks (`/api/v1/tasks`)
| Method | Endpoint | Description | Auth Required |
|---|---|---|---|
| `GET` | `/api/v1/tasks` | Paginated task list with filter params | Yes |
| `GET` | `/api/v1/tasks/{id}` | Detailed task metadata | Yes |
| `POST` | `/api/v1/tasks` | Create new workflow task | Yes (Manager+) |
| `PATCH` | `/api/v1/tasks/{id}/status` | Transition task state | Yes |
| `DELETE` | `/api/v1/tasks/{id}` | Soft-delete / archive task | Yes (Admin) |

### Sample Payload (`POST /api/v1/tasks`):
```json
{
  "title": "Database Read-Replica Provisioning",
  "description": "Configure RDS read replicas for Europe central cluster",
  "priority": "HIGH",
  "status": "TODO",
  "assigneeId": 14,
  "dueDate": "2026-10-15T18:00:00Z"
}
```

---

## 💻 Local Development Setup

### Prerequisites
- **JDK 17** or higher
- **Maven 3.8+**
- **Docker & Docker Compose**

### 1. Clone & Run with Docker Compose
```bash
git clone https://github.com/kubrvk/TaskFlow.git
cd TaskFlow

# Spin up Postgres & Spring Boot Backend in one command
docker compose up -d --build
```

The API will be live at `http://localhost:8080/api/v1/tasks`.

### 2. Manual Build & Run
```bash
# Start Postgres only
docker compose up -d taskflow-db

# Compile and start Spring Boot
./mvnw clean spring-boot:run
```

---

## 👤 Author & License

- **Author**: `kubrvk` ([GitHub Profile](https://github.com/kubrvk))
- **License**: MIT License — see [LICENSE](LICENSE) for details.

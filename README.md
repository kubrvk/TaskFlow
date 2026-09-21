# TaskFlow.Ops
> Agile & DevOps Task Management Board • Linear & Jira Architecture

[![Live Demo](https://img.shields.io/badge/Live_Demo-taskflowops.web.app-6366f1?style=for-the-badge)](https://taskflowops.web.app)
[![License](https://img.shields.io/badge/License-MIT-blue.svg?style=for-the-badge)](LICENSE)
[![Technology](https://img.shields.io/badge/Technology-Vanilla_ES6%2B-yellow?style=for-the-badge)](https://developer.mozilla.org)
[![Interface](https://img.shields.io/badge/Interface-CSS3_Grid_Flexbox-orange?style=for-the-badge)](https://developer.mozilla.org)
[![Language Support](https://img.shields.io/badge/Language-English_%7C_Turkish-green?style=for-the-badge)](https://taskflowops.web.app)

---

## Previews

### 1. Agile & DevOps Sprint Board
Linear and Jira-inspired 4-column Kanban board featuring sprint progress tracking and prominent red task deletion actions on every card:
![TaskFlow Dashboard Preview](docs/preview-dashboard.png)

### 2. Developer Command Deck Login Portal
Kubernetes cluster telemetry breadcrumbs, dot-matrix grid, SSH/API authentication inputs, and pre-configured role presets:
![TaskFlow Login Preview](docs/preview-login.png)

---

## Key Features

### Agile & DevOps Architecture
- Linear and Jira-inspired modern design featuring a dark indigo background, fixed left quick-dock, and active sprint progress card.
- 4-column Kanban workflow: Backlog, In Progress, Under Review, and Completed with smooth card transitions.
- Live DevOps audit trail simulating PostgreSQL system logs for task creation, state transitions, and deletion events.

### Prominent Task Deletion Mechanism
- Prominent red labeled Delete button placed in the footer of every Kanban card next to the Advance action for immediate discoverability.
- Trash icon in the card header enlarged with an active red hover effect.
- Direct task removal actions in the sprint approval queue table.
- Dynamic recalculation: deleting a task triggers a confirmation modal, removes the card from the DOM, updates localStorage, recalculates sprint completion percentage and velocity metrics, and writes an audit log entry.

### Session Persistence & Zero-Flicker Initialization
- Remembers login state across page reloads using browser localStorage.
- Zero-flicker inline execution: verifying authentication state before paint prevents login overlay flash upon page reload.
- Secure sign-out action cleans up stored session tokens and returns to the login screen.
- Pre-filled demo credentials and one-click role switchers (DevOps Lead, Security Auditor, Client Lead, Developer).

### Bilingual Support (English | Turkish)
- Instant language toggle in the header switching all Kanban column titles, modal content, toast alerts, and badges without reloading the page.
- Default language is English.

---

## Tech Stack

| Layer | Technology | Purpose |
| :--- | :--- | :--- |
| UI & Layout | HTML5, CSS3 Grid, Flexbox | Dark mode agile layout, responsive mobile design |
| Logic & State | Vanilla ES6+ JavaScript | Zero external frameworks, reactive state management |
| Icons | Bootstrap Icons v1.11.3 | System icons |
| Persistence | HTML5 localStorage | Tasks, audit logs, session state, and language preferences |
| Hosting | Firebase Hosting | Global CDN deployment with SSL encryption |

---

## Directory Structure

```
TaskFlow/
├── index.html              # Complete single-page application
├── docs/                   # Documentation assets and screenshots
│   ├── preview-dashboard.png # High-resolution dashboard preview
│   └── preview-login.png     # High-resolution login portal preview
└── README.md               # Project documentation
```

---

## Getting Started

Run locally without build steps, package managers, or compilers:

1. Clone the repository:
   ```bash
   git clone https://github.com/kubrvk/TaskFlow.git
   cd TaskFlow
   ```
2. Open `index.html` directly in any web browser:
   ```bash
   start index.html
   ```
3. Alternatively, serve with any local HTTP server:
   ```bash
   npx serve .
   ```
4. Access `http://localhost:3000` in your browser.
   - To bypass login and view the dashboard directly: `http://localhost:3000/?demo=1`

---

## Live System

- Live URL: [https://taskflowops.web.app](https://taskflowops.web.app)
- Direct Dashboard Link: [https://taskflowops.web.app/?demo=1](https://taskflowops.web.app/?demo=1)

---

## Author

Developed by Beraat Yetkin
- GitHub: [@kubrvk](https://github.com/kubrvk)
- Repository: [TaskFlow](https://github.com/kubrvk/TaskFlow)
- Portfolio: [Beraat Yetkin Portfolio](https://github.com/kubrvk/portfolio)

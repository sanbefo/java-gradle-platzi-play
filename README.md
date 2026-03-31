# 🎬 Platzi Play API

A modern **Spring Boot 3 REST API** for movie management, integrated with **PostgreSQL** for data persistence and **LangChain4j** for AI-powered features using **Google Gemini**.

---

## 🛠 Features

- 🎥 **Movie Management**: Full CRUD operations for a cinema catalog
- 🤖 **AI Integration**: Powered by LangChain4j and Google Gemini 1.5 Pro
- 🗄️ **Database Versioning**: Automatic schema generation and data seeding
- 🐳 **Containerized**: Fully orchestrated using Docker and Docker Compose

---

## 🚀 Getting Started

### ✅ Prerequisites

- Java 21 or higher
- Docker Desktop (includes Docker Compose)
- A Google Gemini API Key

---

### 1. Build the Application

Generate the executable JAR file using the Gradle wrapper:
```
./gradlew clean bootJar
```

### 2. Launch with Docker Compose

Run the entire stack (App + Database) with a single command:

```
docker compose up --build
```

---

## 📦 Tech Stack

| Technology         | Usage                      |
|-------------------|----------------------------|
| Spring Boot 3.3.5 | Core Framework             |
| Spring Data JPA   | ORM & Persistence          |
| PostgreSQL 16     | Relational Database        |
| LangChain4j       | AI / LLM Orchestration     |
| Hibernate         | Schema Auto-generation     |
| Docker            | Infrastructure & Deployment|

---

## ⚙️ Environment Configuration

The application uses **Spring Profiles**. The `dev` profile is active by default.

### Key Properties (`application-dev.properties`)

```properties
spring.jpa.hibernate.ddl-auto=update
spring.jpa.defer-datasource-initialization=true
spring.sql.init.mode=always
spring.jpa.hibernate.ddl-auto=update → Automatically creates/updates tables based on Java entities
spring.jpa.defer-datasource-initialization=true → Ensures Hibernate creates the schema before data.sql inserts records
spring.sql.init.mode=always → Seeds the movie catalog on every startup
```


## 📡 API Endpoints

Base URL:
```
http://localhost:8080/platzi-play/api
```
| Method    | Endpoint          | Description                         |
|-----------|-------------------|-------------------------------------|
| GET       | `/movies`         | List all available movies           |
| POST      | `/movies`         | Add a new movie to the catalog      |
| GET       | `/movies/{id}`    | Get details of a specific movie     |
| POST      | `/movies/{ID}`    | Edits a specific movie              |
| PUT       | `/movies/`        | Creates a new movie                 |
| DELETE    | `/movies/{id}`    | Deletes a specific movie            |
| GET       | `/movies/suggest` | Suggests movies depending on a message |

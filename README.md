**English** | [日本語](README.ja.md)

# Game Project Task Board (Spring Boot)

[![Java 21](https://img.shields.io/badge/Java-21-ED8B00?logo=openjdk&logoColor=white)](#)
[![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.3.5-6DB33F?logo=spring-boot&logoColor=white)](#)
[![MySQL](https://img.shields.io/badge/MySQL-4479A1?logo=mysql&logoColor=white)](#)
[![AWS RDS](https://img.shields.io/badge/AWS-RDS-FF9900?logo=amazonaws&logoColor=white)](#)

A web-based task and effort-management backend for team game development.

> **Status:** the app was once deployed on AWS (EC2 / RDS). The cloud resources have been shut down to save cost, so there is no live demo. Source code and local run instructions are here.

## Problem

In projects like game development, a parent task ("implement character") breaks into child tasks (modelling, motion, effects). Seeing the whole hierarchy and an accurate total estimate is hard in flat to-do lists.

## Solution

- **Tree-structured tasks:** unlimited parent/child nesting stored in the database.
- **Recursive effort roll-up:** `ProjectNodeService` sums estimates from the leaf subtasks up through parents to the root project.
- **REST API** returning JSON, with a separate lightweight HTML/JavaScript front end.
- **Switchable database:** H2 for local development, MySQL on AWS RDS in production, selected through environment variables.

Example endpoints: `GET /api/tasks`, `POST /api/tasks`, `GET /api/projects/{id}/effort`.

## Tech stack

Java 21 · Spring Boot 3.3.5 · Spring Data JPA · Thymeleaf · MySQL (AWS RDS) / H2 · Maven · vanilla JavaScript

## Run locally

```bash
./mvnw spring-boot:run
```

For a MySQL database, copy `src/main/resources/application-local.properties.example` to `application-local.properties` and fill in your own connection details (that file must not be committed).

More detailed notes (Japanese): [docs/DETAILS.ja.md](docs/DETAILS.ja.md).

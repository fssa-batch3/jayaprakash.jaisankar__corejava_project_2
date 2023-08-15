# sec_a_jayaprakash.jaisankar__corejava_project_2

# Project and Task Management Website

## Table of Contents

- [Introduction](#introduction)
- [Purpose](#purpose)
- [Features](#features)
- [User Persona](#user-persona)
- [JavaDoc](#javadoc)
- [Prerequisites](#prerequisites)
  - [Software Requirements](#software-requirements)
  - [Database Setup](#database-setup)
- [Project Setup](#project-setup)
  - [Java Project Creation](#java-project-creation)
  - [Library Dependencies](#library-dependencies)
- [Database](#database)
  - [Entity-Relationship Diagram (ERD)](#entity-relationship-diagram-erd)
  - [Database Tables](#database-tables)
- [Modules](#modules)
  - [User Module](#user-module)
  - [Project Module](#book-module)
  - [Task Module](#borrow-module)
- [Validations](#validations)
  - [User Validations](#user-validations)
  - [Project Validations](#book-validations)
  - [Task Validations](#borrow-validations)
- [Testing](#testing)
  - [Unit Testing](#unit-testing)
  - [Exception Handling](#exception-handling)
  - [Common Error Messages](#common-error-messages)
- [Future Improvements](#future-improvements)
  - [Planned Features](#planned-features)
- [Roadmap](#roadmap)
- [Resources](#resources)
  - [External Libraries](#external-libraries)
  - [References](#references)

## Introduction

Develop a Java-based Library Management System to efficiently manage the inventory, borrowing, and returning of books for a local library.

## Purpose

The purpose of the "Project and Task Management Website" is to provide a centralized platform for efficiently organizing, tracking, and collaborating on projects and tasks, enhancing productivity and teamwork.

## Features

- Add, update, view, delete, search, and list all books.
- Register, login, update, and delete users.
- 

## User Persona

- Librarian
- Members

## JavaDoc

[JavaDoc Documentation](#) [Provide a link to your JavaDoc documentation if available]

## Prerequisites

### Software Requirements

- Java Development Kit (JDK)
- MySQL Database Server
- Integrated Development Environment

### Database Setup

Execute the provided SQL script to set up the necessary database tables.

## Project Setup

### Java Project Creation

- Create a new Java project.
- Set up a MySQL database for the project.

### Library Dependencies

- JDBC
- MySQL Connector
- JUnit

## Database

### Entity-Relationship Diagram (ERD)

[Insert a link to your ERD image]

### Database Tables

#### Table: users

[Describe the fields, types, and constraints of the users table]

#### Table: books

[Describe the fields, types, and constraints of the books table]

#### Table: borrows

[Describe the fields, types, and constraints of the borrows table]

## Modules

### User Module

- Add a user
- Update user details
- Remove a user
- Search users
- View user details
- List all users

### Project Module

- Add a project
- Update project details
- Remove a project
- Search projects
- View project details
- List all projects

## Validations

### User Validations

- validateUsername
- validateGender
- validatemobilenumber
- validatedateofbirth
- validateemailaddress
- validatepassword
- validateaddress

### Project Validations

- validateProjectName
- validateProjectDue
- validateProjectDetails
- validateProjectCategory
- validateProjectAssignee
- validateProjectStatus
- validateProjectName
-validateProjectPriority
-validateProjectTags
-validateTodoId



## Testing

### Unit Testing

- UserServiceUnitTest
- ProjectServiceUnitTest
- UserValidationUnitTest
- ProjectValidationUnitTest


### Exception Handling

- Custom Exceptions
  - DAO Exception
  - Validation Exception
  - Service Exception

### Common Error Messages

- Name cannot be null or empty
- Invalid Password
- Invalid email address
- Invalid phone number
- User already exists
- Project not found
- Failed to update user information
- Failed to update project information
- Failed to return the project
- Database connection error

## Future Improvements

### Planned Features

- Reviews and Ratings
- Advanced project and task Search

## Roadmap

- Data Analytics and Insights

## Resources

### External Libraries

- JDBC
- MySQL Connector
- JUnit

### References

- Java Platform, Standard Edition Documentation: [https://docs.oracle.com/javase/8/docs/api/](https://docs.oracle.com/javase/8/docs/api/)
- MySQL Documentation: [https://dev.mysql.com/doc/](https://dev.mysql.com/doc/)
- JUnit 5 User Guide: [https://junit.org/junit5/docs/current/user-guide/](https://junit.org/junit5/docs/current/user-guide/)


# Core Java Project Database 

This document provides an overview of the database structure and the SQL queries used in the Core Java project.

## Database Structure

### Table: users

- id (Primary Key)
- name (Not Null)
- gender
- mobile_number
- date_of_birth
- address (Text)
- about_me (Text)
- email (Not Null, Unique)
- password (Not Null)
- profile_pic
- mytodos (JSON)
- user_id (Foreign Key to users)

### Table: tasks

- id (Primary Key)
- taskname
- taskdetails (Text)
- taskcategory
- taskdue
- taskassignee
- taskstatus
- projectname
- taskpriority
- tasktags
- todoID (Unique)

### Table: projecttask

- id (Primary Key)
- user_id (Foreign Key to users)
- taskname
- taskdetails (Text)
- taskcategory
- taskdue
- taskassignee
- taskstatus
- projectname
- taskpriority
- tasktags
- todoID (Unique)
- created_at (Timestamp)
- updated_at (Timestamp)
- project_id (Foreign Key to academic_projects)

### Table: personaltasks

- id (Primary Key)
- task_name (Not Null)
- task_date
- task_time
- reminder

### Table: academic_projects

- id (Primary Key)
- project_name
- project_description (Text)
- start_date
- end_date
- project_status

## SQL Queries

```sql
-- SELECT all records from the users table
SELECT * FROM users;

-- SELECT all records from the tasks table
SELECT * FROM tasks;

-- SELECT all records from the academic_projects table
SELECT * FROM academic_projects;

-- SELECT tasks and their associated project names using INNER JOIN
SELECT tasks.*, academic_projects.project_name
FROM tasks
INNER JOIN academic_projects ON tasks.project_id = academic_projects.id;

# sec_a_jayaprakash.jaisankar__corejava_project_2







# Core Java Project Database README

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

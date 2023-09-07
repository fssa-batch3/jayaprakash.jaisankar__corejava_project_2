USE jayaprakash_jaisankar_corejava_project;
CREATE TABLE users (
id INT AUTO_INCREMENT PRIMARY KEY,
name VARCHAR(255) NOT NULL,
gender VARCHAR(20),
mobile_number VARCHAR(15),
date_of_birth DATE,
address TEXT,
about_me TEXT,
email VARCHAR(255) NOT NULL UNIQUE,
password VARCHAR(255) NOT NULL,
profile_pic VARCHAR(255),
mytodos JSON,
user_id BIGINT
);

ALTER TABLE users
ADD COLUMN isDeleted BOOLEAN DEFAULT false;

SELECT *
FROM users;

SELECT *
FROM tasks;
SELECT *
FROM milestone;
CREATE TABLE tasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  taskname VARCHAR(255),
  taskdetails TEXT,
  taskcategory VARCHAR(50),
  taskdue DATE,
  taskassignee VARCHAR(100),
  taskstatus VARCHAR(50),
  projectname VARCHAR(100),
  taskpriority VARCHAR(50),
  tasktags VARCHAR(255),
  todoID VARCHAR(36) UNIQUE
);
-- 1. Identify Dependencies (if not already done)
-- Example: You have identified that the "milestone" table references the "tasks" table with a foreign key constraint.

-- 2. Remove Foreign Key Constraint (if applicable)
ALTER TABLE milestone DROP FOREIGN KEY milestone_ibfk_1;  -- Adjust constraint name as needed
ALTER TABLE milestone
ADD CONSTRAINT milestone_ibfk_1
FOREIGN KEY (task_id) REFERENCES tasks(id);

-- 3. Drop the "tasks" Table
DROP TABLE tasks;


ALTER TABLE tasks
ADD CONSTRAINT fk_user_task
FOREIGN KEY (user_task_id) REFERENCES users(id);


CREATE TABLE projecttask (
  id INT AUTO_INCREMENT PRIMARY KEY,
  user_id INT,
  taskname VARCHAR(255),
  taskdetails TEXT,
  taskcategory VARCHAR(50),
  taskdue DATE,
  taskassignee VARCHAR(100),
  taskstatus VARCHAR(50),
  projectname VARCHAR(100),
  taskpriority VARCHAR(50),
  tasktags VARCHAR(255),
  todoID VARCHAR(36) UNIQUE,
  created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  FOREIGN KEY (user_id) REFERENCES users(id)
);



-- Create the tasks table
CREATE TABLE milestone (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_text VARCHAR(255) NOT NULL,
    task_date DATE,
    task_time TIME,
    is_remainder BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

ALTER TABLE milestone ADD COLUMN tasks_id INT,
  ADD FOREIGN KEY (tasks_id) REFERENCES tasks(id);
INSERT INTO milestone (task_text, task_date, task_time, is_remainder, tasks_id)
VALUES ( 'Complete Report', '2023-08-25', '14:30:00', true, 1);
select *
from milestone;

drop table  milestone;

-- Perform an inner join between projecttask and tasks tables
SELECT pt.*, t.*
FROM tasks pt
INNER JOIN milestone t ON pt.id= t.tasks_id;	





INSERT INTO milestone (todoID, task_text, task_date, task_time, is_remainder)
VALUES ('your_todo_id_here', 'Task Text', '2023-08-25', '14:30:00', 1);

CREATE TABLE personaltasks (
  id INT AUTO_INCREMENT PRIMARY KEY,
  task_name VARCHAR(255) NOT NULL,
  task_date DATE,
  task_time TIME,
  reminder BOOLEAN
);


CREATE TABLE academic_projects (
  id INT AUTO_INCREMENT PRIMARY KEY,
  project_name VARCHAR(255),
  project_description TEXT,
  start_date DATE,
  end_date DATE,
  project_status VARCHAR(50)
);


SELECT *
FROM milestone;
ALTER TABLE milestone
CHANGE COLUMN id t_id INT AUTO_INCREMENT PRIMARY KEY;


ALTER TABLE tasks ADD COLUMN project_id INT,
  ADD FOREIGN KEY (project_id) REFERENCES academic_projects(id);



SELECT tasks.*, academic_projects.project_name
FROM tasks
INNER JOIN academic_projects ON tasks.project_id = academic_projects.id;
SELECT *
FROM tasks;


SELECT *
FROM milestone;


SELECT *
FROM milestone;
INSERT INTO milestone (todoID, task_text, task_date, task_time, is_remainder)
VALUES ('abcdef0123456789ABCDEF0987654321', 'Complete Report', '2023-08-25', '14:30:00', 1);

SELECT *
FROM users;

-- Use the specified database
USE jayaprakash_jaisankar_corejava_project;

-- Create the "users" table
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

-- Add the "isDeleted" column to the "users" table
ALTER TABLE users
ADD COLUMN isDeleted BOOLEAN DEFAULT false;

-- Create the "tasks" table
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

-- Create the "projecttask" table with timestamps and a foreign key reference
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

-- Create the "milestone" table with timestamps and a foreign key reference to "tasks"
CREATE TABLE milestone (
    id INT AUTO_INCREMENT PRIMARY KEY,
    task_text VARCHAR(255) NOT NULL,
    task_date DATE,
    task_time TIME,
    is_remainder BOOLEAN,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    tasks_id INT, -- Add "tasks_id" column
    FOREIGN KEY (tasks_id) REFERENCES tasks(id) -- Define the foreign key constraint
);

-- Insert a sample record into the "milestone" table
INSERT INTO milestone (task_text, task_date, task_time, is_remainder, tasks_id)
VALUES ('Complete Report', '2023-08-25', '14:30:00', true, 1);

-- Perform an inner join between "projecttask" and "milestone" tables
SELECT pt.*, m.*
FROM projecttask pt
INNER JOIN milestone m ON pt.id = m.tasks_id;

-- Insert another sample record into the "milestone" table
INSERT INTO milestone (task_text, task_date, task_time, is_remainder, tasks_id)
VALUES ('Another Task', '2023-08-26', '15:00:00', false, 2);

-- Retrieve records from the "users" table
SELECT *
FROM users;

-- Retrieve records from the "milestone" table
SELECT *
FROM milestone;

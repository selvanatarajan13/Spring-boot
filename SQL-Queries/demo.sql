show databases;

use student_tracker;

show tables;

CREATE TABLE Employee_Salary (
  Employee_ID INT PRIMARY KEY,
  First_Name VARCHAR(255),
  Last_Name VARCHAR(255),
  Department VARCHAR(255),
  Job_Title VARCHAR(255),
  Salary DECIMAL(10, 2)
);

INSERT INTO Employee_Salary (Employee_ID, First_Name, Last_Name, Department, Job_Title, Salary)
VALUES
  (1, 'John', 'Doe', 'Sales', 'Sales Manager', 80000.00),
  (2, 'Jane', 'Smith', 'Marketing', 'Marketing Manager', 90000.00),
  (3, 'Bob', 'Johnson', 'IT', 'Software Engineer', 100000.00),
  (4, 'Alice', 'Williams', 'HR', 'HR Manager', 70000.00),
  (5, 'Mike', 'Brown', 'Finance', 'Financial Analyst', 60000.00),
  (6, 'Emily', 'Davis', 'Sales', 'Sales Representative', 50000.00),
  (7, 'David', 'Miller', 'Marketing', 'Marketing Coordinator', 45000.00),
  (8, 'Sarah', 'Wilson', 'IT', 'IT Support Specialist', 40000.00),
  (9, 'Kevin', 'Moore', 'HR', 'HR Generalist', 35000.00),
  (10, 'Lisa', 'Taylor', 'Finance', 'Accountant', 30000.00),
  (11, 'Peter', 'Anderson', 'Sales', 'Sales Representative', 50000.00),
  (12, 'Hannah', 'Thomas', 'Marketing', 'Marketing Coordinator', 45000.00),
  (13, 'Michael', 'Jackson', 'IT', 'Software Engineer', 100000.00),
  (14, 'Olivia', 'White', 'HR', 'HR Manager', 70000.00),
  (15, 'William', 'Harris', 'Finance', 'Financial Analyst', 60000.00),
  (16, 'Ava', 'Martin', 'Sales', 'Sales Representative', 50000.00),
  (17, 'James', 'Thompson', 'Marketing', 'Marketing Manager', 90000.00),
  (18, 'Isabella', 'Garcia', 'IT', 'IT Support Specialist', 40000.00),
  (19, 'Benjamin', 'Martinez', 'HR', 'HR Generalist', 35000.00),
  (20, 'Sophia', 'Robinson', 'Finance', 'Accountant', 30000.00);


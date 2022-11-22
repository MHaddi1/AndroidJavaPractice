create database lab11

use lab11

Create table Department(
Department_Id int primary key identity(1,1),
Department_name nvarchar(100) not null
) 
--DROP TABLE Department

CREATE TABLE Employee(
employee_Id int primary key identity(1,1),
employee_F_name nvarchar(100) not null,
employee_L_name nvarchar(100) not null,
birth_date date not null,
cell_phone nvarchar(100) not null,
Salary money not null,
D_ID INT FOREIGN KEY references Department(Department_Id),
)

--DROP TABLE Employee
insert into Department(Department_name)
values('Software Engineer'),('Computer Science'),('Aritifical Intelligence'),('BS Gaming'),('Data Science')

SELECT * FROM Department

insert into Employee(employee_F_name,employee_L_name,birth_date,cell_phone,D_ID,Salary)
values('Muhammad','Haddi','1999-10-12','03206851690',1,100000),('Muhammad','Usma','1999-10-12','03206851690',2,200023),
('Muhammad','Ahmad','1990-10-12','03206851690',3,24234),
('Muhammad','Kamran','1989-4-12','03206851690',4,21411),
('Muhammad','Usman','1999-12-30','03206851690',5,24123)
SELECT * FROM Employee

SELECT COUNT(employee_Id) AS 'TOTAL Employee' from Employee

SELECT top 1 Salary from Employee
 where Salary > (Select min(Salary) FROM Employee) order by Salary DESC

 SELECT top 1 Salary from Employee
 where Salary < (Select max(Salary) FROM Employee) order by Salary ASC





CREATE database University
USE University;
CREATE TABLE departmentA(
	DepID INT PRIMARY KEY IDENTITY(1,1),
	DName NVARCHAR(50) NOT NULL,
	DeptLoc NVARCHAR(150) NOT NULL,
	Phone INT NOT NULL,
);

CREATE TABLE employee(
	EmpID INT PRIMARY KEY IDENTITY(1,1),
	EFName NVARCHAR(200),
	ELName NVARCHAR(200),
	EAddress NVARCHAR(250),
	Email NVARCHAR(50) UNIQUE CHECK(Email LIKE '[A-Za-z]__%Q@__%.__%'),
	CNIC INT UNIQUE CHECK (CNIC LIKE '[][][][][]-[][][][][][][]-[]'),
	DOB DATE,
	DOJ DATE DEFAULT getdate(),
	Salary MONEY,
	Did INT FOREIGN KEY REFERENCES departmentA(DepID) NOT NULL,
);
	
CREATE TABLE Project(
pro_Id int IDENTITY (1,1) PRIMARY KEY ,
Pro_name nvarchar(50) NOT NULL,
Pro_start_date date default getdate(),
Pro_End_Date DATE Not Null,
Discription NVARCHAR(MAX) DEFAULT 'NOT AVAILABLE'
);
CREATE TABLE emp_project(
pro_emp_Id INT PRIMARY KEY IDENTITY(1,1),
Pro_Id INT FOREIGN KEY REFERENCES Project(pro_Id),
Emp_Id INT FOREIGN KEY REFERENCES employee(EmpID),
ASSIGN_DATE DATE DEFAULT GETDATE(),
CONSTRAINT UNIQUE_ck UNIQUE (pro_Id, Emp_Id,ASSIGN_DATE)
); 
INSERT INTO departmentA(DName,DeptLoc,Phone) VALUES ('SOFTWARE ENGINEERING','GOLD CAMPUS',0320334343),('MASS COMMUNICATION','GOLD CAMPUS',0320334323),('DATA SCIENCE','GOLD CAMPUS',0320334343);
SELECT * FROM departmentA 
INSERT INTO employee(EFName,ELName,Email,EAddress,CNIC,DOB,Salary,Did)
values('Muhammad','Haddi','haddi.kaleem@gmail.com','lahore',12345-1234567-1,'10-10-2002',1000000,(select DepID from departmentA where DName = 'SOFTWARE ENGINEERING'))
DELETE from departmentA where DepID = 3
-----ALTER QUREEIES
ALTER TABLE employee
Drop someConstraints;
select DATEDIFF(yy, '12-10-2000',getdate())as "Muhammad Haddi"


ALTER TABLE employee 
add CONSTRAINT ck_age check (datediff(yy,DOB,GETDATE())>=18 AND datediff(YY,DOB,GETDATE())<=60)


EXEC sp_help
--variale 

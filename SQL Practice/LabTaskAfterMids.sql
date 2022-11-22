--Question no 1
CREATE DATABASE EmpolyeeTask
USE EmpolyeeTask;
CREATE TABLE Empolyee(
E_ID INT PRIMARY KEY IDENTITY(1,1),
E_name NVARCHAR(100) NOT NULL,
DOB DATE NOT NULL,
E_city NVARCHAR(100),
StreatAddress NVARCHAR(200),
BloodGroup NVARCHAR(100),
Cell INT NOT NULL,
Salary MONEY NOT NULL 
);
drop Table Empolyee
--Question no 2
INSERT INTO Empolyee(E_name,StreatAddress,BloodGroup,DOB,Cell,Salary,E_city)
VALUES('Muhammad Haddi', 'Shahdara Lahore', 'O+', '2022-3-14', 2,190000,'Lahore');
INSERT INTO Empolyee(E_name,StreatAddress,BloodGroup,DOB,Cell,Salary,E_city)
VALUES('Muhammad Ammar', 'Shahdara Lahore', 'O-', '2022-3-14', 2,190000,'Lahore'),
('Muhammad Ahmad', 'Wapda Town', 'AB+', '2002-3-14', 2,190000,'Lahore')
,('Muhammad Qasim', 'Johir Town', 'O+', '2000-3-14', 2,190000,'Lahore'),
('Muhammad Hassam', 'Shahdara Lahore', 'AB-', '2012-3-14', 2,190000,'Lahore')
,('Muhammad Ibraheem', 'Shahdara Lahore', 'A+', '1998-3-14', 2,190000,'Lahore'),
('Muhammad Ahsan', 'Bahria Town', 'AB-', '2009-3-14', 2,190000,'Lahore'),
('Muhammad Kaleem', 'Shahdara Lahore', 'AB+', '2002-3-14', 2,190000,'Lahore'),
('Kashan', 'Shahdara Lahore', 'O-', '2002-3-14', 2,190000,'Lahore')
SELECT * FROM Empolyee

INSERT INTO Empolyee(E_name,StreatAddress,BloodGroup,DOB,Cell,Salary)
VALUES('Muhammad Kamran ', 'Shahdara Lahore', 'O+', '2022-3-14', 2 ,190000)
INSERT INTO Empolyee(E_name,BloodGroup,DOB,Cell,Salary,E_city)
VALUES('Muhammad Ammar', 'O-', '2000-3-14', 2,190000,'Lahore')
VALUES('Muhammad Ammar', 'O-', '1972-3-14', 2,190000,'Lahore')
VALUES('Muhammad Ammar', 'O-', '1990-3-14', 2,190000,'Lahore')
INSERT INTO Empolyee(E_name,StreatAddress,DOB,Cell,Salary,E_city)
VALUES('Muhammad Ammar', 'Shahdara Lahore', '1999-3-14', 2,190000,'Lahore')
INSERT INTO Empolyee(E_name,StreatAddress,DOB,Cell,Salary,E_city)
VALUES('Muhammad', 'Shahdara Lahore', '1999-3-14', 2,60000,'Lahore')



--Question no 3
Select E_name from Empolyee WHERE BloodGroup is null
UPDATE Empolyee
set BloodGroup = 'AB+' WHERE BloodGroup is NULL

Select E_name from Empolyee WHERE E_city is null
UPDATE Empolyee
set E_city = 'Lahore' WHERE E_city is NULL

Select E_name from Empolyee WHERE StreatAddress is null
UPDATE Empolyee
set StreatAddress = ' Amaan town ' WHERE E_city is NULL


--Question no 4
DELETE FROM Empolyee WHERE E_ID=10;

DELETE FROM Empolyee WHERE StreatAddress = 'Amman town'

DELETE FROM Empolyee WHERE (DATEDIFF(YY,DOB,GETDATE())) > 10 and (DATEDIFF(YY,DOB,GETDATE())) < 17

SELECT * FROM Empolyee




-- Question no 5
SELECT (MAX(DATEDIFF(YY,DOB,GETDATE()))) as MaxAge FROM Empolyee

SELECT (MIN(DATEDIFF(YY,DOB,GETDATE()))) as MinAge FROM Empolyee

SELECT (AVG(DATEDIFF(YY,DOB,GETDATE()))) as AvgAge , (AVG(salary)) as AvgSalary FROM Empolyee








--Practice Question no 5 (2.1)
SELECT E_ID,Salary,E_name From Empolyee where Salary > 50000
SELECT E_ID,Salary,E_name From Empolyee where E_name = 'Kashan'





select * from Empolyee where Salary is not null

SELECT (MIN(DATEDIFF(YY,DOB,GETDATE()))) as MinAge FROM Empolyee

SELECT top 3 E_name , E_city from Empolyee order by E_city 
SELECT min(Salary) from Empolyee
--
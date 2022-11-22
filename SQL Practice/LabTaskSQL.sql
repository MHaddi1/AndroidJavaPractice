CREATE DATABASE dbms

CREATE TABLE salesman (
salesman_id bigint PRIMARY KEY IDENTITY(5001,1),
Name nvarchar(100) NOT NULL,
city nvarchar(70)NOT NULL,
commission float 
);
INSERT INTO salesman(Name,city,commission)
VALUES('James Hoog','New York ',0.15),('Nail Knite','Paris ',0.13),('Pit Alex','London',0.11),('Mc Lyon','Paris',0.14),('Paul Adam','Rome',0.13),('Lauson Hen','San Jose ',0.12)
SELECT * FROM salesman
SELECT Name, commission
FROM salesman;






create table orders(
ord_no bigint primary key identity(70001,1),
purch_amt float not null,
ord_date date not null,
customer_id  int not null,
salesman_Id bigint foreign key references salesman(salesman_id)
);
select ord_no, purch_amt,salesman_Id,ord_date from orders
 select Name,city from salesman where city = 'paris';
 select ord_no, purch_amt,salesman_Id,ord_date from orders where salesman_Id = '5001'
insert into orders(purch_amt,ord_date,customer_id,salesman_Id)
values
(270.65,'2012-10-05',3005, 5002),
	  (270.65,'2012-09-10',3001, 5005),	  (65.25,'2012-10-05',3002, 5001),
	  (110.5,'2012-10-10',3004, 5006),
	  (2480.4,'2012-10-10',3009, 5003),
	  (250.45,'2012-06-27',3008, 5002),
	  (75.29,'2012-08-17',3003, 5004),
	  (3045.5,'2012-04-25',3002, 5001);






create table customers(
customers_ID bigint primary key identity(70001,1),
cout_name nvarchar(100) not null,
city nvarchar(70)NOT NULL,
grade int not null,
salesman_Id bigint foreign key references salesman(salesman_id)
);
insert into customers(cout_name,city,grade,salesman_Id)
values('Nick Rimando','New York',100,5001),
('Brad Davis','New York',200,5001),
('Graham Zusi','California',200,5002),
('Nick Rimando','London',300,5002),
('Fabian Johnson','Paris',300,5006),
('Geoff Cameron','Berlin',100,5003),
('Jozy Altidor','Moscow',200,5004),
('Brad Guzan','London',0,5005)
select cout_name,city,grade,salesman_Id from customers where grade = '200'



create table nobel_win(
YEARSUBJECT nvarchar(100),
WINNER nvarchar(100),
COUNTRY nvarchar(100),
CATEGORY nvarchar(100)
)
insert into nobel_win(
YEARSUBJECT,WINNER,COUNTRY,CATEGORY
) values('1970 Physics','Hannas Alfvan','Sweden','Scientist'),
('1970 Physics', 'Louis','France','Scientist'),
('1970 Chemistry','Luis Federico Leloir','France','Scientist'),
('1970 Physiology','Ulf von Euler','Sweden','Scientist'),
('1970 Physiology','Bernard Katz','Germany' , 'Scientist'),
('1970 Litrature','Aleksande Solzhenitsyn','Russia','Linuist'),
('1970 Economics','Paul Samuelson','USA','Economist'),
('1970 Physiology','Julius Axelrod','USA','Scientist')


--drop table orders
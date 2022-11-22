create database Login
use Login
create table FLog(
 username nvarchar(30) not null,
 password nvarchar(30) not null
)
select * from FLog
insert into FLog(username,password) values('admin','admin')
Select * from Product
create table Product (
P_ID int primary key identity(1,1),
Description nvarchar(max) not null,
Quantity int not null,
Price money not null,
P_Time date Default getdate()
)
alter table Product
add Company nvarchar(1000)
--drop table Product
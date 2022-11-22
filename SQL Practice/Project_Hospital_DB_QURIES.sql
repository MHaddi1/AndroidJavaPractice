Create database Hospital 

use Hospital
--drop table Users
create Table Users(
User_ID INT PRIMARY KEY identity(1,1),
First_name nvarchar(100) not null,
Last_name nvarchar(100) not null,
CNIC bigint not null,
DOB Date not null,
Phone_no bigint not null,
House_no nvarchar(50) not null,
Street_no nvarchar(100) not null,
Block_no nvarchar(100) not null,
Colony_no nvarchar(100) not null,
City nvarchar(100) not null
)
insert into Users(First_name,Last_name,CNIC,DOB,Phone_no,House_no,Street_no,Block_no,Colony_no,City,Email)
values('Muhammad','Haddi',61101231534135,'1990-4-12',03214032421,2,1,'F','Wapda Town','Lahore','haddi@gmail.com'),
('Muhammad','Hassam',611014353363325,'1991-3-13',03214033433,2,1,'D','Wapda Town','Lahore','hassam@gmail.com'),
('Muhammad','Ammar',61101-23153343-2,'1992-1-22',03214022421,6,1,'F','Wapda Town','Lahore','ammar@yahoo.com'),
('Muhammad','Ibraheem',61101231534135,'1990-4-12',03214033244,4,1,'F','Johar Town','Lahore','ibraheem@gmail.com')

select * from Users


--add the alter Email Using Check
Alter table Users
add Email nvarchar(100)

Alter table Users add constraint
chk_email check (Email like '%_@__%.__%')

--Name Concat Function
alter function ConcatN
(
@First_name nvarchar(100),
@Last_name nvarchar(100)
)
returns nvarchar(200)
as
begin return (Select @First_name+' '+@Last_name)
end

--Address Concat Function

Create function Address_concat
(
@House_no nvarchar(50),
@Street_no nvarchar(100),
@Block_no nvarchar(100),
@Colony_no nvarchar(100),
@City nvarchar(100)
)
returns nvarchar(450)
as
begin return (Select @House_no+' '+@Street_no+' '+@Block_no+' '+@Colony_no+' '+@City)
end

--Display the User data Using Procedures
create procedure User_data
as
begin
Select
dbo.ConcatN(First_name,Last_name) as 'Full Name', Email, DOB,CNIC,Phone_no,dbo.Address_concat(House_no,Street_no,Block_no,Colony_no, City) as 'Address'
from Users 
end

exec User_data



--Procedure For Address to Check The Location
Create Procedure Address_Find
@House_no nvarchar(50),
@Street_no nvarchar(100),
@Block_no nvarchar(100),
@Colony_no nvarchar(100),
@City nvarchar(100)
as
Begin 
Select
dbo.ConcatN(First_name,Last_name) as 'Full Name', Email, DOB,CNIC,Phone_no,dbo.Address_concat(House_no,Street_no,Block_no,Colony_no, City) as 'Address'
from Users 
a where   House_no = @House_no and Street_no = @Street_no and Block_no =@Block_no and Colony_no = @Colony_no and City = @City
end



--Syntax To Find The Address Using Procedure
exec Address_Find @House_no = ' ',@Street_no  = ' ', @Block_no = ' ',@Colony_no = ' ', @City = ' ';


-- Sigin Up Page Query

INSERT INTO Users (First_name,Last_name,CNIC,DOB,Phone_no,House_no,Street_no,Block_no,Colony_no,City,Email,D.D_ID,D.U_ID,D.Specialization,D.DOJ) 
SELECT * 
FROM Users 
 JOIN Doctor D ON U_ID = D_ID;



 insert into Doctor(U_ID,Specialization,DOJ)
 values(1,'Child','2015-6-10'),
 (2,'Bonse','2014-6-3'),
 (3,'null','2015-2-5'),
 (4,'Child','2010-6-10'),
 (5,'Brain','2016-3-12'),
 (7,'Blood Cancer','2015-2-3'),
 (8,'Cancer','2015-3-23')




--drop table Doctor
Create Table Doctor(
D_ID INT PRIMARY KEY identity(1,1),
U_ID INT FOREIGN KEY REFERENCES Users(User_ID) not null,
Specialization nvarchar(100) not null,
DOJ DATE not null
)

	select 
--drop table Patients
Create Table Patients(
paitiens_ID INT Primary key identity(1,1),
U_P_ID int foreign key references Users(User_ID) NOT NULL,
Fist_vist Date not null,
Next_vist Date not null,
Last_vaist Date not null,
Discount float not null
)
insert into Patients(U_P_ID,Fist_vist,Next_vist,Last_vaist,Discount)
Values(1,'2022-4-3','2022-4-10','2022-4-3',25.0)
--drop table Appointments 
create table Appointments(
A_ID int primary key identity(1,1) ,
doc_ID int foreign key references Doctor (D_ID) not null,
A_DATE DATE not null
)
insert into Appointments(doc_ID,A_DATE) values(1,'2022-4-3')
-- check appointment of a specific doctor
 
	SELECT A_DATE, A_ID
	from Appointments
	join Doctor
	on
	A_ID = D_ID
	order by
	(CASE when doc_ID is not null then 'doctor is Avaliable'

	 when doc_ID is null then ' The Doctor is not Avaliable'
	else doc_ID
	end );

	
	

 --drop table Diagnose
 Create table Diagnose(
 Diagnose_ID int primary key identity(1,1),
 Pat_ID int foreign key references Patients(paitiens_ID) not null,
 Doc_ID int foreign key references Doctor(D_ID) not null,
 Disease nvarchar(100) not null,
 vist_date date not null,
 Description nvarchar(MAX) not null,
 Status nvarchar(10) not null
 )
 insert into Diagnose(Pat_ID,Doc_ID,vist_date,Disease,Description,Status)
 values(1,1,'2022-4-3','This Is Blood Cancer','This is Description','T')

 --
--add appointment for a doctor (Check time conflict)
create procedure add_appointments
@vist_date date , 
@Doc_ID nvarchar(100)
as
begin
if (@vist_date = getdate() and @Doc_ID = 'T')
insert into Diagnose (pat_ID, Doc_ID, Disease, vist_date,Description,Status)
values(1,1,'','','','')
select Diagnose_ID,pat_ID, Doc_ID, Disease, vist_date, Description, Status, D_ID from Diagnose join
Doctor 
on
D_ID = Diagnose_ID
where vist_date = getdate() and Doc_ID is not null

end
exec add_appointments @vist_date =' ', @Doc_ID =' '














-- drop table Billing
 Create table Billing(
 B_ID int primary key identity(1,1),
 Pat_ID int foreign key references Patients(paitiens_ID) not null,
 Payment_Method nvarchar(100) not null,
 Payment_amount Money not null,
 Payment_Date date not null
 )
 insert into Billing(Pat_ID,Payment_Method,Payment_amount,Payment_Date)
 values(1,'Cradit Card',20000,'2022-4-3')


 --get bill details with patient id
 select * from Billing
 join Patients
 on 
 B_ID = paitiens_ID 
 where paitiens_ID = 1


 --drop table Precription
 Create table Precription(
 Prescription_ID int primary key identity(1,1),
 Dia_ID int foreign key references Diagnose(Diagnose_ID) not null,
 Bill_ID int foreign key references Billing(B_ID) not null,
 Detail nvarchar(100) not null
 )
 insert into Precription(Dia_ID,Bill_ID,Detail)
 Values(1,1,'This Database created by Group')
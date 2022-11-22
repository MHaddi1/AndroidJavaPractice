alter trigger S
on employee
for insert 
as 
begin

select * from employee
print 'Dispaly the Value after after insertation'
end
insert into employee(empfname,emplname,gender,city,salary,did,mid,dob,joining_date)
values('Muhammad','Haddi','male','Lahore','156353',2,2,'1999-10-12','2017-10-12')



alter trigger deleteT
on employee
for delete 
as
begin
delete from project where pid = 4
print 'Delete The Row'
end

delete from employee where eid = 4


alter trigger insertation
on employee

for insert
as
begin
insert into project(PTitle,starting_date,Deadline,status)
values('Learn Onlie','2017-09-10',' 2022-09-10','In Progress')
select * from project
print 'Insert The Data'
end

insert into employee(empfname,emplname,gender,city,salary,did,mid,dob,joining_date)
values('Muhammad','Hassan','male','Lahore','1526333',2,2,'1997-10-12','2017-10-12')



alter trigger inserta
on employee
for Update
as
begin
Update employee set joining_date = '2016-3-4' from employee where eid = 7
select * from employee
print 'set Date '
end

Update employee set joining_date = '2013-12-12' from employee where eid = 7 
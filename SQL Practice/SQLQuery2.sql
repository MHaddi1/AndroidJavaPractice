USE University;
SELECT * FROM U_Student_Data;

INSERT INTO U_Student_Data(U_Student_name,U_S_Father_name,S_Address)


VALUES  ('Muhammad Hassm','Muhammad Kaleem Ullah','H# 43 St#1 Larex Colony Shahdara, Lahore');
SELECT U_Student_name from U_Student_Data where id = 2

UPDATE U_Student_Data SET U_Student_name = 'Muhammad Ibrahim' WHERE Id = 1;
DELETE FROM U_Student_Data WHERE Id = 0;
TRUNCATE TABLE U_Student_Data 



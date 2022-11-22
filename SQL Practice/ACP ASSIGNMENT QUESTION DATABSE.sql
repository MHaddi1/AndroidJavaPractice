CREATE DATABASE BOOKS

USE BOOKS

	CREATE TABLE Author(
	Author_ID int PRIMARY KEY IDENTITY(1,1),
	Author_F_name nvarchar(100) not null,
	Author_L_name nvarchar(100) not null,
	)

	CREATE TABLE Title(
	Isbn bigint Primary key identity(231412212,1),
	title nvarchar(100) not null,
	Edition_no NVARCHAR(100) NOT NULL,
	COPY_RIGHT NVARCHAR(100) NOT NULL
	)




	CREATE TABLE Books(
	A_ID int FOREIGN key REFERENCES Author(Author_ID),
	ISBN BIGINT FOREIGN key REFERENCES Title(Isbn)
	)

	INSERT INTO Author(Author_F_name,Author_L_name)
	VALUES('Hunter','Biden'),
	('Meghna','Pant'),
	('Ramesh','Kandula')

	SELECT * FROM Author

	SELECT Author_F_name FROM Author WHERE Author_ID = 2

	SELECT Author_F_name,Author_L_name FROM Author 
	WHERE Author_ID > 2
  SELECT * FROM Author,Title

	INSERT INTO Title(title,Edition_no,COPY_RIGHT)
	VALUES('Beautiful Things’ A Memoir','2','2022'),
	('The Terrible, Horrible, Very Bad Good News','1','2021'),
	('Maverick Messiah: A Political Biography of N T Rama Rao','4','2019')
	DROP TABLE Title
	Select * from Title
	SELECT Edition_no FROM Title WHERE Isbn = 231412212
	SELECT title, Edition_no, COPY_RIGHT
    FROM Title WHERE COPY_RIGHT > '2020'



	INSERT INTO Books(A_ID,ISBN)
	VALUES(1,231412212),
	(2,231412213),
	(2,231412214)

	Select * from Books
	DROP TABLE Books

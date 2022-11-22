CREATE TABLE Artist(
Artist_Id int PRIMARY KEY IDENTITY(1,1),
Artist_name nvarchar(100)
);
CREATE TABLE Albums(
Albums_Id int PRIMARY KEY IDENTITY(1,1),
Albums_name nvarchar(100)not null,
Ar_Id int foreign key references Artist(Artist_Id) 
);
CREATE TABLE Track(
Track_Id int PRIMARY KEY IDENTITY(1,1),
Track_name nvarchar(100) not null,
Date_and_Time datetime default getdate() not null,
Alb_Id int foreign key references Albums(Albums_Id) unique not null
);
CREATE TABLE PlayBack(
PlayBack_Id int PRIMARY KEY,
Trac_Id int foreign key references Track(Track_Id)
);

Select * FROM Track,Albums,Artist,PlayBack;
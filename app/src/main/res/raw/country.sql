create table fa.tCountry
(
	Id int identity(0,1),
	Name nvarchar(64) not null,
	Scores nvarchar(64) not null,
	CountryCompetitions nvarchar(64) not null, 

	constraint PK_tCountry primary key(Id),
	constraint UK_tCountry unique (Name)
	);


create table fa.tCountry
(
	CountryId int identity(0,1),
	CountryName nvarchar not null,
	Scores nvarchar not null,
	CountryCompetitions nvarchar not null, 

	constraint PK_tCountry primary key(CountryId),
	constraint UK_tCountry UNIQUE key(Name)
	);


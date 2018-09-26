create table fa.tLeague
(
	LeagueId int identity(0,1),
	Name nvarchar not null,
	CountryId int,
	LeagueScores nvarchar not null, 

	constraint PK_tLeague primary key(LeagurId),
	constraint UK_tLeague UNIQUE key(Name),
	constraint FK_tLeague foreign key(CountryId) references fa.tCountry(CountryId)
	);
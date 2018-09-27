create table fa.tMatch
(
	MatchId int identity(0,1);
	Score nvarchar not null,
	StartDate text,
	EndDate text, 
	HomeTeam nvarchar not null,
	AwayTeam nvarchar not null,
	LeagueId int,
	CountryId int,

	constraint PK_tMatch primary key(MatchId)
	constraint FK_tMatchCountryId foreign key(CountryId) references fa.tCountry(CountryId),
	constraint FK_tMatchLeagueId foreign key(LeagueId) references fa.tLeague(LeagueId) 
);
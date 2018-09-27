create proc fa.sMatchCreate
(
	@MatchId int;
	@Score nvarchar,
	@StartDate text,
	@EndDate text, 
	@HomeTeam nvarchar,
	@AwayTeam nvarchar,
	@LeagueId int,
	@CountryId int
)
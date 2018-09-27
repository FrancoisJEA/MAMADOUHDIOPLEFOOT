create proc fa.sLeagueCreate
	(
		@LeagueId int,
		@Name nvarchar,
		@CountryId,
		@LeagueScore nvarchar	
	)
	as
	begin
			set transaction isolation level serialization;
			begin tran;

			if exist(select * from af.tLeague l where l.Name =@Name and l.CountryId=@CountryId)
			begin
					rollback;
					return 1;
			end

			insert into fa.tLeague(Name,CountryId,LeagueScore) values(@Name,@CountryId,@LeagueScore)
				set @LeagueId = scope_identity();
	end;
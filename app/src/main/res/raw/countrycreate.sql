create proc fa.sCountryCreate
(
	@CountryId int,
	@CountryName nvarchar,
	@Scores nvarchar,
	@CountryCompetition nvarchar
)
as 
begin
      set transaction isolation level serializable
      begin tran;

      if exists(select * from fa.tCountry c where c.CountryId = @CountryId)
      begin
             rollback;
             return 1;
      end
      insert into fa.tCountry(CountryName,CountryCompetition,Scores) values(@CountryName,@CountryCompetition,@Scores)
      	set @GameId = scope_identity();
      commit;
 end;
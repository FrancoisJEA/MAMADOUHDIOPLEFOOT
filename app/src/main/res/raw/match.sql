create table match
(
	match_id integer PRIMARY KEY,
	score text NOT NULL,
	start_date text NOT NULL,
	end_date text NOT NULL, 
	home_team text NOT NULL,
	away_team text NOT NULL,
	league_id integer,
    country_id integer,

	FOREIGN KEY(country_id) REFERENCES country(country_id),
	FOREIGN KEY(league_id) REFERENCES league(league_id)  
);
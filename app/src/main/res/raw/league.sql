CREATE TABLE league
(
	league_id integer PRIMARY KEY,
	league_name text NOT NULL,
	country_id integer,
	league_scores_live text NOT NULL,
	league_scores_old text NOT NULL,

	FOREIGN KEY(country_id) REFERENCES country(country_id) 
	);
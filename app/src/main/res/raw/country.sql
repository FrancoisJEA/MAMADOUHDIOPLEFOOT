CREATE TABLE country
(
	country_id integer PRIMARY KEY,
	country_name text NOT NULL,
	country_scores_live text NOT NULL UNIQUES,
    country_scores_old text NOT NULL UNIQUES,
	country_leagues text NOT NULL UNIQUE 
);


package com.footaddict.superstars.footaddict;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

public class BDDInserter
{
    private ContentValues countryContentValue(Country country)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("country_id",country.getId());
        contentValues.put("country_name",country.getName());
        contentValues.put("country_scores_live",country.getLiveScores());
        contentValues.put("country_scores_old",country.getOldScores());
        contentValues.put("country_leagues",country.getCountryLeagues());
        return  contentValues;
    }

    public void insertCountry(Country country)
    {
        BDDOpenHelper con = new BDDOpenHelper(country.getContext());
        SQLiteDatabase db = con.getWritableDatabase();
        try
        {
            db = con.getWritableDatabase();
            db.insert("country",null,countryContentValue(country));
            db.close();
        }
        catch (SQLiteException e)
        {
            System.out.println("Sqlite Error");
        }
    }

    private ContentValues leagueContentValue(League league)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("league_id",league.getId());
        contentValues.put("league_name",league.getName());
        contentValues.put("country_id",league.getCountry_id());
        contentValues.put("league_scores_live",league.get_Live_Scores());
        contentValues.put("league_scores_old",league.get_Old_Scores());
        return  contentValues;
    }

    public void insertLeague(League league)
    {
        BDDOpenHelper con = new BDDOpenHelper(null);
        SQLiteDatabase db = con.getWritableDatabase();
        try
        {
            db = con.getWritableDatabase();
            db.insert("league",null,leagueContentValue(league));
            db.close();
        }
        catch (SQLiteException e)
        {
            System.out.println("Sqlite Error");
        }
    }

    private ContentValues matchContentValue(Match match)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("match_id",match.getMatch_id());
        contentValues.put("score",match.getScore());
        contentValues.put("start_date",match.getStartDate().toString());
        contentValues.put("end_date",match.getEndDate().toString());
        contentValues.put("home_team",match.getHome_team());
        contentValues.put("away_team",match.getHome_team());
        contentValues.put("league_id",match.getLeague_id());
        contentValues.put("country_id",match.getCountry_id());
        return  contentValues;
    }

    public void insertMatch(Match match)
    {
        BDDOpenHelper con = new BDDOpenHelper(match.getContext());
        SQLiteDatabase db = con.getWritableDatabase();
        try
        {
            db = con.getWritableDatabase();
            db.insert("match",null,matchContentValue(match));
            db.close();
        }
        catch (SQLiteException e)
        {
            System.out.println("Sqlite Error");
        }
    }


}

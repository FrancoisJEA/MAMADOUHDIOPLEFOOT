package com.footaddict.superstars.footaddict;

import android.content.Context;

import java.util.Date;

public class Match
{
    private int match_id;
    private Date startDate;
    private Date endDate;
    private String score;
    private String home_team;
    private String away_team;
    private int league_id;
    private int country_id;
    private Context context;
    private boolean isLive = false;

    public Match(Context context,int match_id,Date startDate, Date endDate,String score,String home_team_name,String away_team_name,int league_id,int country_id)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        this.context = context;
        this.match_id = match_id;
        this.score = score;
        this.home_team = home_team_name;
        this.away_team = away_team_name;
        this.league_id = league_id;
        this.country_id = country_id;
        if (this.endDate.before(new Date()))
        {
            isLive = true;
        }
    }
    public Context getContext(){return context;}

    public int getMatch_id(){return match_id;}
    public void setMatch_id(int id){this.match_id = id;}

    public Date getStartDate(){ return  this.startDate;}
    public void setStartDate(Date startDate){this.startDate = startDate;}

    public Date getEndDate(){ return  this.endDate;}
    public void setEndDate(Date endDate){this.endDate = endDate;}

    public  String getScore(){return  this.score;}
    public void setScore(String score){this.score = score;}

    public  String getHome_team(){return home_team;}
    public  String getAway_team(){return away_team;}
    public  int getLeague_id(){return  league_id;}
    public  int getCountry_id(){return  country_id;}
}

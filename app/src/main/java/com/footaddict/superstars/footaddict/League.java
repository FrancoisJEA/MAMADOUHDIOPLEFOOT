package com.footaddict.superstars.footaddict;

import android.content.Context;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class League
{
    private int id;
    private String live_scores;
    private String old_scores;
    private int country_id;
    private String name;
    private Context context;

    public int getId ()
    {
        return id;
    }
    public void setId (int id)
    {
        this.id = id;
    }

    public String get_Old_Scores ()
    {
        return old_scores;
    }
    public void set_Old_Scores (String scores)
    {
        this.old_scores = scores;
    }

    public String get_Live_Scores ()
    {
        return live_scores;
    }
    public void set_Live_Scores (String scores)
    {
        this.live_scores = scores;
    }

    public int getCountry_id ()
    {
        return country_id;
    }
    public void setCountry_id (int country_id)
    {
        this.country_id = country_id;
    }

    public String getName ()
    {
        return name;
    }
    public void setName (String name)
    {
        this.name = name;
    }

    public Context getContext(){return context;}

    public League(Context context,int id,String name,String old_score,String live_scores, int country_id)
    {
        this.context = context; this.id = id; this.name = name;
        this.old_scores = old_score; this.live_scores = live_scores;this.country_id=country_id;
    }

    @Override
    public String toString()
    {
        return "[id = "+id+", old_scores = "+old_scores+", country_id = "+country_id+", name = "+name+"]";
    }
}
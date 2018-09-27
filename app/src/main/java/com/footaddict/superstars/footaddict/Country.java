package com.footaddict.superstars.footaddict;

import android.content.Context;

public class Country
{
    private int countryId;
    private String name;
    private String scores;
    private boolean is_real;
    private String countrycompetitions;

    public int getId() {return this.countryId;}
    public void setId(int id) { this.countryId = id;}

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name;}

    public boolean getIs_real() { return this.is_real; }
    public void setIs_real(boolean is_real) { this.is_real = is_real; }

    public String getCountryCompetitions() { return this.countrycompetitions;}
    public void setLeagues(String leagues) { this.countrycompetitions = leagues;}

    public String getScores() { return this.scores; }
    public void setScores(String scores) { this.scores = scores; }

    public Country(Context context,int id, String name, String countrycompetitions)
    {
        this.countryId = id;
        this.name = name;
        this.countrycompetitions = countrycompetitions;

    }

    public void InsertCountry()
    {

    }
}




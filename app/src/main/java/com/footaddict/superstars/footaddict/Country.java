package com.footaddict.superstars.footaddict;

import java.util.ArrayList;
import java.util.List;

public class Country
{
    private int id;
    private String name;
    private String scores;
    private boolean is_real;
    private String countrycompetitions;

    public int getId() {return this.id;}
    public void setId(int id) { this.id = id;}

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name;}

    public boolean getIs_real() { return this.is_real; }
    public void setIs_real(boolean is_real) { this.is_real = is_real; }

    public String getCountryCompetitions() { return this.countrycompetitions;}
    public void setLeagues(String leagues) { this.countrycompetitions = leagues;}

    public String getScores() { return this.scores; }
    public void setScores(String scores) { this.scores = scores; }

    public Country(int id,String name,String countrycompetitions)
    {
        this.id = id;
        this.name = name;
        this.countrycompetitions = countrycompetitions;
}

}




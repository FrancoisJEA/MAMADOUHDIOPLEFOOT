package com.footaddict.superstars.footaddict;

public class ListCountry {
    private Country[] country;

    public Country[] getCountry ()
    {
        return country;
    }

    public void setCountry (Country[] country)
    {
        this.country = country;
    }

    @Override
    public String toString()
    {
        return "[country = "+country+"]";
    }
}
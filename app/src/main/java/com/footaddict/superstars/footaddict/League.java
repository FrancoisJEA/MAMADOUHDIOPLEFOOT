package com.footaddict.superstars.footaddict;

import com.fasterxml.jackson.annotation.JsonProperty;

public class League {
    private String id;

    private String scores;

    private String country_id;

    private String name;

    @JsonProperty("id")
    public String getId ()
    {
        return id;
    }

    public void setId (String id)
    {
        this.id = id;
    }

    @JsonProperty("scores")
    public String getScores ()
    {
        return scores;
    }

    public void setScores (String scores)
    {
        this.scores = scores;
    }

    @JsonProperty("country_id")
    public String getCountry_id ()
    {
        return country_id;
    }

    public void setCountry_id (String country_id)
    {
        this.country_id = country_id;
    }

    @JsonProperty("name")
    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "[id = "+id+", scores = "+scores+", country_id = "+country_id+", name = "+name+"]";
    }
}
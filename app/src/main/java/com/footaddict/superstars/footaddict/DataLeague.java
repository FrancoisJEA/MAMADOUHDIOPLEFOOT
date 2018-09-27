package com.footaddict.superstars.footaddict;

import android.provider.ContactsContract;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataLeague {

    private LeagueInfos data;
    private String success;

    public LeagueInfos getData ()
    {
        return data;
    }

    public void setData (LeagueInfos data)
    {
        this.data = data;
    }

    public String getSuccess ()
    {
        return success;
    }

    public void setSuccess (String success)
    {
        this.success = success;
    }

}

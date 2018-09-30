package com.footaddict.superstars.footaddict;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DataLive {

    private LiveInfos data;
    private String success;

    public LiveInfos getData ()
    {
        return data;
    }

    public void setData (LiveInfos data)
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

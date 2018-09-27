package com.footaddict.superstars.footaddict;

public class ListLiveMatch {
    private LiveMatch[] match;

    public LiveMatch[] getMatch ()
    {
        return match;
    }

    public void setMatch (LiveMatch[] match)
    {
        this.match = match;
    }

    @Override
    public String toString()
    {
        return "[match = "+match+"]";
    }
}

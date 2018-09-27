package com.footaddict.superstars.footaddict;

import java.util.Date;

public class PasteMatch
{
    private Date startDate;
    private Date endDate;
    private String score;
    private boolean isLive = false;

    public PasteMatch(Date startDate,Date endDate)
    {
        this.startDate = startDate;
        this.endDate = endDate;
        if (this.endDate.before(new Date()))
        {
            isLive = true;
        }
    }

    public Date getStartDate(){ return  this.startDate;}
    public void setStartDate(Date startDate){this.startDate = startDate;}

    public Date getEndDate(){ return  this.endDate;}
    public void setEndDate(Date endDate){this.endDate = endDate;}

    public  String getScore(){return  this.score;}
    public void setScore(String score){this.score = score;}
}

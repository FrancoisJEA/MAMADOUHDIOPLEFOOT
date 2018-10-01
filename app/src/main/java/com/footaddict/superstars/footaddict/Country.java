package com.footaddict.superstars.footaddict;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.facebook.stetho.inspector.protocol.module.Database;

import java.sql.Connection;

public class Country
{
    private int countryId;
    private String name;
    private String scoreslive;
    private String scoresold;
    private boolean is_real;
    private String countryleagues;
    private Context context;

    public int getId() {return this.countryId;}
    public void setId(int id) { this.countryId = id;}

    public String getName() { return this.name; }
    public void setName(String name) { this.name = name;}

    public boolean getIs_real() { return this.is_real; }
    public void setIs_real(boolean is_real) { this.is_real = is_real; }

    public String getCountryLeagues() { return this.countryleagues;}
    public void setLeagues(String leagues) { this.countryleagues = leagues;}

    public String getLiveScores() { return this.scoreslive; }
    public void setLiveScores(String livescores) { this.scoreslive = livescores; }

    public String getOldScores() { return this.scoresold; }
    public void setOldScores(String oldscores) { this.scoresold = oldscores; }

    public Country(Context context,int id, String name, String countryleagues,String livescores,String oldscores)
    {
        this.countryId = id;
        this.name = name;
        this.countryleagues = countryleagues;
        this.scoreslive = livescores;
        this.scoresold = oldscores;
        this.context = context;
    }

    private ContentValues countryContentValue(int id, String countryname, String livescores, String oldscores, String countryleague)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("ID",id);
        contentValues.put("CountryName",countryId);
        contentValues.put("LivesScores",livescores);
        contentValues.put("Oldscores",oldscores);
        contentValues.put("CountryId",countryleague);
        return  contentValues;
    }

    public void insertCountry()
    {
        SQLiteDatabase db = null;
        MyOpenHelper con = new MyOpenHelper(context);

        try
        {
            db = con.getWritableDatabase();
            db.beginTransaction();
            db.insert("country",null,countryContentValue(this.countryId,this.name,this.scoreslive,this.scoresold,this.countryleagues));
        }
        catch (SQLiteException e)
        {
            System.out.println("Sqlite Error");
        }
    }

}




package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class ListCountry {
    private List<Country> country = new ArrayList<>();

    public List<Country> getCountrys (Context context)
    {
        BDDOpenHelper con = new BDDOpenHelper(context);
        SQLiteDatabase db = con.getReadableDatabase();
        try
        {
            int i = 0;
            String query ="SELECT * FROM country";
            Cursor c = db.rawQuery(query,null);
            while(c.moveToNext()==!false)
            {
                i = i+1;
                int id = c.getInt(0);
                String name = c.getString(1);
                String score_live = c.getString(2);
                String score_old = c.getString(3);
                String league = c.getString(4);
                Country country = new Country(context,id,name,league,score_live,score_old);
                this.country.add(country);
            }
        }
        catch (SQLException e)
        {
            System.out.println("Sqlite ERROR");
        }
        db.close();
        return  this.country;
    }

    @Override
    public String toString()
    {
        return "[country = "+country+"]";
    }
}
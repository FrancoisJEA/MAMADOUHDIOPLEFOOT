package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDDOpenHelper extends SQLiteOpenHelper
{
    Context context;

    public BDDOpenHelper(Context context)
    {
        super(context,"FootballAddict",null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        context.getResources().openRawResource(R.raw.sql);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
            //Create new tables
            //Alter tables
    }
}


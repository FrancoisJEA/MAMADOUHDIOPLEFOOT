package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import org.apache.commons.io.IOUtils;

import java.io.IOException;

public class BDDOpenHelper extends SQLiteOpenHelper
{
    Context context;

    public BDDOpenHelper(Context context)
    {
        super(context,"FootballAddict122",null,1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        try {
            String result = IOUtils.toString(this.context.getResources().openRawResource(R.raw.country), "UTF-8");
            db.execSQL(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String result = IOUtils.toString(this.context.getResources().openRawResource(R.raw.league), "UTF-8");
            db.execSQL(result);

        }
        catch (IOException e) {
            e.printStackTrace();
        }
        try {
            String result = IOUtils.toString(this.context.getResources().openRawResource(R.raw.match), "UTF-8");
            db.execSQL(result);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
            //Create new tables
            //Alter tables
    }
}


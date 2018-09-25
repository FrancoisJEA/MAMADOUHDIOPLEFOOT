package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyOpenHelper extends SQLiteOpenHelper {

    public MyOpenHelper(Context context) {
        super(context,"mabase",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Create tables
        db.execSQL("CREATE TABLE " + "footAddict" + " (" +
                "nom" + " TEXT PRIMARY KEY, " +
                "prenom" + " TEXT NOT NULL"+")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Create new tables
        //Alter tables
    }
}
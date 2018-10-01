package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.style.TabStopSpan;

import com.fasterxml.jackson.databind.util.ISO8601DateFormat;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.Array;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

import okio.Utf8;

public class MyOpenHelper extends SQLiteOpenHelper {
    Context context;

    public MyOpenHelper(Context context) {
        super(context,"footaddict103",null,1);
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
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Create new tables
        //Alter tables
    }
}
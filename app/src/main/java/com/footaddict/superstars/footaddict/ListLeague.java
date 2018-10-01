package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

    public class ListLeague
    {
        private List<League> league = new ArrayList<>();

        public ListLeague()
        {

        }

        public List<League> getList(Context context) {
            BDDOpenHelper con = new BDDOpenHelper(context);
            SQLiteDatabase db = con.getReadableDatabase();
            try {
                int i = 0;
                String query = "SELECT * FROM league";
                Cursor c = db.rawQuery(query, null);
                while (c.moveToNext() == !false) {
                    i = i + 1;
                    int id = c.getInt(0);
                    String name = c.getString(1);
                    String score_live = c.getString(3);
                    String score_old = c.getString(4);
                    int country_id = c.getInt(2);
                    League league = new League(id, name, score_old, score_live, country_id);
                    this.league.add(league);
                }
            } catch (SQLException e) {
                System.out.println("Sqlite ERROR");
            }
            db.close();
            return this.league;
        }
    }

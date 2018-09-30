package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class LiveAdapter extends BaseAdapter{

    private Context context;
    private List<Live> lives;

    public LiveAdapter(Context context, List<Live> live){
        this.context = context;
        this.lives = live;
    }

    @Override
    public int getCount() {
        return lives.size();
    }

    @Override
    public Object getItem(int position) {
        return lives.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.live_item, parent, false);
        }

        // get current item to be displayed
        Live currentLive = (Live) getItem(position);
        String homeName = currentLive.getHome_name();
        String awayName = currentLive.getAway_name();
        String score = currentLive.getScore();

        // get the TextView for item name and item description
        ((TextView) convertView.findViewById(R.id.home_name)).setText(homeName);
        ((TextView) convertView.findViewById(R.id.score)).setText(score);
        ((TextView) convertView.findViewById(R.id.away_name)).setText(awayName);

        // returns the view for the current row
        return convertView;
    }
}

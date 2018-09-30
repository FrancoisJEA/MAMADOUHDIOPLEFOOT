package com.footaddict.superstars.footaddict;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


public class LeagueAdapter extends BaseAdapter {

    private Context context;
    private List<League> leagues;

    public LeagueAdapter(Context context, List<League> listLeague) {
        this.context = context;
        this.leagues = listLeague;
    }

    @Override
    public int getCount() {
        return leagues.size();
    }

    @Override
    public Object getItem(int position) {
        return leagues.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.league_item, parent, false);
        }

        // get current item to be displayed
        League currentLeague = (League) getItem(position);
        String leagueName = currentLeague.getName();

        // get the TextView for item name
        TextView textViewItemName = convertView.findViewById(R.id.titre_item);
        textViewItemName.setText(leagueName);

        ((TextView) convertView.findViewById(R.id.sous_titre_item)).setText(currentLeague.getCountry_id());

        // returns the view for the current row
        return convertView;
    }
}

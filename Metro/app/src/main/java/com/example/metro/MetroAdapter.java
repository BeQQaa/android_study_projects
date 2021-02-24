package com.example.metro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class MetroAdapter extends ArrayAdapter<String> {

    private List<Station> stations;

    public MetroAdapter(@NonNull Context context, int resource, List<Station> stations) {
        super(context, resource);
        this.stations = stations;
    }

    @Override
    public int getCount() {
        return stations.size();
    }

    @SuppressLint("ViewHolder")
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        convertView = inflater.inflate(R.layout.item, parent, false);
//        String station = stations.get(position);
        String station = stations.get(position).name;
        String color = stations.get(position).color;
        TextView stationTextView = convertView.findViewById(R.id.station);
        stationTextView.setText(station);
        stationTextView.setBackgroundColor(Color.parseColor(color));
        return convertView;
    }
}

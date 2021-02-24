package com.example.metro;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private final List<String> stationsText= new ArrayList<>();
    private final List <String> colors = new ArrayList<>();
    private List<Station> stations= new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.list);
        initColors(colors);
        initList(stationsText);
        initStations(stations);

        MetroAdapter adapter = new MetroAdapter(this, R.layout.item, stations);
        listView.setAdapter(adapter);

    }

    private void initStations(List<Station> stations) {
        for (int i = 0; i < (Math.min(colors.size(), stationsText.size())); i++) {
            stations.add(new Station(stationsText.get(i), colors.get(i)));
        }
    }

    private void initColors(List<String> colors) {
        colors.add("#111111");
        colors.add("#111111");
        colors.add("#222222");
        colors.add("#222222");
        colors.add("#333333");
        colors.add("#333333");
        colors.add("#444444");
        colors.add("#444444");
        colors.add("#555555");
        colors.add("#666666");
        colors.add("#666666");
        colors.add("#666666");
        colors.add("#777777");
        colors.add("#888888");
    }

    private void initList(List<String> stations) {
        stations.add("Пролетарская");
        stations.add("Китай-город");
        stations.add("Кузнецкий мост");
        stations.add("Киевская");
        stations.add("Таганская");
        stations.add("Студенческая");
        stations.add("Римская");
        stations.add("Комсомольская");
        stations.add("Рижская");
        stations.add("Рижская");
        stations.add("Рижская");
        stations.add("Рижская");
        stations.add("Рижская");
        stations.add("Рижская");
    }
}
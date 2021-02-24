package com.example.beeradviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindBeerActivity extends Activity {
    private BeerExpert beerExpert = new BeerExpert();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_beer);
    }

    public void onClickFindBeer(View view) {
        TextView brands = (TextView) findViewById(R.id.brands);
        Spinner beerColor = (Spinner) findViewById(R.id.color);
        String beerType = String.valueOf(beerColor.getSelectedItem());
        List<String> stringList = beerExpert.getBrands(beerType); 

        StringBuilder stringBuilder = new StringBuilder();

        for (String brand : stringList) {
            stringBuilder.append(brand).append("\n");
        }
        brands.setText(stringBuilder);
    }
}

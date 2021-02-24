package com.example.menu;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class NavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigation;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);

        navigation = findViewById(R.id.navigation);
        textView = findViewById(R.id.nav_text_view);

        navigation.setOnNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.bottom_nav_first){
            textView.setText(R.string.first_text);

        }else if (item.getItemId() == R.id.bottom_nav_second){
            textView.setText(R.string.second_text);

        }else if (item.getItemId() == R.id.bottom_nav_third) {
            textView.setText(R.string.third_text);
        }
        return false;
    }
}
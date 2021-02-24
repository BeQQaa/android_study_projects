package com.example.tours;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class FirstTourExampleActivity extends AppCompatActivity {

    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_tour_example);

        view = findViewById(R.id.coordinator);
    }

    public void OnGetTourClick(View view) {
//        Toast.makeText(this, "Your order is processing", Toast.LENGTH_LONG).show();
        Snackbar.make(view, "Your order is processing", Snackbar.LENGTH_SHORT).show();
    }
}
package com.example.tours;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.buttonGoTo);

        button.setOnClickListener(this::GoToIntentTest);
    }

    public void GoToIntentTest(View view) {
        Intent intent = new Intent(this, FirstTourExampleActivity.class);
        startActivity(intent);
    }
}
package com.example.trafficlights;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    private boolean isClicked = false;
    private LinearLayout red;
    private LinearLayout yellow;
    private LinearLayout green;
    private Button start_stop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        red = findViewById(R.id.red_signal);
        yellow = findViewById(R.id.yellow_signal);
        green = findViewById(R.id.greem_signal);
        start_stop = findViewById(R.id.start_stop_butt);

    }

    public void onClickStartStopButt(View view) {
        if (!isClicked) {
            isClicked = true;
            start_stop.setText(R.string.stop_on_click);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (isClicked) {
                        try {
                            red.setBackgroundColor(Color.RED);
                            Thread.sleep(3000);

                            red.setBackgroundColor(Color.GRAY);
                            yellow.setBackgroundColor(Color.YELLOW);
                            Thread.sleep(3000);

                            yellow.setBackgroundColor(Color.GRAY);
                            green.setBackgroundColor(Color.GREEN);
                            Thread.sleep(3000);

                            green.setBackgroundColor(Color.GRAY);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }).start();
        }else {
            isClicked = false;
            start_stop.setText(R.string.start_on_click);
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        isClicked = false;
    }
}
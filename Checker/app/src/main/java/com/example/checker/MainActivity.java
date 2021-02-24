package com.example.checker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    private Button buttonCheck;
    private Button buttonUncheck;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonCheck = findViewById(R.id.buttonCheck);
        buttonUncheck = findViewById(R.id.buttonUnCheck);
        checkBox = findViewById(R.id.check);

        buttonCheck.setOnClickListener(this::OnclickButtonCheck);
        buttonUncheck.setOnClickListener(this::OnclickButtonUncheck);
    }

    public void OnclickButtonCheck(View view) {
        checkBox.setChecked(true);
    }

    public void OnclickButtonUncheck(View view) {
        checkBox.setChecked(false);
    }

//    public void OnclickButtonUncheck(View view) {
//        buttonUncheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkBox.setChecked(false);
//            }
//        });
//    }
//
//    public void OnclickButtonCheck(View view) {
//        buttonCheck.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                checkBox.setChecked(true);
//            }
//        });
//    }
}
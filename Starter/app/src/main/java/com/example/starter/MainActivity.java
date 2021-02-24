package com.example.starter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edit;
    private CheckBox isCheked;
    public static final String HTTPS = "https://";
    public static final String DOMAIN_RU = ".ru";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edit = findViewById(R.id.edit);
        isCheked = findViewById(R.id.check_site);
    }

    public void start(View view) {
        String data = edit.getText().toString();
        Intent intent;
        if (isCheked.isChecked()) {
            data = HTTPS + data + DOMAIN_RU;

            if (!data.equals("")) {
                intent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse(data));
                startActivity(intent);
            }
//            tel:
//            geo:
        }
//        else if (!isCheked.isChecked()) {
//            intent = new Intent(Intent.ACTION_SEARCH,
//                    Uri.parse(data));
//            startActivity(intent);
//        }
    }
}
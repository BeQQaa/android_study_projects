package com.example.lifecycleedit;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.lifecycleedit.Edit.SENDING_INPUT_TEXT_FROM_EDIT;

public class EndActivity extends AppCompatActivity implements View.OnClickListener {

    TextView textView;
    Button button;
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
        textView = findViewById(R.id.textView_end);

        Intent intent = getIntent();
        name = intent.getStringExtra(SENDING_INPUT_TEXT_FROM_EDIT);

        textView.setText(name);

        button = findViewById(R.id.button_end);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent();
        intent.putExtra(SENDING_INPUT_TEXT_FROM_EDIT, name);
        setResult(RESULT_OK, intent);
        onBackPressed();
    }
}
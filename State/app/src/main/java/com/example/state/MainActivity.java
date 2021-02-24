package com.example.state;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String EMPTY_STRING = "";
    private static final String TEXT_FIELD_BUTTON_ANSWER = "Button Pressed: ";
    private static final String ON_SAVE_COUNTER = "com.example.state.press.button.counter";
    private Button button;
    private EditText firstColumn;
    private EditText secondColumn;
    private TextView textColumn;
    private int pressButtonCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            pressButtonCounter = savedInstanceState.getInt(ON_SAVE_COUNTER);
        }

        button = findViewById(R.id.main_button);
        firstColumn = findViewById(R.id.first_column);
        secondColumn = findViewById(R.id.second_column);
        textColumn = findViewById(R.id.text_column);
        textColumn.setText(changeText(pressButtonCounter, TEXT_FIELD_BUTTON_ANSWER));

        button.setOnClickListener(this);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(ON_SAVE_COUNTER, pressButtonCounter);
    }

    @Override
    public void onClick(View v) {

        if (v.getId() == button.getId()){
//this button to do R.id.main_button
            pressButtonCounter++;
            textColumn.setText(changeText(pressButtonCounter, TEXT_FIELD_BUTTON_ANSWER));
        }
    }

    private String changeText(int count, String text){
        return text + count;
    }
}
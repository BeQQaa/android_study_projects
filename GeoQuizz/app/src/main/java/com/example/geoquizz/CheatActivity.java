package com.example.geoquizz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CheatActivity extends AppCompatActivity {
    public static final String EXTRA_ANSWER_IS_TRUE = "com.example.geoquizz.answer_is_true";
    
    private Button showAnswerButton;
    private boolean isWasOpened = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        showAnswerButton = findViewById(R.id.show_answer_button);

    }

    public void onCheatButtonPressed(View view) {

    }
}
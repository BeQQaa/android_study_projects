package com.example.geoquizz;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final static String TAG = "MainActivity";
    private Button falseButton;
    private Button trueButton;
    private Button nextButton;
    private Button prevButton;
    private Button cheatButton;
    private TextView questionTextID;
    private TextView resultTextView;
    private static final String KEY_INDEX_CURRENT = "index";
    private static final String KEY_INDEX_COUNT = "countIndex";
    private static final String KEY_INDEX_CORRECT = "correctCount";
    private int currentIndex = 0;
    private int count = -1;
    private int countCorrect = 0;

    private List<Question> questions = Arrays.asList(
            new Question(R.string.question_of_ukraine, false),
            new Question(R.string.question_africa, false),
            new Question(R.string.question_americas, true),
            new Question(R.string.question_asia, true),
            new Question(R.string.question_mideast, false),
            new Question(R.string.question_oceans, true)
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate(Bundle?) called)");
        setContentView(R.layout.activity_main);

        if (savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(KEY_INDEX_CURRENT,0);
            count = savedInstanceState.getInt(KEY_INDEX_COUNT, -1);
            countCorrect = savedInstanceState.getInt(KEY_INDEX_CORRECT, 0);
        }

        trueButton = (Button) findViewById(R.id.true_button);
        falseButton = (Button) findViewById(R.id.false_button);
        nextButton = (Button) findViewById(R.id.next_button);
        prevButton = (Button) findViewById(R.id.prev_button);
        cheatButton = (Button) findViewById(R.id.cheat_button);
        questionTextID = (TextView) findViewById(R.id.questions_text_view);
        resultTextView = (TextView) findViewById(R.id.result_text_view);
        Update();


    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt(KEY_INDEX_CURRENT, currentIndex);
        savedInstanceState.putInt(KEY_INDEX_COUNT, count);
        savedInstanceState.putInt(KEY_INDEX_CORRECT, countCorrect);
    }

    public void TrueButtonPressed(View view) {
        trueButton.setOnClickListener(v -> {
            checkAnswer(true);
            count++;
            makeTrueFalseButtonsNotClickable();
            getResult(1);

        });

    }

    public void FalseButtonPressed(View view) {
        falseButton.setOnClickListener(v -> {
            checkAnswer(false);
            count++;
            makeTrueFalseButtonsNotClickable();
            getResult(1);
        });
    }


    public void OnNextButtonPressed(View view) {
        nextButton.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % questions.size();
            Update();
            checkCanBeClickable();
        });
    }

    public void OnPrevButtonPressed(View view) {
        prevButton.setOnClickListener(v -> {
            if (currentIndex == 0) {
                currentIndex = questions.size() -1;
            } else {
                currentIndex = (currentIndex - 1) % questions.size();
            }
            Update();
        });
    }

    public void onClickTextView(View view) {
        questionTextID.setOnClickListener(v -> {
            currentIndex = (currentIndex + 1) % questions.size();
            Update();
            checkCanBeClickable();
        });
    }

    public void onClickCheatButton(View view) {
        cheatButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cheatIntent = new Intent(MainActivity.this, CheatActivity.class);
                cheatIntent.putExtra(CheatActivity.EXTRA_ANSWER_IS_TRUE, currentIndex);
                startActivity(cheatIntent);
            }
        });
    }

    public void Update() {
        int questionIndex = questions.get(currentIndex).getTextResId();
        questionTextID.setText(questionIndex);
    }

    private void makeTrueFalseButtonsNotClickable() {
        trueButton.setClickable(false);
        falseButton.setClickable(false);
    }
    private void makeTrueFalseButtonsClickable() {
        trueButton.setClickable(true);
        falseButton.setClickable(true);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean correctAnswer = questions.get(currentIndex).isAnswer();

        int isMessId;
        if (userAnswer == correctAnswer) {
            isMessId = R.string.correct_toast;
            countCorrect++;
        } else {
            isMessId = R.string.incorrect_toast;
        }
        Toast toast = Toast.makeText(this, isMessId, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.TOP, 0, 150);
        toast.show();
    }

    private void getResult(int steps) {
        if (count >= (questions.size()-steps)){
            resultTextView.setText("You correct answers is " + countCorrect); }
    }

    private void checkCanBeClickable(){
        if (currentIndex > count){
            makeTrueFalseButtonsClickable();
        }else {
            makeTrueFalseButtonsNotClickable();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart called)");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called)");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called)");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called)");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called)");
    }
}
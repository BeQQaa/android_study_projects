package com.example.calculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Symbols symbol;
    private String numberBuffer;
    private TextView displayCalculator;
    private Button AbstractsButton;
    private Button buttonOne;
    private Button buttonTwo;
    private Button buttonTree;
    private Button buttonFour;
    private Button buttonFive;
    private Button buttonSix;
    private Button buttonSeven;
    private Button buttonEight;
    private Button buttonNine;
    private Button buttonZero;
    private Button buttonDivide;
    private Button buttonMinus;
    private Button buttonPlus;
    private Button buttonMultiply;
    private Button buttonDelete;
    private Button buttonClear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        symbol = new Symbols();
        displayCalculator = findViewById(R.id.display_calculator);
        buttonOne = findViewById(R.id.id_button_one);
        buttonTwo = findViewById(R.id.id_button_two);
        buttonTree = findViewById(R.id.id_button_three);
        buttonFour = findViewById(R.id.id_button_four);
        buttonFive = findViewById(R.id.id_button_five);
        buttonSix = findViewById(R.id.id_button_six);
        buttonSeven = findViewById(R.id.id_button_seven);
        buttonEight = findViewById(R.id.id_button_eight);
        buttonNine = findViewById(R.id.id_button_nine);
        buttonZero = findViewById(R.id.id_button_zero);
        buttonDivide = findViewById(R.id.id_button_divide);
        buttonMinus = findViewById(R.id.id_button_minus);
        buttonPlus = findViewById(R.id.id_button_plus);
        buttonMultiply = findViewById(R.id.id_button_multiply);
        buttonDelete = findViewById(R.id.id_button_delete);
        buttonClear = findViewById(R.id.id_button_clear);

        buttonOne.setOnClickListener(this);
        buttonTwo.setOnClickListener(this);
        buttonTree.setOnClickListener(this);
        buttonFour.setOnClickListener(this);
        buttonFive.setOnClickListener(this);
        buttonSix.setOnClickListener(this);
        buttonSeven.setOnClickListener(this);
        buttonEight.setOnClickListener(this);
        buttonNine.setOnClickListener(this);
        buttonZero.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);
        buttonClear.setOnClickListener(this);

    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.id_button_one:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getOne()));
                break;
            case R.id.id_button_two:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getTwo()));
                break;

            case R.id.id_button_three:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getTree()));
                break;

            case R.id.id_button_four:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getFour()));
                break;

            case R.id.id_button_five:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getFive()));
                break;

            case R.id.id_button_six:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getSix()));
                break;

            case R.id.id_button_seven:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getSeven()));
                break;

            case R.id.id_button_eight:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getEight()));
                break;

            case R.id.id_button_nine:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getNine()));
                break;

            case R.id.id_button_zero:
                numberBuffer = displayCalculator.getText().toString();
                displayCalculator.setText(String.format("%s%s", numberBuffer, symbol.getZero()));
                break;

            case R.id.id_button_divide:

            case R.id.id_button_minus:

            case R.id.id_button_plus:

            case R.id.id_button_multiply:

            case R.id.id_button_delete:
                if (!displayCalculator.getText().equals("")){
                    String text = displayCalculator.getText().toString();
                    StringBuilder stringBuffer = new StringBuilder(text);
                    stringBuffer.delete(text.length() - 1, text.length());
                    displayCalculator.setText(stringBuffer.toString());
                }
                break;



            case R.id.id_button_clear:
                displayCalculator.setText("");
                break;

        }
    }
}
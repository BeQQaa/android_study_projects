package com.example.lifecycleedit;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Edit extends AppCompatActivity implements View.OnClickListener {
    public static final String SENDING_INPUT_TEXT_FROM_EDIT = "com.example.lifecycleedit.edit.editText";

    private Button button;
    private EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);

        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.commit_button);

        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String getText = editText.getText().toString();
        if (!getText.equals("")) {
            if (v.getId() == button.getId()){
                Intent intent = new Intent(this, EndActivity.class);
                intent.putExtra(SENDING_INPUT_TEXT_FROM_EDIT, getText);
//                startActivity(intent);
                startActivityForResult(intent, 200);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {

        if (requestCode == 200){
            String text = data.getStringExtra(SENDING_INPUT_TEXT_FROM_EDIT);
            if (text != null){
                Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
            }
            return;
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
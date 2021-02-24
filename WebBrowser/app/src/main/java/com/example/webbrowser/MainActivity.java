package com.example.webbrowser;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    public static final int W = ViewGroup.LayoutParams.WRAP_CONTENT;
    public static final int M = ViewGroup.LayoutParams.MATCH_PARENT;
    public static final String defaultUrlGoogle = "http://google.com";
    String textPressMe = "Press me";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        EditText edit = new EditText(this);
        edit.setLayoutParams(new ViewGroup.LayoutParams(M, W));

        Button button = new Button(this);
        edit.setLayoutParams(new ViewGroup.LayoutParams(W, W));
        button.setText(textPressMe);

        WebView web = new WebView(this);
        web.setLayoutParams(new ViewGroup.LayoutParams(M, M));
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(defaultUrlGoogle);

        LinearLayout linear = new LinearLayout(this);
        linear.setLayoutParams(new ViewGroup.LayoutParams(M, M));
        linear.setOrientation(LinearLayout.VERTICAL);

        linear.addView(edit);
        linear.addView(button);
        linear.addView(web);

        button.setOnClickListener(v -> {
            String url = edit.getText().toString();
            web.loadUrl(url);

        });

        setContentView(linear);
    }
}
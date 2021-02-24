package com.example.menu;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, View.OnClickListener {

    private Button button;
    private Button buttonNext;
    private PopupMenu popupMenu;
    boolean isPressed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button_exit);
        buttonNext = findViewById(R.id.next_buttom);
        registerForContextMenu(findViewById(R.id.view_hello));

        popupMenu = new PopupMenu(this, findViewById(R.id.view_hello));
        popupMenu.inflate(R.menu.popup);
        popupMenu.setOnMenuItemClickListener(this);

        findViewById(R.id.view_hello).setOnClickListener(this);

        buttonNext.setOnClickListener(this::onButtonClick);
        button.setOnClickListener(this::onButtonClick);
    }

    private void onButtonClick(View view) {
        if (view.getId() == button.getId()){
            invalidateOptionsMenu();
            isPressed = true;
            button.setVisibility(View.INVISIBLE);
        } else if (view.getId() == buttonNext.getId()){
            Intent intent = new Intent(this, NavigationActivity.class);
            startActivity(intent);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        if (isPressed) {
            getMenuInflater().inflate(R.menu.option_menu, menu);
        } else if (!isPressed) {
            getMenuInflater().inflate(R.menu.main, menu);
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if (v.getId() == R.id.view_hello) {
            getMenuInflater().inflate(R.menu.context, menu);
        }
        super.onCreateContextMenu(menu, v, menuInfo);
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.context_exit) {
            Toast.makeText(this, "Are you shure want to exit?", Toast.LENGTH_SHORT).show();
        }
        return super.onContextItemSelected(item);
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.main_cre:
                System.out.println("1");
                break;
            case R.id.main_del:
                System.out.println("2");
                break;
            case R.id.main_add:
                System.out.println("3");
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        if (item.getItemId() == R.id.quit_popup) {
            Toast.makeText(this, "Quit", Toast.LENGTH_SHORT).show();
            button.setVisibility(View.VISIBLE);
        }
        return false;
    }

    @Override
    public void onClick(View v) {
        popupMenu.show();
    }
}
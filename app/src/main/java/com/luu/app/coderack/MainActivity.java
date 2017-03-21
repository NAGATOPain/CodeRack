package com.luu.app.coderack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private void initToolbar(){
        Toolbar actionBar = (Toolbar) this.findViewById(R.id.actionBar);
        setSupportActionBar(actionBar);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
    }

    private void initButton(){
        initCaesarButton();
        initVigenereButton();
        initNumToCharButton();
        initMorseButton();
    }

    private void initCaesarButton(){
        Button btnCaesar = (Button) this.findViewById(R.id.caesarBtn);
        btnCaesar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CaesarActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initVigenereButton(){
        Button btnVigenere = (Button) this.findViewById(R.id.vigenereBtn);
        btnVigenere.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, VigenereActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initNumToCharButton(){
        Button btnNumToChar = (Button) this.findViewById(R.id.ntocharBtn);
        btnNumToChar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, numtocharActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initMorseButton(){
        Button btnMorse = (Button) this.findViewById(R.id.morseBtn);
        btnMorse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MorseActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initButton();
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.actionbar_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.infoButton:
                CharSequence info = "This app's made by Luu, 20-3-2017";
                Toast.makeText(getApplicationContext(), info, Toast.LENGTH_SHORT).show();
                return true;
            case R.id.settingButton:

                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}

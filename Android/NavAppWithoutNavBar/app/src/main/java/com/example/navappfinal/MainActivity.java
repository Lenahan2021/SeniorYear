package com.example.navappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button SciFiBTN, GTNBTN, MadBTN, CreditsBTN;
    private TextView introTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        introTXT = findViewById(R.id.IntroTXT);
        SciFiBTN = findViewById(R.id.SciFiNameBTN);
        GTNBTN = findViewById(R.id.GuessingNumberBTN);
        MadBTN = findViewById(R.id.MadLibsBTN);
        CreditsBTN = findViewById(R.id.creditsBTN);

        introTXT.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);

        CreditsBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Credits.class);
                startActivity(i);
            }
        });
//
        MadBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, MadLib.class);
                startActivity(i);
            }
        });
//
        SciFiBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SciFi.class);
                startActivity(i);
            }
        });

        GTNBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, GuessTheNumber.class);
                startActivity(i);
            }
        });
    }
}
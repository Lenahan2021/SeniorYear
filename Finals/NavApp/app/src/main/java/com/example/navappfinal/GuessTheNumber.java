package com.example.navappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import java.util.Random;

public class GuessTheNumber extends AppCompatActivity {

    Random randy = new Random();
    int randomNumber = randy.nextInt(100)+1;
    int strikesLeft = 10;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number);
    }
}
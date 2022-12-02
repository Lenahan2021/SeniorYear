package com.example.navappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

import javax.xml.transform.Result;

public class GuessTheNumber extends AppCompatActivity {

    private TextView StrikesTXT;
    private TextView ResultTXT;
    private TextView PointsTXT;
    private EditText inputTXT;
    private Button checkBTN, resetBTN, backBTN;

    static Random randy = new Random();
    static int randomNumber = randy.nextInt(100)+1;
    static int strikesLeft = 10;
    static int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guess_the_number);

        StrikesTXT = findViewById(R.id.StrikesTXT);
        ResultTXT = findViewById(R.id.ResultTXT);
        inputTXT = findViewById(R.id.inputTXT);
        PointsTXT = findViewById(R.id.PointsTXT);
        checkBTN = findViewById(R.id.CheckBTN);
        backBTN = findViewById(R.id.BackGNBTN);
        resetBTN = findViewById(R.id.ResetBTN);
        resetBTN.setVisibility(View.INVISIBLE);

        StrikesTXT.setText(String.format("Strikes: %s", strikesLeft));
        PointsTXT.setText(String.format("Points: %s", points));

        ResultTXT.setText("");

        checkBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (strikesLeft > 0) {
                    strikesLeft--;
                    StrikesTXT.setText(String.format("Strikes: %s", strikesLeft));
                    try {
                        check(Integer.parseInt(inputTXT.getText().toString()));
                    } catch (Exception e) {
                        ResultTXT.setText("Invalid Entry!");
                    }
                } else {
                    ResultTXT.setText("Sorry, you are out of strikes and have lost :(\nClick the reset button to play again!");
                    resetBTN.setVisibility(View.VISIBLE);
                }
            }
        });

        resetBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetBTN.setVisibility(View.INVISIBLE);
                strikesLeft = 10;
                points = 0;
                StrikesTXT.setText(String.format("Strikes: %s", strikesLeft));
                PointsTXT.setText(String.format("Points: %s", points));
                randomNumber = randy.nextInt(100)+1;
                ResultTXT.setText("A new secret number has been created.");
            }
        });

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(GuessTheNumber.this, MainActivity.class);
                startActivity(i);
            }
        });

    }
     private void check(int guess) {
        if (guess == randomNumber) {
            ResultTXT.setText("Good job! You guessed the answer!\nA new secret number has been created.");
            points += (50 + (strikesLeft*5));
            strikesLeft = 10;
            StrikesTXT.setText(String.format("Strikes: %s", strikesLeft));
            PointsTXT.setText(String.format("Points: %s", points));
            randomNumber = randy.nextInt(100)+1;
        } else if (guess > randomNumber){
            ResultTXT.setText("Your guess was higher than the number");
        } else {
            ResultTXT.setText("Your guess was lower than the number");
        }
         StrikesTXT.setText(String.format("Strikes: %s", strikesLeft));
    }

}
package com.example.a6_navdrawertest.ui.guessTheNumber;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a6_navdrawertest.R;

import java.util.Random;


public class GTNFragment extends Fragment {

    private TextView StrikesTXT;
    private TextView ResultTXT;
    private TextView PointsTXT;
    private EditText inputTXT;
    private Button checkBTN, resetBTN;

    static Random randy = new Random();
    static int randomNumber = randy.nextInt(100)+1;
    static int strikesLeft = 10;
    static int points = 0;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_gtn,container,false);


        StrikesTXT = rootView.findViewById(R.id.StrikesTXT);
        ResultTXT = rootView.findViewById(R.id.ResultTXT);
        inputTXT = rootView.findViewById(R.id.inputTXT);
        PointsTXT = rootView.findViewById(R.id.PointsTXT);
        checkBTN = rootView.findViewById(R.id.CheckBTN);
        resetBTN = rootView.findViewById(R.id.ResetBTN);
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

        return rootView;
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

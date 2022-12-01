package com.example.navappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Credits extends AppCompatActivity {

    private Button backBTN;
    private TextView creditsTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);

        backBTN = findViewById(R.id.BackBTN);
        creditsTXT = findViewById(R.id.creditsTXT);

        String creditsText = "By: Spencer Lenahan\nSources:\nSpencer's SciFi Name Generator\nSpencer's Mad Lib Generator";

        //https://stackoverflow.com/questions/432037/how-do-i-center-text-horizontally-and-vertically-in-a-textview/42945970#:~:text=Try%20this%3A,center%20attribute%20in%20your%20LinearLayout.&text=Save%20this%20answer.,-Show%20activity%20on
        creditsTXT.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        creditsTXT.setText(creditsText);
        //https://stackoverflow.com/questions/4602902/how-to-set-the-text-color-of-textview-in-code
        creditsTXT.setTextColor(Color.parseColor("#0000FF"));

        backBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Credits.this, MainActivity.class);
                startActivity(i);
            }
        });


    }
}
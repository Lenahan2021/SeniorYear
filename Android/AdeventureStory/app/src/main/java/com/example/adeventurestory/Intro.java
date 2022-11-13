package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Intro extends AppCompatActivity {

    private EditText NameUI, TownUI,RichPoorUI, StrongWeakUI, AgeUI, TallorShortUI;
    private Button StartBTN;
    private TextView ErrorTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        StartBTN = findViewById(R.id.StartBTN);
        NameUI = findViewById(R.id.Name);
        RichPoorUI = findViewById(R.id.RichOrPoor);
        TownUI = findViewById(R.id.Town);
        StrongWeakUI = findViewById(R.id.StrongOrWeak);
        AgeUI = findViewById(R.id.Age);
        TallorShortUI = findViewById(R.id.TallOrShort);
        StartBTN = findViewById(R.id.StartBTN);
        ErrorTXT = findViewById(R.id.ErrorTXT);

        StartBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (NameUI.getText().toString().trim().equals("") || RichPoorUI.getText().toString().trim().equals("") || TownUI.getText().toString().trim().equals("") ||
                        StrongWeakUI.getText().toString().trim().equals("") || AgeUI.getText().toString().trim().equals("") || TallorShortUI.getText().toString().trim().equals(""))
                {
                    ErrorTXT.setText("Please make sure all fields are filled in!");

                } else {
                    Intent i = new Intent(Intro.this, MainRoom.class);

                    i.putExtra("nameExtra", NameUI.getText().toString());
                    i.putExtra("townExtra", TownUI.getText().toString());
                    i.putExtra("richPoorExtra", RichPoorUI.getText().toString());
                    i.putExtra("strongWeakExtra", StrongWeakUI.getText().toString());
                    i.putExtra("AgeExtra", AgeUI.getText().toString());
                    i.putExtra("tallShortExtra", TallorShortUI.getText().toString());

                    startActivity(i);


                }
            }
        });
    }
}
package com.example.intentexample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    //1. create global variables
    private Button first;
    private EditText firstInformation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //2. connect variables to widgets
        first = findViewById(R.id.firstBTN);
        firstInformation = findViewById(R.id.firstUI);

        first.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ui = String.valueOf(firstInformation.getText());

                //Intent objName = new Intent(Which activity are you in, where are you going?);
                Intent i = new Intent(MainActivity.this,SecondActivity.class);

                //set key to a value for the intent to remember
                i.putExtra("user input",ui);

                startActivity(i);

                //EVERY Activity needs
                //  java file and xml file
            }
        });


    }
}
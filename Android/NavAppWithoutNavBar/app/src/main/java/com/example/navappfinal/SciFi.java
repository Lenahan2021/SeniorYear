package com.example.navappfinal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SciFi extends AppCompatActivity {
    EditText firstNameTXT, lastNameTXT, cityTXT, schoolTXT, broTXT, sisTXT;
    Button generatorBTN, BackBTN;
    TextView output;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sci_fi);
        //Second Thing: connect global variables to widget
        firstNameTXT = findViewById(R.id.firstTXT);
        lastNameTXT = findViewById(R.id.lastTXT);
        cityTXT = findViewById(R.id.cityTXT);
        schoolTXT = findViewById(R.id.schoolTXT);
        broTXT = findViewById(R.id.broTXT);
        sisTXT = findViewById(R.id.sisTXT);
        output = findViewById(R.id.output);
        generatorBTN = findViewById(R.id.generator);
        BackBTN = findViewById(R.id.BackSFBTN);

        generatorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate();
            }
        });

        BackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SciFi.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    private void generate(){
        String first = String.valueOf(firstNameTXT.getText());
        String last = String.valueOf(lastNameTXT.getText());
        String city = String.valueOf(cityTXT.getText());
        String school = String.valueOf(schoolTXT.getText());
        String brother = String.valueOf(broTXT.getText());
        String sister = String.valueOf(sisTXT.getText());

        //generate the bounds for each portion of the variable
        Random randy = new Random();
        int rF = randy.nextInt(first.length());
        int rL = randy.nextInt(last.length());
        int rC = randy.nextInt(city.length());
        int rS = randy.nextInt(school.length());
        int rB = randy.nextInt(brother.length());
        int rSi = randy.nextInt(sister.length());

        //generate scifi first name -> first 3 letters of firstName and last 3 letters of lastName
        String sciFiFirst = first.substring(0,rF)+last.substring(rL);
        //generate scifi last name -> first 2 letters of city and last 4 letters of school
        String sciFiLast = city.substring(0,rC)+school.substring(rS);
        //generate scifi home name -> first 4 letters of brother and last 2 letters of sister
        String sciFiHome = brother.substring(0,rB)+sister.substring(rSi);

        output.setText(String.format("Welcome! %s %s from %s",sciFiFirst,sciFiLast,sciFiHome));

    }
}
package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class CastleDiningHall extends AppCompatActivity {

    private Button CastleBTN;
    private ArrayList<String> inventory;
    private TextView diningHallTXT, keyTXT;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle_dining_hall);

        Bundle extras = getIntent().getExtras();



        CastleBTN = findViewById(R.id.DiningCastleBTN);
        diningHallTXT = findViewById(R.id.DiningHallTXT);
        keyTXT = findViewById(R.id.KeyTXT);

        inventory = MainRoom.getInvent();

        diningHallTXT.setText(String.format("%s, %s.", diningHallTXT.getText(), extras.getString("nameExtra")));


        if (!inventory.contains("WizardKey")) {
            inventory.add("WizardKey");
            keyTXT.setText("You have found a wizardKey!");
        } else {
            keyTXT.setText("You have already found what you are looking for");
        }

        CastleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CastleDiningHall.this, Castle.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });
    }
}
package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;

import java.util.ArrayList;

public class Alley extends AppCompatActivity {

    private ArrayList<String> inventory;
    private TextView SpaceKeyTXT;
    private Button TownBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alley);

        inventory = MainRoom.getInvent();

        SpaceKeyTXT = findViewById(R.id.SpaceshipKeyTXT);
        TownBTN = findViewById(R.id.TownBTN);

        Bundle extras = getIntent().getExtras();

        if (inventory.contains("SpaceKey")) {
            SpaceKeyTXT.setText("You have already found your Space Key");
        } else {
            SpaceKeyTXT.setText("You have found your spaceship key!");
            inventory.add("SpaceKey");
        }

        TownBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Alley.this, Town.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });


    }
}
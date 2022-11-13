package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Space;
import android.widget.TextView;

import java.util.ArrayList;

public class Town extends AppCompatActivity {

    private Button AlleyBTN, SpaceshipBTN, WizardTowerBTN;
    private ArrayList<String> inventory;
    private TextView TownTXT, spaceshipTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_town);

        TownTXT = findViewById(R.id.TownTXT);
        AlleyBTN = findViewById(R.id.AlleyBTN);
        SpaceshipBTN = findViewById(R.id.SpaceshipBTN);
        WizardTowerBTN = findViewById(R.id.TownWizardBTN);
        spaceshipTXT = findViewById(R.id.spacekeyTXT);

        spaceshipTXT.setText("");

        inventory = MainRoom.getInvent();

        Bundle extras = getIntent().getExtras();

        if (MainRoom.hasVisitedTown) {
            TownTXT.setText("You came back to the town");
        }

        if (!MainRoom.hasVisitedTown) {
            TownTXT.setText("After killing the wizard, you were teleported to this town.");
            MainRoom.hasVisitedTown = true;
        }


        AlleyBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Town.this, Alley.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        SpaceshipBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inventory.contains("SpaceKey")) {
                    Intent i = new Intent(Town.this, Spaceship.class);
                    startActivity(i);
                } else {
                    spaceshipTXT.setText("You need to find your spaceship key!");
                }
            }
        });

        WizardTowerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Town.this, WizardTower.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });

    }
}
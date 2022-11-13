package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class WizardTower extends AppCompatActivity {

    private Button OutsideBTN, TownBTN;

    public static ArrayList<String> inventory;

    private TextView castleTXT, swordTXT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wizard_tower);

        castleTXT = findViewById(R.id.castleText);
        OutsideBTN = findViewById(R.id.OutsideWizard);
        TownBTN = findViewById(R.id.WizardTownBTN);
        swordTXT = findViewById(R.id.swordText);

        swordTXT.setText("");


        inventory = MainRoom.getInvent();

        Bundle extras = getIntent().getExtras();

        if (MainRoom.slainWizard == false) {
            TownBTN.setText("Kill Wizard");
            castleTXT.setText(String.format("Welcome to the wizard Castle , %s \n You must kill the wizard.", extras.getString("nameExtra")));
        } else {
            TownBTN.setText("Town");
            castleTXT.setText(String.format("Welcome to the wizard Castle, %s \n You have already killed the foe.",extras.getString("nameExtra")));
        }

        OutsideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WizardTower.this, MainRoom.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        TownBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inventory.contains("Sword")) {
                    MainRoom.slainWizard = true;
                    Intent i = new Intent(WizardTower.this, Town.class);
                    i.putExtras(extras);
                    startActivity(i);
                } else {
                    swordTXT.setText("You need a weapon to kill the wizard!");
                }
            }
        });
    }
}
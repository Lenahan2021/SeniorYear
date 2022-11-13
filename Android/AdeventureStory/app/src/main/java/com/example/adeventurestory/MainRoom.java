package com.example.adeventurestory;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainRoom extends AppCompatActivity {

    public static ArrayList<String> inventory;
    public static boolean slainWizard;
    private TextView mainText, WizardKeyText;
    private Button CastleBTN, CaveBTN, WizardTowerBTN;
    public static boolean hasVisitedTown;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_room);
        mainText = findViewById(R.id.MainText);
        CastleBTN = findViewById(R.id.Castle);
        CaveBTN = findViewById(R.id.Cave);
        WizardTowerBTN = findViewById(R.id.WizardTower);
        WizardKeyText = findViewById(R.id.WizardKey);
        WizardKeyText.setText("");

        Bundle extras = getIntent().getExtras();

        if (extras == null) {
            Toast.makeText(MainRoom.this, "Extras is null",
                    Toast.LENGTH_LONG).show();
        }

        if (inventory == null) {
            Toast.makeText(MainRoom.this, "Inventory is null",
                    Toast.LENGTH_LONG).show();
            inventory = new ArrayList<String>();
            inventory.add("Created");
        }

mainText.setText(String.format("Welcome %s from %s. You are a %s , %s alien aged %s that is very %s. You were thrown from your ship during the crash and you need to find your way back to the craft. Navigate through the rooms in order to get back to your spaceship and go home",
        extras.getString("nameExtra"), extras.getString("townExtra"), extras.getString("richPoorExtra"), extras.getString("strongWeakExtra"),
        extras.getString("AgeExtra"), extras.getString("tallShortExtra")));



        WizardTowerBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean hasKey = false;
                for (String item: inventory) {
                    if (item.equals("WizardKey")) {
                        hasKey = true;
                        break;
                    }
                }

                if (hasKey) {
                    Intent i = new Intent(MainRoom.this, WizardTower.class);
                    i.putExtras(extras);
                    startActivity(i);
                } else {
                    WizardKeyText.setText("You need to find the Wizard Key to advance!");
                }
            }
        });

        CaveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoom.this, Cave.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        CastleBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainRoom.this, Castle.class);

                i.putExtras(extras);

                startActivity(i);
            }
        });
    }


    public static ArrayList<String> getInvent() {
        return inventory;
    }
}
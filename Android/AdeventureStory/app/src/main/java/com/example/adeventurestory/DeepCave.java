package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class DeepCave extends AppCompatActivity {

    private ArrayList<String> inventory;
    private Button CaveBTN;
    private TextView DeepCaveTXT;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deep_cave);

        CaveBTN = findViewById(R.id.BackCave);
        DeepCaveTXT = findViewById(R.id.deepCaveTXT);

        inventory = MainRoom.getInvent();

        Bundle extras = getIntent().getExtras();

        if (inventory.contains("Sword")) {
            DeepCaveTXT.setText("You have already found what you are looking for");
        } else {
            DeepCaveTXT.setText("You have found a sword! \nThis could provide useful against a foe");
            inventory.add("Sword");
        }


        CaveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(DeepCave.this, Cave.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });
    }
}
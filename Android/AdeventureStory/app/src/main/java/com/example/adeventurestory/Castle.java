package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Castle extends AppCompatActivity {

    private Button OutsideBTN, DiningHallBTN;
    private ArrayList<String> inventory;
    private TextView castleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_castle);

        OutsideBTN = findViewById(R.id.Outside);
        DiningHallBTN = findViewById(R.id.DiningHallBTN);
        castleText = findViewById(R.id.CastleText);

        Bundle extras = getIntent().getExtras();

        inventory = MainRoom.getInvent();

        castleText.setText(String.format("%s %s.", castleText.getText(), extras.getString("nameExtra")));

        OutsideBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Castle.this, MainRoom.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        DiningHallBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Castle.this, CastleDiningHall.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });
    }


}
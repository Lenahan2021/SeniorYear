package com.example.adeventurestory;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Cave extends AppCompatActivity {

    private Button OutsideCave, goDeeper;
    private TextView caveText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cave);

        caveText = findViewById(R.id.CaveTXT);
        goDeeper = findViewById(R.id.goDeeper);
        OutsideCave = findViewById(R.id.OutsideCave);

        Bundle extras = getIntent().getExtras();


        caveText.setText(String.format("%s, %s.", caveText.getText(), extras.getString("nameExtra")));


        goDeeper.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cave.this, DeepCave.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });

        OutsideCave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Cave.this, MainRoom.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });
    }
}
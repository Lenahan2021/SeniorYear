package com.example.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {

    private Button thirdBTN;
    private TextView thirdLBL;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        thirdBTN=findViewById(R.id.thirdBTN);
        thirdLBL=findViewById(R.id.thirdLBL);

        String valueOfIntent=getIntent().getStringExtra("user input");
        thirdLBL.setText(valueOfIntent);






    }
}

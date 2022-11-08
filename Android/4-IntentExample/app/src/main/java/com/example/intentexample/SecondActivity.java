package com.example.intentexample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    //1. global var
    private Button second;
    private TextView secondLBL;
    private EditText secondUI;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);       //this connects the xml to the java

        //2. connect var with widgets
        second=findViewById(R.id.secondBTN);
        secondLBL=findViewById(R.id.secondLBL);
        secondUI=findViewById(R.id.secondUI);

        //3. obtain Intent values
        String valueOfIntent = getIntent().getStringExtra("user input");
        secondLBL.setText(valueOfIntent);

        second.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent objName = new Intent(Which activity are you in, where are you going?);
                Intent i = new Intent(getApplicationContext(),ThirdActivity.class);

                String ui = valueOfIntent+"\t"+secondUI.getText();

                i.putExtra("user input",ui);
                startActivity(i);
            }
        });

    }
    /*
        1. create Java and XML files
        2. extends AppCompatActivity
        3. setup onCreate
        4. setContentView(R.layout.new_xml_file)
        5. add Activity to the Manifest
     */
}

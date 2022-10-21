package com.example.fourfunctioncalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //set global variables
    private EditText number1TXT, number2TXT;
    private Button addBTN, subBTN, mulBTN, divBTN;
    private TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link java objects to widgets
        number1TXT = findViewById(R.id.number1TXT);
        number2TXT = findViewById(R.id.number2TXT);
        addBTN = findViewById(R.id.addBTN);
        subBTN = findViewById(R.id.minusBTN);
        mulBTN = findViewById(R.id.multBTN);
        divBTN = findViewById(R.id.divBTN);
        output = findViewById(R.id.output);

        //setOnClickListener
        addBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(String.valueOf(number1TXT.getText()));
                //numberValue = ConvertToInt(ConvertToString(getTextFromEditable)));
                int num2 = Integer.parseInt(String.valueOf(number2TXT.getText()));
                int answer = num1 + num2;
                output.setText(String.valueOf(answer));
            }
        });
        subBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(String.valueOf(number1TXT.getText()));
                //numberValue = ConvertToInt(ConvertToString(getTextFromEditable)));
                int num2 = Integer.parseInt(String.valueOf(number2TXT.getText()));
                int answer = num1 - num2;
                output.setText(String.valueOf(answer));
            }
        });
        mulBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(String.valueOf(number1TXT.getText()));
                //numberValue = ConvertToInt(ConvertToString(getTextFromEditable)));
                int num2 = Integer.parseInt(String.valueOf(number2TXT.getText()));
                int answer = num1 * num2;
                output.setText(String.valueOf(answer));
            }
        });
        divBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int num1 = Integer.parseInt(String.valueOf(number1TXT.getText()));
                //numberValue = ConvertToInt(ConvertToString(getTextFromEditable)));
                int num2 = Integer.parseInt(String.valueOf(number2TXT.getText()));
                int answer = num1 / num2;
                output.setText(String.valueOf(answer));
            }
        });

    }
    //additional functions
    private int calc(String operator,int n1, int n2){
        if (operator.equals("+")){
            return n1+n2;
        }
        return 0;
    }
}
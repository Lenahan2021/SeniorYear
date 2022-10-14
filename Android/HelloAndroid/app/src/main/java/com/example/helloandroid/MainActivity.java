package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    static TextView outputLBL;
    static EditText inputTXT;
    Button enterBTN;

    //the first method to be ran -> on screen boot up goes here
    @Override
    protected void onCreate(Bundle savedInstanceState) {  //equivalent to public static void main(String[] args) {}
        super.onCreate(savedInstanceState);         //inheritance constructor to run the onCreate method
        setContentView(R.layout.activity_main);     //sets the java to look at the xml file

        //first thing is to connect Java objects to your widgets
        outputLBL = findViewById(R.id.textView);
        inputTXT = findViewById(R.id.inputBox);
        enterBTN = findViewById(R.id.enterBTN);

        enterBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hello();
            }
        });
    }

    //if wanting to hardcode the onclick need View v in function parameter
    public static void hello() {
        //take in user input -> get text from the widget
        String ui = String.valueOf(inputTXT.getText());

        //output "hello input"

        outputLBL.setText("Howdy "+ ui);
    }
}
package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button oneBTN, twoBTN, threeBTN, fourBTN, fiveBTN, sixBTN, sevenBTN, eightBTN, nineBTN, zeroBTN, plusBTN, minusBTN, multBTN, divBTN, equalBTN, decimalBTN, clearBTN;
    private TextView output;

    private double number1 = 0;
    private double number2 = 0;
    private String operation = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        output = findViewById(R.id.output);
        oneBTN = findViewById(R.id.one);
        twoBTN = findViewById(R.id.two);
        threeBTN = findViewById(R.id.three);
        fourBTN = findViewById(R.id.four);
        fiveBTN = findViewById(R.id.five);
        sixBTN = findViewById(R.id.six);
        sevenBTN = findViewById(R.id.seven);
        eightBTN = findViewById(R.id.eight);
        nineBTN = findViewById(R.id.nine);
        zeroBTN = findViewById(R.id.zero);
        plusBTN = findViewById(R.id.plus);
        minusBTN = findViewById(R.id.minus);
        multBTN = findViewById(R.id.multiply);
        divBTN = findViewById(R.id.divide);
        decimalBTN = findViewById(R.id.decimal);
        clearBTN = findViewById(R.id.Clear);

        oneBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) oneBTN.getText());
            }
        });

        twoBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) twoBTN.getText());
            }
        });

        threeBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) threeBTN.getText());
            }
        });
        fourBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) fourBTN.getText());
            }
        });
        fiveBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) fiveBTN.getText());
            }
        });
        sixBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) sixBTN.getText());
            }
        });

        sevenBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) sevenBTN.getText());
            }
        });
        eightBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) eightBTN.getText());
            }
        });
        nineBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) nineBTN.getText());
            }
        });

        decimalBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                input((String) decimalBTN.getText());
            }
        });
        clearBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clear();
            }
        });

        plusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationFunc((String) plusBTN.getText());
            }
        });

        minusBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationFunc((String) minusBTN.getText());
            }
        });

        divBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationFunc((String) divBTN.getText());
            }
        });

        multBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operationFunc((String) multBTN.getText());
            }
        });

//        equalBTN.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                equal();
//            }
//        });
    }

    private void input(String symbol) {
        output.setText(output.getText() + symbol);
    }

    private void clear() {
        output.setText("");
        output.setHint("0");
        operation = null;
    }

    private void operationFunc(String operator) {
        operation = operator;
        number1 = Double.parseDouble(String.valueOf(output.getText()));
        output.setText("");

    }

    private void equal() {
        if (operation != null) {
            number2 = Double.parseDouble(String.valueOf(output.getText()));
            if (operation == "+") {
                output.setText(String.valueOf(number1 + number2));
            } else if (operation == "-") {
                output.setText(String.valueOf(number1 - number2));
            } else if (operation == "*") {
                output.setText(String.valueOf(number1 * number2));
            } else if (operation == "/") {
                output.setText(String.valueOf(number1 / number2));
            }
        }
    }


}
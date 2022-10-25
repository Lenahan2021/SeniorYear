package com.example.madlibgenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private EditText adj1TXT, adj2TXT, birdTXT, roomTXT, verb1TXT, verb2TXT, relativeTXT, nounTXT;
    private TextView outputTXT;
    private Button genBTN, newMadLibBTN;

    private int chosenMadLib;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //linking java objects to the widgets
        //I messed up the naming conventions of the widgets because I didn't know
        // how I wanted to change the purpose of each box
        //These are the boxes in order from top to bottom
        adj1TXT = findViewById(R.id.AdjTXT);
        adj2TXT = findViewById(R.id.Adj2TXT);
        birdTXT = findViewById(R.id.BirdTXT);
        roomTXT = findViewById(R.id.HouseTXT);
        verb1TXT = findViewById(R.id.Verb1TXT);
        verb2TXT = findViewById(R.id.Verb2TXT);
        relativeTXT = findViewById(R.id.RelativeTXT);
        nounTXT = findViewById(R.id.NounTXT);
        outputTXT = findViewById(R.id.outputTXT);
        genBTN = findViewById(R.id.generate);
        newMadLibBTN = findViewById(R.id.newMadLibBTN);

        //Choose a random madlib
        chosenMadLib = chooseMadLib(0);

        //Update the madlib labels to match the chosen madlib
        updateLabels(adj1TXT, adj2TXT, birdTXT, roomTXT, verb1TXT, verb2TXT, relativeTXT, nounTXT , chosenMadLib);
        genBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String i1 = String.valueOf(adj1TXT.getText());
                String i2 = String.valueOf(adj2TXT.getText());
                String i3 = String.valueOf(birdTXT.getText());
                String i4 = String.valueOf(roomTXT.getText());
                String i5 = String.valueOf(verb1TXT.getText());
                String i6 = String.valueOf(verb2TXT.getText());
                String i7 = String.valueOf(relativeTXT.getText());
                String i8 = String.valueOf(nounTXT.getText());
                outputTXT.setText(genMadLib(i1,i2,i3,i4,i5,i6,i7,i8, chosenMadLib));
            }
        });

        newMadLibBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chosenMadLib = chooseMadLib(chosenMadLib);
                updateLabels(adj1TXT, adj2TXT, birdTXT, roomTXT, verb1TXT, verb2TXT, relativeTXT, nounTXT , chosenMadLib);
                outputTXT.setText("");
            }
        });

    }


    private static String genMadLib(String i1, String i2, String i3, String i4, String i5, String i6, String i7, String i8, int madLib) {
        String output = "";
        //pulled the same madlib from my python one.
        //https://hobbylark.com/party-games/How-to-Make-Your-Own-Mad-Libs
        switch (madLib) {
            case 1:
                output = String.format("It was a %s,cold Novemeber day. " +
                        "I woke up to the %s smell of %s roasting in the %s downstairs. I %s down the stairs to see if I \n" +
                        "could help %s the dinner. \nMy mom said, 'See if %s needs a fresh %s.'", i1, i2, i3, i4, i5, i6 , i7 ,i8);
                break;
            case 2:
                output = String.format("O say can you %s by the dawn's early %s, What so %s we %s at the twilight's last gleaming, Whose broad %s and bright %s " +
                        "through the %s fight, O'er the %s we watched.", i1, i2, i3, i4, i5, i6 , i7 ,i8);
                break;
            case 3:
                //https://swantonpubliclibrary.org/sites/default/files/mad%20lib%20monster.jpg
                output = String.format("Every night before I %s to sleep, I swear I can %s noises in my closet. IT sounds like a %s %s is %s in there" +
                        "and it's so %s! When I call my mom and %s, they never %s anything.", i1, i2, i3, i4, i5, i6 , i7 ,i8);
                break;
        }
        return output;
    }

    private static int chooseMadLib(int currentMadLib) {
        Random randy = new Random();
        int newMadLib = randy.nextInt(3)+1;
        //keep generating a newMadLib so we don't have the same one as before
        while (newMadLib == currentMadLib) {
            newMadLib = randy.nextInt(3)+1;
        }

        return newMadLib;
    }

    private static void updateLabels(EditText adj1TXT, EditText adj2TXT, EditText birdTXT, EditText roomTXT, EditText verb1TXT, EditText verb2TXT, EditText relativeTXT, EditText nounTXT, int chosenMadLib) {
        //switch case. Use these in Rust a good amount.
        switch(chosenMadLib) {
            case 1:
                adj1TXT.setHint("adjective");
                adj2TXT.setHint("adjective");
                birdTXT.setHint("type of bird");
                roomTXT.setHint("room in a house");
                verb1TXT.setHint("verb (past Tense)");
                verb2TXT.setHint("verb");
                relativeTXT.setHint("relative's name");
                nounTXT.setHint("noun");
                adj1TXT.setText("");
                adj2TXT.setText("");
                birdTXT.setText("");
                roomTXT.setText("");
                verb1TXT.setText("");
                verb2TXT.setText("");
                relativeTXT.setText("");
                nounTXT.setText("");
                break;
            case 2:
                adj1TXT.setHint("verb");
                adj2TXT.setHint("noun");
                birdTXT.setHint("adverb");
                roomTXT.setHint("verb(past Tense)");
                verb1TXT.setHint("plural noun");
                verb2TXT.setHint("plural noun");
                relativeTXT.setHint("adjective");
                nounTXT.setHint("plural noun");
                adj1TXT.setText("");
                adj2TXT.setText("");
                birdTXT.setText("");
                roomTXT.setText("");
                verb1TXT.setText("");
                verb2TXT.setText("");
                relativeTXT.setText("");
                nounTXT.setText("");
                break;
            case 3:
                adj1TXT.setHint("verb");
                adj2TXT.setHint("verb");
                birdTXT.setHint("adjective");
                roomTXT.setHint("noun");
                verb1TXT.setHint("verb -ing");
                verb2TXT.setHint("adjective");
                relativeTXT.setHint("noun; relative");
                nounTXT.setHint("adjective");
                adj1TXT.setText("");
                adj2TXT.setText("");
                birdTXT.setText("");
                roomTXT.setText("");
                verb1TXT.setText("");
                verb2TXT.setText("");
                relativeTXT.setText("");
                nounTXT.setText("");
        }
    }
}
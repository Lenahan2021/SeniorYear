package com.example.a6_navdrawertest.ui.scifi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a6_navdrawertest.R;

import java.util.Random;

public class SciFiFragment extends Fragment {
    EditText firstNameTXT, lastNameTXT, cityTXT, schoolTXT, broTXT, sisTXT;
    Button generatorBTN;
    TextView output;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_scifi,container,false);

        firstNameTXT = rootView.findViewById(R.id.firstTXT);
        lastNameTXT = rootView.findViewById(R.id.lastTXT);
        cityTXT = rootView.findViewById(R.id.cityTXT);
        schoolTXT = rootView.findViewById(R.id.schoolTXT);
        broTXT = rootView.findViewById(R.id.broTXT);
        sisTXT = rootView.findViewById(R.id.sisTXT);
        output = rootView.findViewById(R.id.output);
        generatorBTN = rootView.findViewById(R.id.generator);

        generatorBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                generate();
            }
        });

        return rootView;
    }

    private void generate(){
        String first = String.valueOf(firstNameTXT.getText());
        String last = String.valueOf(lastNameTXT.getText());
        String city = String.valueOf(cityTXT.getText());
        String school = String.valueOf(schoolTXT.getText());
        String brother = String.valueOf(broTXT.getText());
        String sister = String.valueOf(sisTXT.getText());

        //generate the bounds for each portion of the variable
        Random randy = new Random();
        int rF = randy.nextInt(first.length());
        int rL = randy.nextInt(last.length());
        int rC = randy.nextInt(city.length());
        int rS = randy.nextInt(school.length());
        int rB = randy.nextInt(brother.length());
        int rSi = randy.nextInt(sister.length());

        //generate scifi first name -> first 3 letters of firstName and last 3 letters of lastName
        String sciFiFirst = first.substring(0,rF)+last.substring(rL);
        //generate scifi last name -> first 2 letters of city and last 4 letters of school
        String sciFiLast = city.substring(0,rC)+school.substring(rS);
        //generate scifi home name -> first 4 letters of brother and last 2 letters of sister
        String sciFiHome = brother.substring(0,rB)+sister.substring(rSi);

        output.setText(String.format("Welcome! %s %s from %s",sciFiFirst,sciFiLast,sciFiHome));

    }

}

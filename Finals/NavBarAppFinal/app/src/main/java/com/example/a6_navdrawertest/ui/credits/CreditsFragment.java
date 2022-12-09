package com.example.a6_navdrawertest.ui.credits;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.a6_navdrawertest.R;

public class CreditsFragment extends Fragment {

    private TextView creditsTXT, instructionsTXT;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_credits, container, false);

        creditsTXT = rootView.findViewById(R.id.creditsTXT);
        instructionsTXT = rootView.findViewById(R.id.GTNInstructions);

        instructionsTXT.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);



        String creditsText = "By: Spencer Lenahan\nSources:\nSpencer's SciFi Name Generator\nSpencer's Mad Lib Generator\nBander's Nav Drawer Notes";

        //https://stackoverflow.com/questions/432037/how-do-i-center-text-horizontally-and-vertically-in-a-textview/42945970#:~:text=Try%20this%3A,center%20attribute%20in%20your%20LinearLayout.&text=Save%20this%20answer.,-Show%20activity%20on
        creditsTXT.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        creditsTXT.setText(creditsText);
        //https://stackoverflow.com/questions/4602902/how-to-set-the-text-color-of-textview-in-code
        creditsTXT.setTextColor(Color.parseColor("#0000FF"));


        return rootView;
    }

}

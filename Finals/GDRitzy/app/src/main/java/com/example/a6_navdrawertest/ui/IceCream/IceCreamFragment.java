package com.example.a6_navdrawertest.ui.IceCream;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import com.example.a6_navdrawertest.Item;
import com.example.a6_navdrawertest.MainActivity;
import com.example.a6_navdrawertest.R;

public class IceCreamFragment extends Fragment {

    private Button ChocolateBTN, MintBTN, VanillaBTN, StrawberryBTN, CookiesCreamBTN, BirthdayBTN, ButteredPecanBTN, CookieDoughBTN,
            MooseTracksBTN,ButterscotchBTN,AddToOrderBTN, BackBTN;
    private static Spinner SizePicker;
    private static double cost;
    private static ConstraintLayout selectedIceCream;
    private static ImageView selectedIceCreamImage;
    private static TextView selectedIceCreamDes, PriceTXT, AddedToCart;
    private static String iceCreamName = "";
    private static String description = "";
    private static ScrollView IceCreams;
    private static String[] sizes = {
            "Single","Double","Triple","Shake", "Malt" , "Banana Split", "Pint", "Quart"
    };

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        //this line connects the Java to XML
        //View obj = inflater.inflate(layoutFile,where it is ran, not attached to root);
        View rootView = inflater.inflate(R.layout.fragment_icecream,container,false);

        //Linking everything
        IceCreams = rootView.findViewById(R.id.IceCreams);
        selectedIceCream = rootView.findViewById(R.id.SelectedIceCream);
        selectedIceCreamImage = rootView.findViewById(R.id.selectedIceCreamImage);
        selectedIceCreamDes = rootView.findViewById(R.id.iceCreamDescription);
        PriceTXT = rootView.findViewById(R.id.PriceTXT);

        //Flavor buttons
        ChocolateBTN = rootView.findViewById(R.id.ChocolateBTN);
        VanillaBTN = rootView.findViewById(R.id.VanillaBTN);
        StrawberryBTN = rootView.findViewById(R.id.StrawberryBTN);
        MintBTN = rootView.findViewById(R.id.MintBTN);
        CookiesCreamBTN = rootView.findViewById(R.id.CookiesandCreamBTN);
        BirthdayBTN = rootView.findViewById(R.id.BirthdayCakeBTN);
        ButteredPecanBTN = rootView.findViewById(R.id.ButteredPecanBTN);
        CookieDoughBTN = rootView.findViewById(R.id.CookieDoughBTN);
        ButterscotchBTN = rootView.findViewById(R.id.ButterscotchBTN);
        MooseTracksBTN = rootView.findViewById(R.id.MooseTracksBTN);

        SizePicker = rootView.findViewById(R.id.spinner);

        AddToOrderBTN = rootView.findViewById(R.id.AddToOrderBTN);
        BackBTN = rootView.findViewById(R.id.BackBTN);
        AddedToCart = rootView.findViewById(R.id.AddedToCart);



        IceCreams.setVisibility(View.VISIBLE);
        selectedIceCream.setVisibility(View.GONE);
        AddedToCart.setVisibility(View.INVISIBLE);


        SizePicker.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                cost = 1.00 + (.25*SizePicker.getSelectedItemPosition());
                PriceTXT.setText(String.format("$%s", cost));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        BackBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IceCreams.setVisibility(View.VISIBLE);
                selectedIceCream.setVisibility(View.GONE);
                AddedToCart.setVisibility(View.INVISIBLE);
            }
        });

        AddToOrderBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Item iceCream = new Item(String.format("%s %s Ice cream", SizePicker.getSelectedItem().toString(), iceCreamName), cost);
                MainActivity.cart.add(iceCream);
                AddedToCart.setText(String.format("%s %s Ice cream", SizePicker.getSelectedItem().toString(), iceCreamName) + " added to order");
                AddedToCart.setVisibility(View.VISIBLE);
            }
        });

        //Setting the buttons to display the right names and descriptions
        ChocolateBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Chocolate");
            }
        });

        VanillaBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Vanilla");
            }
        });

        StrawberryBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Strawberry");
            }
        });

        MintBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Mint");
            }
        });

        CookiesCreamBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Cookies & Cream");
            }
        });

        BirthdayBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Birthday Cake");
            }
        });

        ButteredPecanBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Buttered Pecan");
            }
        });

        MooseTracksBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Moose Tracks");
            }
        });

        ButterscotchBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Butterscotch");
            }
        });

        CookieDoughBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DisplayIceCream("Cookie Dough");
            }
        });


        //connect the widgets
        //findViewById is a method from the View class -> activities don't need a view obj
        //  fragments do because they aren't activities
        return rootView;
    }


    public static void DisplayIceCream(String name) {
        IceCreams.setVisibility(View.GONE);
        selectedIceCream.setVisibility(View.VISIBLE);

        //update price
        cost = 1.00 + (.25*SizePicker.getSelectedItemPosition());

        PriceTXT.setText(String.format("$%s", cost));

        iceCreamName = name;
        description = "Our award winning "+iceCreamName+" ice cream is sure to cool you down on a hot summer day.\nMade with love in mind and our freshest ingredients, we are sure this will not disappoint";

        switch (iceCreamName) {
            case "Chocolate":
                selectedIceCreamImage.setImageResource(R.drawable.chocolate);
                selectedIceCreamDes.setText(description);
                break;
            case "Vanilla":
                selectedIceCreamImage.setImageResource(R.drawable.vanilla);
                selectedIceCreamDes.setText(description);
                break;
            case "Strawberry":
                selectedIceCreamImage.setImageResource(R.drawable.strawberry);
                selectedIceCreamDes.setText(description);
                break;
            case "Mint":
                selectedIceCreamImage.setImageResource(R.drawable.mint);
                selectedIceCreamDes.setText(description);
                break;
            case "Cookies & Cream":
                selectedIceCreamImage.setImageResource(R.drawable.cookiescream);
                selectedIceCreamDes.setText(description);
                break;
            case "Birthday Cake":
                selectedIceCreamImage.setImageResource(R.drawable.birthdaycake);
                selectedIceCreamDes.setText(description);
                break;
            case "Buttered Pecan":
                selectedIceCreamImage.setImageResource(R.drawable.butteredpecan);
                selectedIceCreamDes.setText(description);
                break;
            case "Cookie Dough":
                selectedIceCreamImage.setImageResource(R.drawable.cookiedough);
                selectedIceCreamDes.setText(description);
                break;
            case "Butterscotch":
                selectedIceCreamImage.setImageResource(R.drawable.butterscotch);
                selectedIceCreamDes.setText(description);
                break;
            case "Moose Tracks":
                selectedIceCreamImage.setImageResource(R.drawable.moosetracks);
                selectedIceCreamDes.setText(description);
                break;
        }
    }
}
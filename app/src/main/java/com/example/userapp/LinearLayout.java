package com.example.userapp;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.userapp.databinding.ActivityLinearLayoutBinding;
import com.example.userapp.databinding.VariantItemBinding;

import java.util.Arrays;
import java.util.List;

import Models.Variant;

public class LinearLayout extends AppCompatActivity {

    ActivityLinearLayoutBinding b;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        b = ActivityLinearLayoutBinding.inflate(getLayoutInflater());
        setContentView(b.getRoot());

        showVariants();


    }

    private void showVariants() {

        List<Variant> variants = Arrays.asList(

                new Variant("1kg", 10),
                new Variant("2kg", 60)

        );


        for(Variant variant : variants){


            VariantItemBinding vb = VariantItemBinding.inflate(getLayoutInflater());
            vb.variantName.setText(variant.nameString());

            b.list.addView(vb.getRoot());


        }



    }
}
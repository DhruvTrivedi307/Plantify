package com.example.plantify;

import android.annotation.SuppressLint;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.plantify.databinding.ActivityFilterBinding;

public class filter extends AppCompatActivity {

    TextView plants,size,price,i_o;

    FragmentTransaction ft;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_filter);

        plants = findViewById(R.id.plants);
        size = findViewById(R.id.size);
        price = findViewById(R.id.price);
        i_o = findViewById(R.id.i_o);

        plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_plants());
                ft.commit();
            }
        });

    }

}
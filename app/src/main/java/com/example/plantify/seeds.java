package com.example.plantify;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class seeds extends AppCompatActivity {

    LinearLayout s_amaranths,s_beetroots,s_broccolis,s_capsicums,s_corianders,s_fenugreek,s_greenchilli,s_greencucumber,s_okras,s_redamaranthus,s_spinch,s_tomatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_seeds);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        s_amaranths = findViewById(R.id.s_amaranths);
        s_beetroots = findViewById(R.id.s_beetroots);
        s_broccolis = findViewById(R.id.s_broccolis);
        s_capsicums = findViewById(R.id.s_capsicums);
        s_corianders = findViewById(R.id.s_corianders);
        s_fenugreek = findViewById(R.id.s_fenugreeks);
        s_greenchilli = findViewById(R.id.s_greenchillis);
        s_greencucumber = findViewById(R.id.s_greencucumbers);
        s_okras = findViewById(R.id.s_okras);
        s_redamaranthus = findViewById(R.id.s_redamaranthuss);
        s_spinch = findViewById(R.id.s_spinchs);
        s_tomatos = findViewById(R.id.s_tomatos);
        
        s_amaranths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Jade Mini Plant";
                int price = 499;
                RedirectProduct(R.drawable.amaranth_seeds,"Amaranth Seeds",499);
            }
        });

        s_beetroots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.beetroot_seeds,"Beetroot Seeds",99);
            }
        });

        s_broccolis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.broccoli_seeds,"Broccoli Seeds",129);
            }
        });

        s_capsicums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.capsicum_seeds,"Capsicum Seeds",99);
            }
        });

        s_corianders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.coriander_seeds,"Coriander Seeds",139);
            }
        });

        s_fenugreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.fenugreek_seeds,"Fenugreek Seeds",99);
            }
        });

        s_greenchilli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.green_chilli_seed,"Green Chilli Seeds",99);
            }
        });

        s_greencucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.green_cucumber_seeds,"Green Cucumber Seeds",99);
            }
        });

        s_okras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.okra_seeds,"Okra Seeds",119);
            }
        });

        s_redamaranthus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.red_amaranthus_seeds,"Red Amaranthus Seeds",99);
            }
        });

        s_spinch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.spinach_seeds,"Spinch Seeds",99);
            }
        });

        s_tomatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.tomato_seeds,"Tomato Seeds",79);
            }
        });
    }

    public void RedirectProduct(int imageResId,String name, int price){
        Intent intent = new Intent(getApplicationContext(), product.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        startActivity(intent);
    }
}
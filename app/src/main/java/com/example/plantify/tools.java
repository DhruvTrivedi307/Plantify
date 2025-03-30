package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tools extends AppCompatActivity {

    LinearLayout dmm, hwp, dpw, fpw, cps, pis, ss, ws;
    AppCompatButton dmm_cart_click, hwp_cart_click, dpw_cart_click, fpw_cart_click, cps_cart_click, pis_cart_click, ss_cart_click, ws_cart_click;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        dmm = findViewById(R.id.dmm);
        hwp = findViewById(R.id.hwp);
        dpw = findViewById(R.id.dpw);
        fpw = findViewById(R.id.fpw);
        cps = findViewById(R.id.cps);
        pis = findViewById(R.id.pis);
        ss = findViewById(R.id.ss);
        ws = findViewById(R.id.ws);
        dmm_cart_click = findViewById(R.id.dmm_cart_click);
        hwp_cart_click = findViewById(R.id.hwp_cart_click);
        dpw_cart_click = findViewById(R.id.dpw_cart_click);
        fpw_cart_click = findViewById(R.id.fpw_cart_click);
        cps_cart_click = findViewById(R.id.cps_cart_click);
        pis_cart_click = findViewById(R.id.pis_cart_click);
        ss_cart_click = findViewById(R.id.ss_cart_click);
        ws_cart_click = findViewById(R.id.ws_cart_click);

        dmm.setOnClickListener(v -> {
            String name = "Dom Metallic Mister";
            int price = 859;
            RedirectProduct(R.drawable.dom_metallic_mister,name,price);
        });

        hwp.setOnClickListener(v -> {
            String name = "Hydra Watering Pitcher";
            int price = 399;
            RedirectProduct(R.drawable.hydra_watering_pitcher,name,price);
        });

        dpw.setOnClickListener(v -> {
            String name = "Double Prong Weeder";
            int price = 399;
            RedirectProduct(R.drawable.double_prong_weeder,name,price);
        });

        fpw.setOnClickListener(v -> {
            String name = "Five Prong Weeder";
            int price = 969;
            RedirectProduct(R.drawable.five_prong_weeder,name,price);
        });

        cps.setOnClickListener(v -> {
            String name = "Curve Pruning Saw - 33 Cm";
            int price = 599;
            RedirectProduct(R.drawable.curve_pruning_saw,name,price);
        });

        pis.setOnClickListener(v -> {
            String name = "Plastic Impulse Sprinkler";
            int price = 879;
            RedirectProduct(R.drawable.plastic_impulse_sprinkler,name,price);
        });

        ss.setOnClickListener(v -> {
            String name = "Sprinkler Stand";
            int price = 839;
            RedirectProduct(R.drawable.sprinkler_stand,name,price);
        });

        ws.setOnClickListener(v -> {
            String name = "Watermatic Stack";
            int price = 299;
            RedirectProduct(R.drawable.watermatic_stake,name,price);
        });

        dmm_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        hwp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        dpw_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        fpw_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        cps_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        pis_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        ss_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        ws_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

    }

    public void RedirectProduct(int imageResId,String name, int price){
        Intent intent = new Intent(getApplicationContext(), product_explore.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        startActivity(intent);
    }

    public void onCartClick() {
        Intent intent = new Intent(getApplicationContext(), cart.class);
        startActivity(intent);
    }

}
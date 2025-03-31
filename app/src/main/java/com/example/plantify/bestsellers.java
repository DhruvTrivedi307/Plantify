package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bestsellers extends AppCompatActivity {

    LinearLayout b_lbp, b_fbp, b_pp, b_bwp, b_jmp, b_mpg, b_bhp, b_plp;
    AppCompatButton b_lbp_cart_click, b_fbp_cart_click, b_pp_cart_click, b_bwp_cart_click, b_jmp_cart_click, b_mpg_cart_click, b_bhp_cart_click;
    ImageView cart_icon,search_icon;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestsellers);

        b_lbp = findViewById(R.id.b_lbp);
        b_fbp = findViewById(R.id.b_fbp);
        b_pp = findViewById(R.id.b_pp);
        b_bwp = findViewById(R.id.b_bwp);
        b_jmp = findViewById(R.id.b_jmp);
        b_mpg = findViewById(R.id.b_mpg);
        b_bhp = findViewById(R.id.b_bhp);
        b_plp = findViewById(R.id.b_plp);

        b_lbp_cart_click = findViewById(R.id.b_lbp_cart_click);
        b_fbp_cart_click = findViewById(R.id.b_fbp_cart_click);
        b_pp_cart_click = findViewById(R.id.b_pp_cart_click);
        b_bwp_cart_click = findViewById(R.id.b_bwp_cart_click);
        b_jmp_cart_click = findViewById(R.id.b_jmp_cart_click);
        b_mpg_cart_click = findViewById(R.id.b_mpg_cart_click);
        b_bhp_cart_click = findViewById(R.id.b_bhp_cart_click);

        cart_icon = findViewById(R.id.cart_icon);
        search_icon = findViewById(R.id.search_icon);

        b_lbp.setOnClickListener(v -> {
            String name = "Lucky Bamboo Plant";
            int price = 499;
            RedirectProduct(R.drawable.lucky_bamboo_plant,name,price);
        });

        b_fbp.setOnClickListener(v -> {
            String name = "Ficus Bonsai Plant";
            int price = 499;
            RedirectProduct(R.drawable.ficus_bonsai_plant,name,price);
        });

        b_pp.setOnClickListener(v -> {
            String name = "Peacock Plant";
            int price = 499;
            RedirectProduct(R.drawable.peacock_plant,name,price);
        });

        b_bwp.setOnClickListener(v -> {
            String name = "Bamboo Palm Plant";
            int price = 499;
            RedirectProduct(R.drawable.brazilian_wood_plant,name,price);
        });

        b_jmp.setOnClickListener(v -> {
            String name = "Jade Plant Mini";
            int price = 499;
            RedirectProduct(R.drawable.jade_mini_plats,name,price);
        });

        b_mpg.setOnClickListener(v -> {
            String name = "Money Plant Golden";
            int price = 499;
            RedirectProduct(R.drawable.money_plant_golden,name,price);
        });

        b_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 499;
            RedirectProduct(R.drawable.broken_heart_plant_2,name,price);
        });

        b_plp.setOnClickListener(v -> {
            String name = "Peace Lily Plant";
            int price = 499;
            RedirectProduct(R.drawable.peace_lily_plant,name,price);
        });

        b_lbp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        b_fbp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        b_pp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        b_bwp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        b_jmp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        b_mpg_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        b_bhp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        search_icon.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),search.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });

        cart_icon.setOnClickListener(v -> {
            Intent i = new Intent(getApplicationContext(),cart.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
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
package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class shop extends AppCompatActivity {

    BottomNavigationView bnv;
    LinearLayout h_bhp, h_jmp, h_plp, h_fbp, h_lbp, h_stp, h_pgp, h_mpg, h_pp, h_bwp, h_arp, h_apbp, h_bpx, h_bpp, h_flp, h_vjmp;
    AppCompatButton h_bhp_cart_click, h_jmp_cart_click, h_plp_cart_click, h_fbp_cart_click, h_lbp_cart_click, h_stp_cart_click, h_pgp_cart_click, h_mpg_cart_click, h_pp_cart_click, h_bwp_cart_click, h_arp_cart_click, h_apbp_cart_click, h_bpx_cart_click, h_bpp_cart_click, h_flp_cart_click, h_vjmp_cart_click;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        bnv = findViewById(R.id.bnv);
        h_bhp = findViewById(R.id.h_bhp);
        h_jmp = findViewById(R.id.h_jmp);
        h_plp = findViewById(R.id.h_plp);
        h_fbp = findViewById(R.id.h_fbp);
        h_lbp = findViewById(R.id.h_lbp);
        h_stp = findViewById(R.id.h_stp);
        h_pgp = findViewById(R.id.h_pgp);
        h_mpg = findViewById(R.id.h_mpg);
        h_pp = findViewById(R.id.h_pp);
        h_bwp = findViewById(R.id.h_bwp);
        h_arp = findViewById(R.id.h_arp);
        h_apbp = findViewById(R.id.h_apbp);
        h_bpx = findViewById(R.id.h_bpx);
        h_bpp = findViewById(R.id.h_bpp);
        h_flp = findViewById(R.id.h_flp);
        h_vjmp = findViewById(R.id.h_vjmp);
        h_bhp_cart_click = findViewById(R.id.h_bhp_cart_click);
        h_jmp_cart_click = findViewById(R.id.h_jpm_cart_click);
        h_plp_cart_click = findViewById(R.id.h_plp_cart_click);
        h_fbp_cart_click = findViewById(R.id.h_fbp_cart_click);
        h_lbp_cart_click = findViewById(R.id.h_lbp_cart_click);
        h_stp_cart_click = findViewById(R.id.h_stp_cart_click);
        h_pgp_cart_click = findViewById(R.id.h_pgp_cart_click);
        h_mpg_cart_click = findViewById(R.id.h_mpg_cart_click);
        h_pp_cart_click = findViewById(R.id.h_pp_cart_click);
        h_bwp_cart_click = findViewById(R.id.h_bwp_cart_click);
        h_arp_cart_click = findViewById(R.id.h_arp_cart_click);
        h_apbp_cart_click = findViewById(R.id.h_apbp_cart_click);
        h_bpx_cart_click = findViewById(R.id.h_bpx_cart_click);
        h_bpp_cart_click = findViewById(R.id.h_bpp_cart_click);
        h_flp_cart_click = findViewById(R.id.h_flp_cart_click);
        h_vjmp_cart_click = findViewById(R.id.h_vjmp_cart_click);

        h_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 299;
            RedirectProduct(R.drawable.broken_heart_plant_2,name,price);
        });

        h_jmp.setOnClickListener(v -> {
            String name = "Jade Plant Mini";
            int price = 279;
            RedirectProduct(R.drawable.jade_mini_plats,name,price);
        });

        h_plp.setOnClickListener(v -> {
            String name = "Peace Lily Plant";
            int price = 299;
            RedirectProduct(R.drawable.peace_lily_plant,name,price);
        });

        h_fbp.setOnClickListener(v -> {
            String name = "Ficus Bonsai Plant";
            int price = 949;
            RedirectProduct(R.drawable.ficus_bonsai_plant,name,price);
        });

        h_lbp.setOnClickListener(v -> {
            String name = "Lucky bamboo Plant";
            int price = 349;
            RedirectProduct(R.drawable.lucky_bamboo_plant,name,price);
        });

        h_stp.setOnClickListener(v -> {
            String name = "Stormanthe Triostar Plant";
            int price = 349;
            RedirectProduct(R.drawable.stromanthe_triostar_plant,name,price);
        });

        h_pgp.setOnClickListener(v -> {
            String name = "Peperomia Green Plant";
            int price = 279;
            RedirectProduct(R.drawable.peperomia_green_plant,name,price);
        });

        h_mpg.setOnClickListener(v -> {
            String name = "Money Plant Golden";
            int price = 279;
            RedirectProduct(R.drawable.money_plant_golden,name,price);
        });

        h_pp.setOnClickListener(v -> {
            String name = "Peacock Plant";
            int price = 699;
            RedirectProduct(R.drawable.peacock_plant,name,price);
        });

        h_bwp.setOnClickListener(v -> {
            String name = "Brazilian Wood Plant";
            int price = 499;
            RedirectProduct(R.drawable.brazilian_wood_plant,name,price);
        });

        h_arp.setOnClickListener(v -> {
            String name = "Aglaonema Red Plant";
            int price = 749;
            RedirectProduct(R.drawable.aglaonema_red_plant,name,price);
        });

        h_apbp.setOnClickListener(v -> {
            String name = "Aglaonema Pink Beauty Plant";
            int price = 714;
            RedirectProduct(R.drawable.aglaonema_pink_beauty_plant,name,price);
        });

        h_bpx.setOnClickListener(v -> {
            String name = "Bamboo Palm XL";
            int price = 857;
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price);
        });

        h_bpp.setOnClickListener(v -> {
            String name = "Bamboo Palm Plant";
            int price = 399;
            RedirectProduct(R.drawable.bamboo_palm_plant,name,price);
        });

        h_flp.setOnClickListener(v -> {
            String name = "Fiddle Leaf Fig Plant";
            int price = 1199;
            RedirectProduct(R.drawable.fiddle_leaf_fig_plant,name,price);
        });

        h_vjmp.setOnClickListener(v -> {
            String name = "Variegated Jade Mini Plant";
            int price = 299;
            RedirectProduct(R.drawable.variegated_jade_mini_plant,name,price);
        });

        h_bhp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_jmp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_plp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_fbp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_lbp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_stp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_pgp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_mpg_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_pp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_bwp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_arp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_apbp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_bpx_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_bpp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_flp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        h_vjmp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        bnv.setSelectedItemId(R.id.shop);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Intent i = new Intent(getApplicationContext(), home.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                } else if (item.getItemId() == R.id.trending) {
                    Intent i = new Intent(getApplicationContext(), Trending.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    Intent i = new Intent(getApplicationContext(), profile_signin.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                }
                return true;
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

    public void onCartClick() {
        Intent intent = new Intent(getApplicationContext(), cart.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.fade_out);
    }
}
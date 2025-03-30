package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class home extends AppCompatActivity {

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private ViewPager2 vp;
    BottomNavigationView bnv;
    int currentPage = 0;
    RadioGroup rg;
    ImageView search_icon,cart_icon;
    LinearLayout tools,bestsellers,easy_to_care,pots,seeds;

    ImageView h_bhp,h_jmp,h_bwp,h_pp;

    Button viewAll;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vp = findViewById(R.id.vp);
        bnv = findViewById(R.id.bnv);
        tools = findViewById(R.id.tools);
        bestsellers = findViewById(R.id.bestsellers);
        easy_to_care = findViewById(R.id.easy_to_care);
        pots = findViewById(R.id.pots);
        seeds = findViewById(R.id.seeds);

        h_bhp = findViewById(R.id.h_bhp);
        h_jmp = findViewById(R.id.h_jmp);
        h_bwp = findViewById(R.id.h_bwp);
        h_pp = findViewById(R.id.h_pp);
        viewAll = findViewById(R.id.viewAll);

        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),shop.class);
                startActivity(i);
            }
        });

        h_bhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Broken Heart Plant";
                int price = 499;
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.broken_heart_plant_2);
                i.putExtra("name",name);
                i.putExtra("price",price);
                startActivity(i);
            }
        });

        h_jmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Jade Mini Plant";
                int price = 499;
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.jade_mini_plats);
                i.putExtra("name",name);
                i.putExtra("price",price);
                startActivity(i);
            }
        });

        h_bwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Brazilian Wood Plant";
                int price = 499;
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.brazilian_wood_plant);
                i.putExtra("name",name);
                i.putExtra("price",price);
                startActivity(i);
            }
        });

        h_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Peacock Plant";
                int price = 499;
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.peacock_plant);
                i.putExtra("name",name);
                i.putExtra("price",price);
                startActivity(i);
            }
        });

        List<Integer> imgs = Arrays.asList(
                R.drawable.carousel_img_1,
                R.drawable.carousel_img_2,
                R.drawable.carousel_img_1,
                R.drawable.carousel_img_2,
                R.drawable.carousel_img_1
        );

        CarouselAdapter c = new CarouselAdapter(this, imgs);
        vp.setAdapter(c);

        TextView priceText = findViewById(R.id.priceText);
        priceText.setPaintFlags(priceText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView priceText2 = findViewById(R.id.priceText2);
        priceText2.setPaintFlags(priceText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == c.getItemCount()) {
                    currentPage = 0;
                }
                vp.setCurrentItem(currentPage++, true);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        search_icon = findViewById(R.id.search_icon);
        cart_icon = findViewById(R.id.cart_icon);

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

        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), tools.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        bestsellers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), bestsellers.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        easy_to_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), easy_to_care.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), seeds.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        pots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), pots.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        bnv.setSelectedItemId(R.id.home);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.shop) {
                    Intent i = new Intent(getApplicationContext(), shop.class);
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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.fade_out);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
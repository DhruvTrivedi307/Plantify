package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class bestsellers extends AppCompatActivity {

    LinearLayout main,filter;
    LinearLayout b_lbp, b_fbp, b_pp, b_bwp, b_jmp, b_mpg, b_bhp, b_plp;
    AppCompatButton b_lbp_cart_click, b_fbp_cart_click, b_pp_cart_click, b_bwp_cart_click, b_jmp_cart_click, b_mpg_cart_click, b_bhp_cart_click,b_plp_cart_click;
    ImageView cart_icon,search_icon;
    TextView not_avail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bestsellers);

        Intent intent = getIntent();
        boolean airPlants = intent.getBooleanExtra("air_plants", false);
        boolean floweringPlants = intent.getBooleanExtra("flowering_plants", false);
        boolean climbers = intent.getBooleanExtra("climbers", false);
        float minPrice = intent.getFloatExtra("min_price", 100f);
        float maxPrice = intent.getFloatExtra("max_price", 2000f);

        main = findViewById(R.id.main);
        filter = findViewById(R.id.filter);

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
        b_plp_cart_click = findViewById(R.id.b_plp_cart_click);

        cart_icon = findViewById(R.id.cart_icon);
        search_icon = findViewById(R.id.search_icon);

        not_avail = findViewById(R.id.not_avail);

        boolean hasFilter = airPlants || floweringPlants || climbers || minPrice > 100f || maxPrice < 2000f;

        if (hasFilter) {
            b_lbp.setVisibility(View.GONE);
            b_fbp.setVisibility(View.GONE);
            b_pp.setVisibility(View.GONE);
            b_bwp.setVisibility(View.GONE);
            b_jmp.setVisibility(View.GONE);
            b_mpg.setVisibility(View.GONE);
            b_bhp.setVisibility(View.GONE);
            b_plp.setVisibility(View.GONE);

            if (isPriceInRange(349, minPrice, maxPrice) && (airPlants || !airPlants && !floweringPlants && !climbers)) b_lbp.setVisibility(View.VISIBLE);
            if (isPriceInRange(349, minPrice, maxPrice) && (airPlants || !airPlants && !floweringPlants && !climbers)) b_fbp.setVisibility(View.VISIBLE);
            if (isPriceInRange(699, minPrice, maxPrice) && (climbers || !airPlants && !floweringPlants && !climbers)) b_pp.setVisibility(View.VISIBLE);
            if (isPriceInRange(689, minPrice, maxPrice) && (climbers || !airPlants && !floweringPlants && !climbers)) b_bwp.setVisibility(View.VISIBLE);
            if (isPriceInRange(279, minPrice, maxPrice) && (floweringPlants || !airPlants && !floweringPlants && !climbers)) b_jmp.setVisibility(View.VISIBLE);
            if (isPriceInRange(279, minPrice, maxPrice) && (floweringPlants || !airPlants && !floweringPlants && !climbers)) b_mpg.setVisibility(View.VISIBLE);
            if (isPriceInRange(299, minPrice, maxPrice) && (airPlants || !airPlants && !floweringPlants && !climbers)) b_bhp.setVisibility(View.VISIBLE);
            if (isPriceInRange(299, minPrice, maxPrice) && (floweringPlants || !airPlants && !floweringPlants && !climbers)) b_plp.setVisibility(View.VISIBLE);
        }

        b_lbp.setOnClickListener(v -> {
            String name = "Lucky Bamboo Plant";
            int price = 349;
            RedirectProduct(R.drawable.lucky_bamboo_plant,name,price);
        });

        b_fbp.setOnClickListener(v -> {
            String name = "Ficus Bonsai Plant";
            int price = 349;
            RedirectProduct(R.drawable.ficus_bonsai_plant,name,price);
        });

        b_pp.setOnClickListener(v -> {
            String name = "Peacock Plant";
            int price = 699;
            RedirectProduct(R.drawable.peacock_plant,name,price);
        });

        b_bwp.setOnClickListener(v -> {
            String name = "Bamboo Palm Plant";
            int price = 689;
            RedirectProduct(R.drawable.brazilian_wood_plant,name,price);
        });

        b_jmp.setOnClickListener(v -> {
            String name = "Jade Plant Mini";
            int price = 279;
            RedirectProduct(R.drawable.jade_mini_plats,name,price);
        });

        b_mpg.setOnClickListener(v -> {
            String name = "Money Plant Golden";
            int price = 279;
            RedirectProduct(R.drawable.money_plant_golden,name,price);
        });

        b_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 299;
            RedirectProduct(R.drawable.broken_heart_plant_2,name,price);
        });

        b_plp.setOnClickListener(v -> {
            String name = "Peace Lily Plant";
            int price = 299;
            RedirectProduct(R.drawable.peace_lily_plant,name,price);
        });


        b_lbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.lucky_bamboo_plant,"Lucky Bamboo Plant","Small",349,1);
        });

        b_fbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.ficus_bonsai_plant,"Ficus Bonsai Plant","Small",349,1);
        });

        b_pp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peacock_plant,"Peacock Plant","Small",699,1);
        });

        b_bwp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.brazilian_wood_plant,"Brazilian Wood Plant","Small",689,1);
        });

        b_jmp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.jade_mini_plats,"Jade Mini Plant","Small",279,1);
        });

        b_mpg_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.money_plant_golden,"Money Golden Plant","Small",279,1);
        });

        b_bhp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.broken_heart_plant_2,"Broken Heart Plant","Small",299,1);
        });

        b_plp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peace_lily_plant,"Peace Lily Plant","Small",299,1);
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

        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(bestsellers.this,filter_type_of_plants.class);
                i.putExtra("page",bestsellers.class.getName());
                startActivity(i);
            }
        });

        if (b_lbp.getVisibility() == View.GONE && b_fbp.getVisibility() == View.GONE && b_pp.getVisibility() == View.GONE && b_bwp.getVisibility() == View.GONE && b_jmp.getVisibility() == View.GONE && b_mpg.getVisibility() == View.GONE && b_bhp.getVisibility() == View.GONE && b_plp.getVisibility() == View.GONE) {
            not_avail.setVisibility(View.VISIBLE);
        } else {
            not_avail.setVisibility(View.GONE);
        }

    }

    private boolean isPriceInRange(int price, float min, float max) {
        return price >= min && price <= max;
    }

    private boolean shouldShowPlant(boolean categoryCondition, int price, float min, float max) {
        return categoryCondition && isPriceInRange(price, min, max);
    }


    public void RedirectProduct(int imageResId,String name, int price){
        Intent intent = new Intent(getApplicationContext(), product.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        startActivity(intent);
    }

    public void onCartClick(int img,String name,String size, int price,int qty) {
        main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
        Intent intent = new Intent(getApplicationContext(), cart.class);
        intent.putExtra("img",img);
        intent.putExtra("name",name);
        intent.putExtra("size",size);
        intent.putExtra("price",price);
        intent.putExtra("qty",qty);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(bestsellers.this, home.class));
    }
}
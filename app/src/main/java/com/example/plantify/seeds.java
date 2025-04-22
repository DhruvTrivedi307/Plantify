package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class seeds extends AppCompatActivity {

    LinearLayout main,filter;
    LinearLayout s_amaranths,s_beetroots,s_broccolis,s_capsicums,s_corianders,s_fenugreek,s_greenchilli,s_greencucumber,s_okras,s_redamaranthus,s_spinch,s_tomatos;
    AppCompatButton s_amaranths_cart_click, s_beetroots_cart_click, s_broccolis_cart_click, s_capsicums_cart_click, s_corianders_cart_click, s_fenugreek_cart_click, s_greenchilli_cart_click, s_greencucumber_cart_click, s_okras_cart_click, s_redamaranthus_cart_click, s_spinch_cart_click, s_tomatos_cart_click;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seeds);

        main = findViewById(R.id.main);
        filter = findViewById(R.id.filter);

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

        s_amaranths_cart_click = findViewById(R.id.s_amaranths_cart_click);
        s_beetroots_cart_click = findViewById(R.id.s_beetroots_cart_click);
        s_broccolis_cart_click = findViewById(R.id.s_broccolis_cart_click);
        s_capsicums_cart_click = findViewById(R.id.s_capsicums_cart_click);
        s_corianders_cart_click = findViewById(R.id.s_corianders_cart_click);
        s_fenugreek_cart_click = findViewById(R.id.s_fenugreek_cart_click);
        s_greenchilli_cart_click = findViewById(R.id.s_greenchillis_cart_click);
        s_greencucumber_cart_click = findViewById(R.id.s_greencucumbers_cart_click);
        s_okras_cart_click = findViewById(R.id.s_okras_cart_click);
        s_redamaranthus_cart_click = findViewById(R.id.s_redamaranthuss_cart_click);
        s_spinch_cart_click = findViewById(R.id.s_spinchs_cart_click);
        s_tomatos_cart_click = findViewById(R.id.s_tomatos_cart_click);
        
        s_amaranths_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.amaranth_seeds,"Amaranth Seeds",499,"Small",1);
        });
        s_beetroots_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.beetroot_seeds,"Beetroot Seeds",99,"Small",1);
        });
        s_broccolis_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.broccoli_seeds,"Broccoli Seeds",129,"Small",1);
        });
        s_capsicums_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.capsicum_seeds,"Capsicum Seeds",99,"Small",1);
        });
        s_corianders_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.coriander_seeds,"Coriander Seeds",99,"Small",1);
        });
        s_fenugreek_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.fenugreek_seeds,"Fenugreek Seed",99,"Small",1);
        });
        s_greenchilli_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.green_chilli_seed,"Green Chilli Seed",99,"Small",1);
        });
        s_greencucumber_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.green_cucumber_seeds,"Green Cucumber Seeds",99,"Small",1);
        });
        s_okras_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.okra_seeds,"Okra Seeds",119,"Small",1);
        });
        s_redamaranthus_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.red_amaranthus_seeds,"Red Amaranthus Seeds",99,"Small",1);
        });
        s_spinch_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.spinach_seeds,"Spinch Seeds",99,"Small",1);
        });
        s_tomatos_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.tomato_seeds,"Tomato Seeds",79,"Small",1);
        });

        s_amaranths.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Amaranth Seeds";
                int price = 499;
                String description = "Amaranth is known for its rapid growth, quick rejuvenation after each harvest, and high yield in a short time. It is highly efficient at photosynthesis and thrives even in adverse environmental conditions.";
                RedirectProduct(R.drawable.amaranth_seeds,name,price,description);
            }
        });

        s_beetroots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Beetroot Seeds";
                int price = 499;
                String description = "These open-pollinated, 100% organic seeds are designed to provide authentic taste and superior quality harvests compared to commonly found seeds.";
                RedirectProduct(R.drawable.beetroot_seeds,name,price,description);
            }
        });

        s_broccolis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Broccoli Seeds";
                int price = 499;
                String description = "Broccoli is relatively easy to grow and can thrive in various climates. As a cool-season crop, it’s ideal for fall or early spring planting, yielding a bountiful harvest with minimal care in just a few months.";
                RedirectProduct(R.drawable.broccoli_seeds,name,price,description);
            }
        });

        s_capsicums.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Capsicum Seeds";
                int price = 499;
                String description = "Capsicum plants take approximately 55-60 days from seed to harvest-ready peppers. They sprout in 14-18 days, grow steadily, and begin flowering in about two months. With proper care—including ample sunlight, water, and regular feeding—you’ll have vibrant, crunchy capsicums ready to pick.";
                RedirectProduct(R.drawable.capsicum_seeds,name,price,description);
            }
        });

        s_corianders.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Coriander Seeds";
                int price = 499;
                String description = "Coriander seeds contain two seeds within one shell. Gently crushing them before planting helps them split and sprout faster, leading to improved germination.";
                RedirectProduct(R.drawable.coriander_seeds,name,price,description);
            }
        });

        s_fenugreek.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Fenugreek Seeds";
                int price = 499;
                String description = "Fenugreek seeds are tiny powerhouses packed with benefits, including aiding digestion, controlling blood sugar, and enhancing hair and skin health. They are commonly used in various culinary dishes and traditional remedies.";
                RedirectProduct(R.drawable.fenugreek_seeds,name,price,description);
            }
        });

        s_greenchilli.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Green Chilli Seeds";
                int price = 499;
                String description = "Green chilli is one of the easiest and most rewarding plants to grow in a kitchen garden. They can be added to curries, made into spice mixes, or pickled. Green chillies are also a great source of Vitamin A.";
                RedirectProduct(R.drawable.green_chilli_seed,name,price,description);
            }
        });

        s_greencucumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Green Cucumber Seeds";
                int price = 499;
                String description = "Cucumbers are packed with vitamins and minerals, making them excellent for cooling the body and increasing hydration due to their high water content. The ideal growing medium for cucumber seeds is a mix of two parts garden soil and one part organic manure or a combination of garden soil, coco peat, and vermicompost.";
                RedirectProduct(R.drawable.green_cucumber_seeds,name,price,description);
            }
        });

        s_okras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Okra Seeds";
                int price = 499;
                String description = "Okra is valued for its high content of magnesium, fiber, antioxidants, and vitamins. Including okra in your diet can promote a feeling of fullness due to its fiber content, improve digestion, and boost immunity through its vital nutrients.";
                RedirectProduct(R.drawable.okra_seeds,name,price,description);
            }
        });

        s_redamaranthus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Red Amaranth Seeds";
                int price = 499;
                String description = "Red Amaranth is notable for its rapid growth, quick rejuvenation after each harvest, and high yield in a short period. It is highly efficient at photosynthesis and performs well even under adverse environmental conditions.";
                RedirectProduct(R.drawable.red_amaranthus_seeds,name,price,description);
            }
        });

        s_spinch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Spinch Seeds";
                int price = 499;
                String description = "Spinach seeds yield plants rich in vitamins and minerals, including vitamins A, C, and K, as well as iron, calcium, and potassium.";
                RedirectProduct(R.drawable.spinach_seeds,name,price,description);
            }
        });

        s_tomatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Tomato Seeds";
                int price = 499;
                String description = "Tomatoes are fragrant, edible berries packed with Vitamin C, fiber, Vitamin A, calcium, and many other important antioxidants.";
                RedirectProduct(R.drawable.tomato_seeds,name,price,description);
            }
        });

        ImageView search_icon = findViewById(R.id.search_icon);
        ImageView cart_icon = findViewById(R.id.cart_icon);

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
                Intent i = new Intent(seeds.this,filter_type_of_plants.class);
                i.putExtra("page",seeds.class.getName());
                startActivity(i);
            }
        });

    }

    public void RedirectProduct(int imageResId,String name, int price, String description){
        Intent intent = new Intent(getApplicationContext(), product.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("description", description);
        startActivity(intent);
    }

    public boolean onCartClick(int img, String name, int price, String size, int qty) {
        main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
        Intent intent = new Intent(getApplicationContext(), cart.class);
        intent.putExtra("img", img);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("qty", qty);
        intent.putExtra("size", size);
        startActivity(intent);
        return true;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
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

public class easy_to_care extends AppCompatActivity {

    LinearLayout main;
    LinearLayout e_apbp, e_bpp, e_bpx, e_arp, e_flp, e_csp, e_mdp, e_pgp, e_vjmp, e_bhp;
    AppCompatButton e_apbp_cart_click, e_bpp_cart_click, e_bpx_cart_click, e_arp_cart_click, e_flp_cart_click, e_csp_cart_click, e_mdp_cart_click, e_pgp_cart_click, e_vjmp_cart_click, e_bhp_cart_click;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_to_care);

        main = findViewById(R.id.main);

        e_apbp = findViewById(R.id.e_apbp);
        e_bpp = findViewById(R.id.e_bpp);
        e_bpx = findViewById(R.id.e_bpx);
        e_arp = findViewById(R.id.e_arp);
        e_flp = findViewById(R.id.e_flp);
        e_csp = findViewById(R.id.e_csp);
        e_mdp = findViewById(R.id.e_mdp);
        e_pgp = findViewById(R.id.e_pgp);
        e_vjmp = findViewById(R.id.e_vjmp);
        e_bhp = findViewById(R.id.e_bhp);
        e_apbp_cart_click = findViewById(R.id.e_apbp_cart_click);
        e_bpp_cart_click = findViewById(R.id.e_bpp_cart_click);
        e_bpx_cart_click = findViewById(R.id.e_bpx_cart_click);
        e_arp_cart_click = findViewById(R.id.e_arp_cart_click);
        e_flp_cart_click = findViewById(R.id.e_flp_cart_click);
        e_csp_cart_click = findViewById(R.id.e_csp_cart_click);
        e_mdp_cart_click = findViewById(R.id.e_mdp_cart_click);
        e_pgp_cart_click = findViewById(R.id.e_pgp_cart_click);
        e_vjmp_cart_click = findViewById(R.id.e_vjmp_cart_click);
        e_bhp_cart_click = findViewById(R.id.e_bhp_cart_click);

        e_apbp.setOnClickListener(v -> {
            String name = "Aglaonema Pink Beauty Plant";
            int price = 499;
            String description = "This variety of Aglaonema, often referred to as ‘Pink Aglaonema’ or ‘Lady Valentine,’ is renowned for its striking pink and green variegated leaves. It’s a popular houseplant due to its vibrant foliage and relatively easy care requirements.  ";
            RedirectProduct(R.drawable.aglaonema_pink_beauty_plant,name,price,description);
        });

        e_bpp.setOnClickListener(v -> {
            String name = "Bamboo Plam Plant";
            int price = 499;
            String description = "Known for its elegant, feathery fronds, the Bamboo Palm (Chamaedorea seifrizii) is a popular indoor plant that thrives in low light conditions and helps purify indoor air.";
            RedirectProduct(R.drawable.bamboo_palm_plant,name,price,description);
        });

        e_bpx.setOnClickListener(v -> {
            String name = "Bamboo Palm XL";
            int price = 499;
            String description = "This is likely a larger variant of the Bamboo Palm, offering the same air-purifying benefits and aesthetic appeal as its standard counterpart.";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        e_arp.setOnClickListener(v -> {
            String name = "Aglaonema Red Planin";
            int price = 499;
            String description = "Similar to the Pink Beauty, the Red Aglaonema features lush foliage with red and green hues, adding a vibrant touch to indoor spaces.";
            RedirectProduct(R.drawable.aglaonema_red_plant,name,price,description);
        });

        e_flp.setOnClickListener(v -> {
            String name = "Fiddle Leaf Fig Plant";
            int price = 499;
            String description = "Recognized for its large, glossy leaves, the Fiddle Leaf Fig (Ficus lyrata) is a popular choice for adding a bold, green statement to interiors.  ";
            RedirectProduct(R.drawable.fiddle_leaf_fig_plant,name,price,description);
        });

        e_csp.setOnClickListener(v -> {
            String name = "Chlorophytum Spider Plant";
            int price = 499;
            String description = "The Spider Plant (Chlorophytum comosum) is an easy-to-grow houseplant known for its arching leaves and small white flowers. It’s also appreciated for its air-purifying qualities.";
            RedirectProduct(R.drawable.chlorophytum_spider_plant,name,price,description);
        });

        e_mdp.setOnClickListener(v -> {
            String name = "Monstera Deliciosa Plant";
            int price = 499;
            String description = "Known for its unique, glossy, and large leaves with natural splits and holes, the Monstera Deliciosa adds a tropical vibe to any space. It’s a low-maintenance plant that thrives in indirect light and requires minimal watering.  ";
            RedirectProduct(R.drawable.monstera_deliciosa_plant,name,price,description);
        });

        e_pgp.setOnClickListener(v -> {
            String name = "Peperomia Green Plant";
            int price = 499;
            String description = "Peperomia is a compact, low-maintenance plant with attractive foliage, making it ideal for small spaces or desktops.";
            RedirectProduct(R.drawable.peperomia_green_plant,name,price,description);
        });

        e_vjmp.setOnClickListener(v -> {
            String name = "Variegated Jade Mini Plant";
            int price = 499;
            String description = "A smaller variant of the Jade Plant (Crassula ovata) featuring variegated leaves. Jade plants are succulents known for their thick, fleshy leaves and are considered symbols of good luck.";
            RedirectProduct(R.drawable.variegated_jade_mini_plant,name,price,description);
        });

        e_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 499;
            String description = "Commonly known as the Swiss Cheese Plant, it boasts large, glossy leaves with unique holes, adding a tropical feel to indoor spaces.";
            RedirectProduct(R.drawable.broken_heart_plant,name,price,description);
        });

        e_apbp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_bpp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_bpx_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_arp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_flp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_csp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_mdp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_pgp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_vjmp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        e_bhp_cart_click.setOnClickListener(v -> {
            onCartClick();
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

    }

    public void RedirectProduct(int imageResId,String name, int price, String description){
        Intent intent = new Intent(getApplicationContext(), product_explore.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("description",description);
        startActivity(intent);
    }

    public void onCartClick() {
        main.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
        Intent intent = new Intent(getApplicationContext(), cart.class);
        startActivity(intent);
    }

}
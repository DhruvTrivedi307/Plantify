package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
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
            String description = "One of the most popular houseplants, and our all-time bestseller, this easy-growing plant with its heart-shaped leaves is loved for its beautiful fenestrations. Quick to grow with delicate trailing vines that can be styled for every space, the Philodendron broken heart is the monstera charm you want to add to your home if you don't have the space for the huge monstera. Scientifically known as the Monstera adansonii, this broken heart plant thrives indoors in bright indirect light and with very little care.";
            RedirectProduct(R.drawable.broken_heart_plant_2,name,price,description);
        });

        h_jmp.setOnClickListener(v -> {
            String name = "Jade Plant Mini";
            int price = 279;
            String description = "An easy-to-care-for succulent, the Crassula Green Mini boasts lush foliage that enhances any room. Its coin-like round plump leaves are considered lucky in Feng Shui.";
            RedirectProduct(R.drawable.jade_mini_plats,name,price,description);
        });

        h_plp.setOnClickListener(v -> {
            String name = "Peace Lily Plant";
            int price = 299;
            String description = " Known for its elegant white blooms and lush green leaves, the Peace Lily is a popular houseplant that purifies indoor air. It thrives in low to medium light conditions and prefers consistently moist soil.";
            RedirectProduct(R.drawable.peace_lily_plant,name,price,description);
        });

        h_fbp.setOnClickListener(v -> {
            String name = "Ficus Bonsai Plant";
            int price = 949;
            String description = "A miniature version of the traditional Ficus tree, this Bonsai adds a touch of tranquility to indoor spaces. It requires bright indirect light and regular watering to maintain its shape and health.";
            RedirectProduct(R.drawable.ficus_bonsai_plant,name,price,description);
        });

        h_lbp.setOnClickListener(v -> {
            String name = "Lucky bamboo Plant";
            int price = 349;
            String description = "Symbolizing good fortune and prosperity, the Lucky Bamboo is easy to grow and can thrive in water or soil. It prefers indirect light and adds an elegant touch to any decor.";
            RedirectProduct(R.drawable.lucky_bamboo_plant,name,price,description);
        });

        h_stp.setOnClickListener(v -> {
            String name = "Stormanthe Triostar Plant";
            int price = 349;
            String description = "This plant is known for its striking foliage, featuring a blend of green, white, and pink colors. It prefers bright, indirect light and high humidity levels to maintain its vibrant leaves.";
            RedirectProduct(R.drawable.stromanthe_triostar_plant,name,price,description);
        });

        h_pgp.setOnClickListener(v -> {
            String name = "Peperomia Green Plant";
            int price = 279;
            String description = "A compact houseplant with thick, green leaves, the Peperomia is low-maintenance and ideal for indoor settings. It thrives in moderate light and requires minimal watering.";
            RedirectProduct(R.drawable.peperomia_green_plant,name,price,description);
        });

        h_mpg.setOnClickListener(v -> {
            String name = "Money Plant Golden";
            int price = 279;
            String description = "Also known as Golden Pothos, this plant is renowned for its trailing vines and heart-shaped leaves with golden variegation. It’s hardy, tolerates low light, and is believed to attract wealth and prosperity.";
            RedirectProduct(R.drawable.money_plant_golden,name,price,description);
        });

        h_pp.setOnClickListener(v -> {
            String name = "Peacock Plant";
            int price = 699;
            String description = "Featuring decorative leaves with intricate patterns resembling a peacock’s tail, this plant prefers low to medium light and high humidity. It’s a stunning addition to any indoor plant collection.";
            RedirectProduct(R.drawable.peacock_plant,name,price,description);
        });

        h_bwp.setOnClickListener(v -> {
            String name = "Brazilian Wood Plant";
            int price = 499;
            String description = "Also known as Dracaena fragrans, this plant has broad, arching leaves and is known for its air-purifying qualities. It thrives in low to medium light and requires moderate watering.";
            RedirectProduct(R.drawable.brazilian_wood_plant,name,price,description);
        });

        h_arp.setOnClickListener(v -> {
            String name = "Aglaonema Red Plant";
            int price = 749;
            String description = "This plant stands out with its vibrant red and green leaves. It’s easy to care for, tolerates low light conditions, and adds a pop of color to indoor spaces.";
            RedirectProduct(R.drawable.aglaonema_red_plant,name,price,description);
        });

        h_apbp.setOnClickListener(v -> {
            String name = "Aglaonema Pink Beauty Plant";
            int price = 714;
            String description = "Known for its attractive pink and green foliage, this plant is both decorative and low-maintenance. It prefers indirect light and regular watering.";
            RedirectProduct(R.drawable.aglaonema_pink_beauty_plant,name,price,description);
        });

        h_bpx.setOnClickListener(v -> {
            String name = "Bamboo Palm XL";
            int price = 857;
            String description = "A larger variety of the Bamboo Palm, this plant adds a tropical feel to interiors. It’s effective in purifying indoor air and thrives in low to medium light conditions.";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        h_bpp.setOnClickListener(v -> {
            String name = "Bamboo Palm Plant";
            int price = 399;
            String description = "A compact version of the Bamboo Palm, ideal for smaller spaces. It requires low to medium light and regular watering to keep the soil moist.";
            RedirectProduct(R.drawable.bamboo_palm_plant,name,price,description);
        });

        h_flp.setOnClickListener(v -> {
            String name = "Fiddle Leaf Fig Plant";
            int price = 1199;
            String description = "Known for its large, violin-shaped leaves, this plant is a popular choice for modern interiors. It requires bright, indirect light and consistent watering.";
            RedirectProduct(R.drawable.fiddle_leaf_fig_plant,name,price,description);
        });

        h_vjmp.setOnClickListener(v -> {
            String name = "Variegated Jade Mini Plant";
            int price = 299;
            String description = "A succulent with fleshy, variegated leaves featuring shades of green and cream. It’s easy to care for, requiring bright light and minimal watering.";
            RedirectProduct(R.drawable.variegated_jade_mini_plant,name,price,description);
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
        Intent intent = new Intent(getApplicationContext(), product.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("description", description);
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
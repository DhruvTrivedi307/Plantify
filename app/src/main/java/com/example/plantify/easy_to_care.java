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

public class easy_to_care extends AppCompatActivity {

    LinearLayout main,filter;
    LinearLayout e_apbp, e_bpp, e_bpx, e_arp, e_flp, e_csp, e_mdp, e_pgp, e_vjmp, e_bhp;
    AppCompatButton e_apbp_cart_click, e_bpp_cart_click, e_bpx_cart_click, e_arp_cart_click, e_flp_cart_click, e_csp_cart_click, e_mdp_cart_click, e_pgp_cart_click, e_vjmp_cart_click, e_bhp_cart_click;
    TextView not_avail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_easy_to_care);

        Intent intent = getIntent();
        float minPrice = intent.getFloatExtra("min_price", 100f);
        float maxPrice = intent.getFloatExtra("max_price", 2000f);

        boolean airPlants = intent.getBooleanExtra("air_plants", false);
        boolean floweringPlants = intent.getBooleanExtra("flowering_plants", false);
        boolean climbers = intent.getBooleanExtra("climbers", false);

        main = findViewById(R.id.main);
        filter = findViewById(R.id.filter);

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

        not_avail = findViewById(R.id.not_avail);

        boolean hasFilter = airPlants || floweringPlants || climbers || minPrice > 100f || maxPrice < 2000f;

        if (hasFilter) {
            e_apbp.setVisibility(View.GONE);
            e_bpp.setVisibility(View.GONE);
            e_bpx.setVisibility(View.GONE);
            e_arp.setVisibility(View.GONE);
            e_flp.setVisibility(View.GONE);
            e_csp.setVisibility(View.GONE);
            e_mdp.setVisibility(View.GONE);
            e_pgp.setVisibility(View.GONE);
            e_vjmp.setVisibility(View.GONE);
            e_bhp.setVisibility(View.GONE);

            if (isPriceInRange(719, minPrice, maxPrice) && airPlants) e_apbp.setVisibility(View.VISIBLE);
            if (isPriceInRange(799, minPrice, maxPrice) && airPlants) e_bpp.setVisibility(View.VISIBLE);
            if (isPriceInRange(857, minPrice, maxPrice) && floweringPlants) e_bpx.setVisibility(View.VISIBLE);
            if (isPriceInRange(849, minPrice, maxPrice) && floweringPlants) e_arp.setVisibility(View.VISIBLE);
            if (isPriceInRange(1199, minPrice, maxPrice) && climbers) e_flp.setVisibility(View.VISIBLE);
            if (isPriceInRange(1146, minPrice, maxPrice) && climbers) e_csp.setVisibility(View.VISIBLE);
        }

        e_apbp.setOnClickListener(v -> {
            String name = "Aglaonema Pink Beauty Plant";
            int price = 719;
            String description = "This variety of Aglaonema, often referred to as ‘Pink Aglaonema’ or ‘Lady Valentine,’ is renowned for its striking pink and green variegated leaves. It’s a popular houseplant due to its vibrant foliage and relatively easy care requirements.  ";
            RedirectProduct(R.drawable.aglaonema_pink_beauty_plant,name,price,description);
        });

        e_bpp.setOnClickListener(v -> {
            String name = "Bamboo Plam Plant";
            int price = 799;
            String description = "Known for its elegant, feathery fronds, the Bamboo Palm (Chamaedorea seifrizii) is a popular indoor plant that thrives in low light conditions and helps purify indoor air.";
            RedirectProduct(R.drawable.bamboo_palm_plant,name,price,description);
        });

        e_bpx.setOnClickListener(v -> {
            String name = "Bamboo Palm XL";
            int price = 857;
            String description = "This is likely a larger variant of the Bamboo Palm, offering the same air-purifying benefits and aesthetic appeal as its standard counterpart.";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        e_arp.setOnClickListener(v -> {
            String name = "Aglaonema Red Planin";
            int price = 849;
            String description = "Similar to the Pink Beauty, the Red Aglaonema features lush foliage with red and green hues, adding a vibrant touch to indoor spaces.";
            RedirectProduct(R.drawable.aglaonema_red_plant,name,price,description);
        });

        e_flp.setOnClickListener(v -> {
            String name = "Fiddle Leaf Fig Plant";
            int price = 1199;
            String description = "Recognized for its large, glossy leaves, the Fiddle Leaf Fig (Ficus lyrata) is a popular choice for adding a bold, green statement to interiors.  ";
            RedirectProduct(R.drawable.fiddle_leaf_fig_plant,name,price,description);
        });

        e_csp.setOnClickListener(v -> {
            String name = "Chlorophytum Spider Plant";
            int price = 1146;
            String description = "The Spider Plant (Chlorophytum comosum) is an easy-to-grow houseplant known for its arching leaves and small white flowers. It’s also appreciated for its air-purifying qualities.";
            RedirectProduct(R.drawable.chlorophytum_spider_plant,name,price,description);
        });

        e_mdp.setOnClickListener(v -> {
            String name = "Monstera Deliciosa Plant";
            int price = 867;
            String description = "Known for its unique, glossy, and large leaves with natural splits and holes, the Monstera Deliciosa adds a tropical vibe to any space. It’s a low-maintenance plant that thrives in indirect light and requires minimal watering.  ";
            RedirectProduct(R.drawable.monstera_deliciosa_plant,name,price,description);
        });

        e_pgp.setOnClickListener(v -> {
            String name = "Peperomia Green Plant";
            int price = 899;
            String description = "Peperomia is a compact, low-maintenance plant with attractive foliage, making it ideal for small spaces or desktops.";
            RedirectProduct(R.drawable.peperomia_green_plant,name,price,description);
        });

        e_vjmp.setOnClickListener(v -> {
            String name = "Variegated Jade Mini Plant";
            int price = 299;
            String description = "A smaller variant of the Jade Plant (Crassula ovata) featuring variegated leaves. Jade plants are succulents known for their thick, fleshy leaves and are considered symbols of good luck.";
            RedirectProduct(R.drawable.variegated_jade_mini_plant,name,price,description);
        });

        e_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 299;
            String description = "Commonly known as the Swiss Cheese Plant, it boasts large, glossy leaves with unique holes, adding a tropical feel to indoor spaces.";
            RedirectProduct(R.drawable.broken_heart_plant,name,price,description);
        });

        e_apbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.aglaonema_pink_beauty_plant,"Aglaonema Pink Beauty Plant","Small",719,1);
        });

        e_bpp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.bamboo_palm_plant,"Bamboo Palm Plant","Small",799,1);
        });

        e_bpx_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.bamboo_palm_xl,"Bamboo Palm XL","Small",857,1);
        });

        e_arp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.aglaonema_red_plant,"Aglaonema Red Plant","Small",849,1);
        });

        e_flp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.fiddle_leaf_fig_plant,"Fiddle Leaf Fig Plant","Small",1199,1);
        });

        e_csp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.chlorophytum_spider_plant,"Chlorophytum Spider Plant","Small",1146,1);
        });

        e_mdp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.monstera_deliciosa_plant,"Monstera Deliciosa Plant","Small",867,1);
        });

        e_pgp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peperomia_green_plant,"Peperomia Green Plant","Small",899,1);
        });

        e_vjmp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.variegated_jade_mini_plant,"Variegated Jade Mini Plant","Small",299,1);
        });

        e_bhp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.broken_heart_plant,"Broken Heart Plant","Small",299,1);
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
                Intent i = new Intent(easy_to_care.this,filter_type_of_plants.class);
                i.putExtra("page",easy_to_care.class.getName());
                startActivity(i);
            }
        });

        if (e_apbp.getVisibility() == View.GONE && e_bpp.getVisibility() == View.GONE && e_bpx.getVisibility() == View.GONE && e_arp.getVisibility() == View.GONE && e_flp.getVisibility() == View.GONE && e_csp.getVisibility() == View.GONE) {
            not_avail.setVisibility(View.VISIBLE);
        } else {
            not_avail.setVisibility(View.GONE);
        }
    }

    private boolean isPriceInRange(int price, float min, float max) {
        return price >= min && price <= max;
    }

    public void RedirectProduct(int imageResId,String name, int price, String description){
        Intent intent = new Intent(getApplicationContext(), product_explore.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("description",description);
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
        startActivity(new Intent(easy_to_care.this, home.class));
    }

}
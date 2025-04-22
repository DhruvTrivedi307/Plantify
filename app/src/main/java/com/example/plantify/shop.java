package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class shop extends AppCompatActivity {

    LinearLayout main;
    BottomNavigationView bnv;
    LinearLayout filter;
    LinearLayout h_bhp, h_jmp, h_plp, h_fbp, h_lbp, h_stp, h_pgp, h_mpg, h_pp, h_bwp, h_arp, h_apbp, h_bpx, h_bpp, h_flp, h_vjmp;
    AppCompatButton h_bhp_cart_click, h_jmp_cart_click, h_plp_cart_click, h_fbp_cart_click, h_lbp_cart_click, h_stp_cart_click, h_pgp_cart_click, h_mpg_cart_click, h_pp_cart_click, h_bwp_cart_click, h_arp_cart_click, h_apbp_cart_click, h_bpx_cart_click, h_bpp_cart_click, h_flp_cart_click, h_vjmp_cart_click;

    Button indoorBTN;
//    int[] item_images = {R.drawable.peacock_plant, R.drawable.brazilian_wood_plant, R.drawable.money_plant_golden};
//    int[] item_prices = {499, 899, 479};
//    String[] item_names = {"Peacock Plant", "Brazilian Wood Plant", "Money Plant Golden"};
//    String[] item_sizes = {"Small", "Medium", "Small"};
//    int[] item_quantities = {1, 1, 1};

//    String[] name = Objects.requireNonNull(getIntent().getStringArrayListExtra("name")).toArray(new String[0]);
    boolean isavail = false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        main = findViewById(R.id.main);

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
        
        filter = findViewById(R.id.filter);



        filter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(shop.this, filter_type_of_plants.class));
                Intent i = new Intent(shop.this,filter_type_of_plants.class);
                i.putExtra("page",shop.class.getName());
                startActivity(i);
            }
        });

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
            int price = 929;
            String description = "Known for its elegant white blooms and lush green leaves, the Peace Lily is a popular houseplant that purifies indoor air. It thrives in low to medium light conditions and prefers consistently moist soil.";
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
            int price = 639;
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
            int price = 899;
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
            int price = 1140;
            String description = "A succulent with fleshy, variegated leaves featuring shades of green and cream. It’s easy to care for, requiring bright light and minimal watering.";
            RedirectProduct(R.drawable.variegated_jade_mini_plant,name,price,description);
        });

        h_bhp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.broken_heart_plant_2, "Broken Heart Plant", 299, "Small", 1);
        });


        h_jmp_cart_click.setOnClickListener(v -> {
            int currentCount = cart_item.count;
            onCartClick(R.drawable.jade_mini_plats, "Jade Plant Mini", 279, "Small", 1);
        });

        h_plp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peace_lily_plant, "Peace Lily Plant", 929, "Small", 1);
        });

        h_fbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.ficus_bonsai_plant, "Ficus Bonsai Plant", 949, "Small", 1);
        });

        h_lbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.lucky_bamboo_plant, "Lucky Bamboo Plant", 349, "Small", 1);
        });

        h_stp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.stromanthe_triostar_plant, "Stormanthe Triostar Plant", 349, "Small", 1);
        });

        h_pgp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peperomia_green_plant, "Peperomia Green Plant", 279, "Small", 1);
        });

        h_mpg_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.money_plant_golden, "Money Plant Golden", 279, "Small", 1);
        });

        h_pp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.peacock_plant, "Peacock Plant", 699, "Small", 1);
        });

        h_bwp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.brazilian_wood_plant, "Brazilian Wood Plant", 639, "Small", 1);
        });

        h_arp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.aglaonema_red_plant, "Aglaonema Red Plant", 749, "Small", 1);
        });

        h_apbp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.aglaonema_pink_beauty_plant, "Aglaonema Pink Beauty Plant", 714, "Small", 1);
        });

        h_bpx_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.bamboo_palm_xl, "Bamboo Palm XL", 857, "Small", 1);
        });

        h_bpp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.bamboo_palm_plant, "Bamboo Palm Plant", 899, "Small", 1);
        });

        h_flp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.fiddle_leaf_fig_plant, "Fiddle Leaf Fig Plant", 1199, "Small", 1);
        });

        h_vjmp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.variegated_jade_mini_plant, "Variegated Jade Mini Plant", 1140, "Small", 1);
        });

//        bnv.setSelectedItemId(R.id.shop);
        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Intent i = new Intent(getApplicationContext(), home.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    return true;
                } else if (item.getItemId() == R.id.trending) {
                    Intent i = new Intent(getApplicationContext(), trending.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    Intent i = new Intent(getApplicationContext(), profile_signin.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
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

        Intent intent = getIntent();

        boolean airPlants = intent.getBooleanExtra("air_plants", false);
        boolean floweringPlants = intent.getBooleanExtra("flowering_plants", false);
        boolean climbers = intent.getBooleanExtra("climbers", false);
        boolean focalPlants = intent.getBooleanExtra("focal_plants", false);
        boolean fruitPlants = intent.getBooleanExtra("fruit_plants", false);
        boolean groundCovers = intent.getBooleanExtra("ground_covers", false);
        float minPrice = intent.getFloatExtra("min_price", 100f);
        float maxPrice = intent.getFloatExtra("max_price", 2000f);
        boolean small = intent.getBooleanExtra("small_size", false);
        boolean medium = intent.getBooleanExtra("medium_size", false);
        boolean indoor = intent.getBooleanExtra("indoor", false);
        boolean outdoor = intent.getBooleanExtra("outdoor", false);
        boolean outdoorShadeLovingPlant = intent.getBooleanExtra("outdoor_shade_loving_plant", false);
        boolean outdoorSunLovingPlant = intent.getBooleanExtra("outdoor_sun_loving_plant", false);

        // Hide all plant views initially
        h_bhp.setVisibility(View.GONE);
        h_jmp.setVisibility(View.GONE);
        h_plp.setVisibility(View.GONE);
        h_fbp.setVisibility(View.GONE);
        h_lbp.setVisibility(View.GONE);
        h_stp.setVisibility(View.GONE);
        h_pgp.setVisibility(View.GONE);
        h_mpg.setVisibility(View.GONE);
        h_pp.setVisibility(View.GONE);
        h_bwp.setVisibility(View.GONE);
        h_arp.setVisibility(View.GONE);
        h_apbp.setVisibility(View.GONE);
        h_bpx.setVisibility(View.GONE);
        h_bpp.setVisibility(View.GONE);
        h_flp.setVisibility(View.GONE);
        h_vjmp.setVisibility(View.GONE);

        // Apply filters
        setPlantVisibility(h_bhp, airPlants, 299, minPrice, maxPrice);
        setPlantVisibility(h_jmp, airPlants, 279, minPrice, maxPrice);
        setPlantVisibility(h_plp, airPlants, 929, minPrice, maxPrice);
        setPlantVisibility(h_fbp, airPlants, 949, minPrice, maxPrice);
        setPlantVisibility(h_lbp, airPlants, 349, minPrice, maxPrice);
        setPlantVisibility(h_stp, airPlants, 349, minPrice, maxPrice);
        setPlantVisibility(h_pgp, floweringPlants, 279, minPrice, maxPrice);
        setPlantVisibility(h_mpg, floweringPlants, 279, minPrice, maxPrice);
        setPlantVisibility(h_arp, floweringPlants || airPlants, 749, minPrice, maxPrice);
        setPlantVisibility(h_apbp, floweringPlants || airPlants, 714, minPrice, maxPrice);
        setPlantVisibility(h_pp, climbers || airPlants, 699, minPrice, maxPrice);
        setPlantVisibility(h_bwp, climbers || airPlants, 639, minPrice, maxPrice);
        setPlantVisibility(h_bpx, airPlants, 857, minPrice, maxPrice);
        setPlantVisibility(h_bpp, airPlants, 899, minPrice, maxPrice);
        setPlantVisibility(h_flp, airPlants, 1199, minPrice, maxPrice);
        setPlantVisibility(h_vjmp, airPlants, 1140, minPrice, maxPrice);

        // Optional: handle default visibility if no filters are applied
        if (!(airPlants || floweringPlants || climbers || focalPlants || fruitPlants || groundCovers || small || medium || indoor || outdoor || outdoorShadeLovingPlant || outdoorSunLovingPlant)) {
            h_bhp.setVisibility(View.VISIBLE);
            h_jmp.setVisibility(View.VISIBLE);
            h_plp.setVisibility(View.VISIBLE);
            h_fbp.setVisibility(View.VISIBLE);
            h_lbp.setVisibility(View.VISIBLE);
            h_stp.setVisibility(View.VISIBLE);
            h_pgp.setVisibility(View.VISIBLE);
            h_mpg.setVisibility(View.VISIBLE);
            h_pp.setVisibility(View.VISIBLE);
            h_bwp.setVisibility(View.VISIBLE);
            h_arp.setVisibility(View.VISIBLE);
            h_apbp.setVisibility(View.VISIBLE);
            h_bpx.setVisibility(View.VISIBLE);
            h_bpp.setVisibility(View.VISIBLE);
            h_flp.setVisibility(View.VISIBLE);
            h_vjmp.setVisibility(View.VISIBLE);
        }

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
        overridePendingTransition(0, R.anim.fade_out);
        startActivity(new Intent(shop.this,home.class));
    }

    protected void onResume() {
        super.onResume();
        bnv.setSelectedItemId(R.id.shop);
    }

    // Helper method to check if price is in range
    private boolean isPriceInRange(int price, float min, float max) {
        return price >= min && price <= max;
    }

    // Encapsulated visibility logic for plant views
    private void setPlantVisibility(View view, boolean categoryCondition, int price, float min, float max) {
        if (categoryCondition && isPriceInRange(price, min, max)) {
            view.setVisibility(View.VISIBLE);
        } else {
            view.setVisibility(View.GONE);
        }
    }
}

// Inserted methods above this line.
class FilterViewModel extends ViewModel {
    public MutableLiveData<List<String>> selectedPlants = new MutableLiveData<>(new ArrayList<>());
    public MutableLiveData<Float> minPrice = new MutableLiveData<>(100f);
    public MutableLiveData<Float> maxPrice = new MutableLiveData<>(2000f);
    public MutableLiveData<List<String>> selectedSize = new MutableLiveData<>(new ArrayList<>());
    public MutableLiveData<List<String>> selectedIOplants = new MutableLiveData<>(new ArrayList<>());
    public HttpCookie air_Plants;
    public HttpCookie floweringPlants;
}
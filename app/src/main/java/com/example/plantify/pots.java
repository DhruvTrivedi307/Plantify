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
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class pots extends AppCompatActivity {

    LinearLayout main,filter;
    LinearLayout p_gwp,p_owp,p_rwwp,p_rcp,p_cagcp,p_stp,p_tfbcp,p_tffcp,p_tccp,p_vep;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pots);

        Intent intent = getIntent();
        float minPrice = intent.getFloatExtra("min_price", 100f);
        float maxPrice = intent.getFloatExtra("max_price", 2000f);

        main = findViewById(R.id.main);

        filter = findViewById(R.id.filter);

        p_gwp = findViewById(R.id.p_gwp);
        p_owp = findViewById(R.id.p_owp);
        p_rwwp = findViewById(R.id.p_rwwp);
        p_rcp = findViewById(R.id.p_rcp);
        p_cagcp = findViewById(R.id.p_cagcp);
        p_stp = findViewById(R.id.p_stp);
        p_tfbcp = findViewById(R.id.p_tfbcp);
        p_tffcp = findViewById(R.id.p_tffcp);
        p_tccp = findViewById(R.id.p_tccp);
        p_vep = findViewById(R.id.p_vep);

        boolean airPlants = intent.getBooleanExtra("air_plants", false);
        boolean floweringPlants = intent.getBooleanExtra("flowering_plants", false);
        boolean climbers = intent.getBooleanExtra("climbers", false);

        if (airPlants || floweringPlants || climbers || minPrice > 100f || maxPrice < 2000f) {
            // Hide all initially
            p_gwp.setVisibility(View.GONE);
            p_owp.setVisibility(View.GONE);
            p_rwwp.setVisibility(View.GONE);
            p_rcp.setVisibility(View.GONE);
            p_cagcp.setVisibility(View.GONE);
            p_stp.setVisibility(View.GONE);
            p_tfbcp.setVisibility(View.GONE);
            p_tffcp.setVisibility(View.GONE);
            p_tccp.setVisibility(View.GONE);
            p_vep.setVisibility(View.GONE);

            // Show only the ones that match the selected type and price
            if (isPriceInRange(479, minPrice, maxPrice) && airPlants) p_gwp.setVisibility(View.VISIBLE);
            if (isPriceInRange(499, minPrice, maxPrice) && airPlants) p_owp.setVisibility(View.VISIBLE);
            if (isPriceInRange(829, minPrice, maxPrice) && floweringPlants) p_rwwp.setVisibility(View.VISIBLE);
            if (isPriceInRange(899, minPrice, maxPrice) && floweringPlants) p_rcp.setVisibility(View.VISIBLE);
            if (isPriceInRange(1289, minPrice, maxPrice) && climbers) p_cagcp.setVisibility(View.VISIBLE);
            if (isPriceInRange(1099, minPrice, maxPrice) && climbers) p_stp.setVisibility(View.VISIBLE);
        }

        p_gwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.gradient_wooden_planter,"Gradient Wooden Planter",479,"This Gradient Wooden Planter features a natural wood finish with a smooth gradient effect, adding an earthy charm to any space. Perfect for indoor plants, it blends rustic elegance with modern aesthetics.");
            }
        });

        p_owp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.orbit_wooden_planter,"Orbit Wooden Planter",499,"The Orbit Wooden Planter features a smooth, rounded design with a rich wooden texture, adding a natural charm to any space. Perfect for showcasing vibrant plants, it blends elegance with simplicity.");
            }
        });

        p_rwwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.ridged_waves_wooden_pot,"Ridged Waves Wooden Pot",829,"The Ridged Waves Wooden Pot showcases an artistic wavy texture, adding a modern yet earthy touch. Its unique design enhances the beauty of any plant, making it a perfect decor piece.");
            }
        });

        p_rcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.roma_ceramic_pot,"Roma Ceramic Pot",899,"Introducing the exquisite Roma Pot, a stunning ceramic masterpiece inspired by the timeless beauty of old Roman architecture. Reminiscent of majestic pillars, this unique pot brings an air of elegance and grandeur to your indoor or outdoor space.");
            }
        });

        p_cagcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.cats_are_gods_ceramic_planter,"Cats Are Gods Ceramic Planter",1289,"The stunning ceramic planters are hand-crafted with the finest clay, locally sourced from Hyderabad and Andhra Pradesh. These beautiful planters are built to last and promise to stay with your plants for more than 20 years without fading, chipping or losing their charm. The ceramic is skillfully baked and vitrified at 1200°C, giving it a stronger built and a longer-lasting life.");
            }
        });

        p_stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.sienna_terracotta_pots,"Sienna Terracotta Pots",1099,"The Sienna Terracotta Set of 3 Pots brings you three premium pots in aesthetic colors, adorned with elegant designs. These pots are sturdy, strong, and durable, making them the perfect companions for your plants. Find luxury and convenience all in one with these stunning terracotta pots.");
            }
        });

        p_tfbcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.tulip_fantasy_bowl_ceramic_planter,"Tulip Fantasy Bowl Ceramic Planter",879,"Our tulip fantasy planter is beautiful in its simplicity. The minimalist design with carefully handcrafted shape means its the best fit for your plants while also elevating the decor of your home. Made of premium grade ceramic, the planter sports the silkiest glaze you will ever come across in planters. ");
            }
        });

        p_tffcp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.tulip_fantasy_flat_ceramic_planter,"Tulip Fantasy Flat Ceramic Planter",839,"Our tulip fantasy planter is beautiful in its simplicity. The minimalist design with carefully handcrafted shape means its the best fit for your plants while also elevating the decor of your home. Made of premium grade ceramic, the planter sports the silkiest glaze you will ever come across in planters. ");
            }
        });

        p_tccp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.twilight_clouds_ceramic_planter,"Twilight Clouds Ceramic Planter", 699,"The stunning ceramic planters are hand-crafted with the finest clay, locally sourced from Hyderabad and Andhra Pradesh. These beautiful planters are built to last and promise to stay with your plants for more than 20 years without fading, chipping or losing their charm. ");
            }
        });

        p_vep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.verona_eco_planter,"Verona Eco Planter",699,"Elevate your indoor décor with the Verona Eco Series planters, stylish and functional additions that seamlessly blend eco-friendly materials with contemporary design. Shop these stunning planters in different size in the color of your choice! Why get one when you can get them all?");
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
                Intent i = new Intent(pots.this,filter_type_of_plants.class);
                i.putExtra("page",pots.class.getName());
                startActivity(i);
            }
        });

    }

    public void RedirectProduct(int imageResId,String name, int price,String desc){
        main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
        Intent intent = new Intent(getApplicationContext(), product_explore.class);
        intent.putExtra("img", imageResId);
        intent.putExtra("name", name);
        intent.putExtra("price", price);
        intent.putExtra("description",desc);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }

    private boolean isPriceInRange(int price, float min, float max) {
        return price >= min && price <= max;
    }
}
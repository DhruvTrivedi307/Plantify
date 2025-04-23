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

public class tools extends AppCompatActivity {

    LinearLayout main,filter;
    LinearLayout dmm, hwp, dpw, fpw, cps, pis, ss, ws;
    AppCompatButton dmm_cart_click, hwp_cart_click, dpw_cart_click, fpw_cart_click, cps_cart_click, pis_cart_click, ss_cart_click, ws_cart_click;
    TextView not_avail;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        // Read price filter range from intent
        Intent intent = getIntent();
        float minPrice = intent.getFloatExtra("min_price", 100f);
        float maxPrice = intent.getFloatExtra("max_price", 2000f);

        main = findViewById(R.id.main);
        filter = findViewById(R.id.filter);

        dmm = findViewById(R.id.dmm);
        hwp = findViewById(R.id.hwp);
        dpw = findViewById(R.id.dpw);
        fpw = findViewById(R.id.fpw);
        cps = findViewById(R.id.cps);
        pis = findViewById(R.id.pis);
        ss = findViewById(R.id.ss);
        ws = findViewById(R.id.ws);
        dmm_cart_click = findViewById(R.id.dmm_cart_click);
        hwp_cart_click = findViewById(R.id.hwp_cart_click);
        dpw_cart_click = findViewById(R.id.dpw_cart_click);
        fpw_cart_click = findViewById(R.id.fpw_cart_click);
        cps_cart_click = findViewById(R.id.cps_cart_click);
        pis_cart_click = findViewById(R.id.pis_cart_click);
        ss_cart_click = findViewById(R.id.ss_cart_click);
        ws_cart_click = findViewById(R.id.ws_cart_click);

        not_avail = findViewById(R.id.not_avail);

        dmm.setOnClickListener(v -> {
            String name = "Dom Metallic Mister";
            int price = 859;
            String description = "A 0.5-litre watering can, essential for home or office gardeners. Its size is perfect for spritzing small indoor plants without spilling onto nearby surfaces, and it also serves as an attractive decor piece.";
            RedirectProduct(R.drawable.dom_metallic_mister,name,price,description);
        });

        hwp.setOnClickListener(v -> {
            String name = "Hydra Watering Pitcher";
            int price = 829;
            String description = "An ergonomically designed premium watering jug, ideal for easily watering indoor and outdoor plants without stress.";
            RedirectProduct(R.drawable.hydra_watering_pitcher,name,price,description);
        });

        dpw.setOnClickListener(v -> {
            String name = "Double Prong Weeder";
            int price = 399;
            String description = "An upgraded version of the Single Prong Weeder, this tool is used for weeding, small root removal, efficiently loosening soil, and digging holes to sow seeds. It features a wooden handle for a firm grip and is perfectly sized for flower beds and small vegetable gardens.";
            RedirectProduct(R.drawable.double_prong_weeder,name,price,description);
        });

        fpw.setOnClickListener(v -> {
            String name = "Five Prong Weeder";
            int price = 350;
            String description = "This tool comes with five metal prongs and a wooden handle, making it suitable for comfortably turning soil and cleaning leaves from the garden. The product height is approximately 33 cm.";
            RedirectProduct(R.drawable.five_prong_weeder,name,price,description);
        });

        cps.setOnClickListener(v -> {
            String name = "Curve Pruning Saw - 33 Cm";
            int price = 599;
            String description = "The Pyramid Curve Pruning Saw features a double-edged 33 cm blade of excellent quality with a rubber grip for comfortable and firm handling. It’s popular among garden enthusiasts for cutting small branches, limbs, and trees up to 120 mm in diameter. ";
            RedirectProduct(R.drawable.curve_pruning_saw,name,price,description);
        });

        pis.setOnClickListener(v -> {
            String name = "Plastic Impulse Sprinkler";
            int price = 599;
            String description = "The Pyramid Plastic Sprinkler is ideal for watering medium-sized lawns. It has an adjustable shower head that covers a radius of 15 to 20 square feet. The body is made of plastic. ";
            RedirectProduct(R.drawable.plastic_impulse_sprinkler,name,price,description);
        });

        ss.setOnClickListener(v -> {
            String name = "Sprinkler Stand";
            int price = 599;
            String description = "Primarily used as an attachment for the Concorde Brass G2 and G3 sprinkler heads, this stand is made of mild steel with brass components. It offers dual compatibility for both sprinkler types. ";
            RedirectProduct(R.drawable.sprinkler_stand,name,price,description);
        });

        ws.setOnClickListener(v -> {
            String name = "Watermatic Stack";
            int price = 529;
            String description = " An automatic watering system suitable for both indoor and outdoor plants. The Watermatic Stake is easy to use and install, providing consistent watering for your garden throughout the year. ";
            RedirectProduct(R.drawable.watermatic_stake,name,price,description);
        });

        dmm_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.dom_metallic_mister,"Dom Metallic Mister","Small",859,1);
        });

        hwp_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.hydra_watering_pitcher,"Hydra Watering Pitcher","Samll",829,1);
        });

        dpw_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.double_prong_weeder,"Double Prong Weeder","Small",399,1);
        });

        fpw_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.five_prong_weeder,"Five Prong Weeder","Small",350,1);
        });

        cps_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.curve_pruning_saw,"Curve Pruning Saw - 33 Cm","Small",599,1);
        });

        pis_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.plastic_impulse_sprinkler,"Plastic Impulse Sprinkler","Small",599,1);
        });

        ss_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.sprinkler_stand,"Sprinkler Stand","Small",599,1);
        });

        ws_cart_click.setOnClickListener(v -> {
            onCartClick(R.drawable.watermatic_stake,"Watermatic Stake","Small",529,1);
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
                Intent i = new Intent(tools.this,filter_type_of_plants.class);
                i.putExtra("page",tools.class.getName());
                startActivity(i);
            }
        });

        // Hide tools not in selected price range
        if (!isPriceInRange(859, minPrice, maxPrice)) dmm.setVisibility(View.GONE);
        if (!isPriceInRange(829, minPrice, maxPrice)) hwp.setVisibility(View.GONE);
        if (!isPriceInRange(399, minPrice, maxPrice)) dpw.setVisibility(View.GONE);
        if (!isPriceInRange(350, minPrice, maxPrice)) fpw.setVisibility(View.GONE);
        if (!isPriceInRange(599, minPrice, maxPrice)) cps.setVisibility(View.GONE);
        if (!isPriceInRange(599, minPrice, maxPrice)) pis.setVisibility(View.GONE);
        if (!isPriceInRange(599, minPrice, maxPrice)) ss.setVisibility(View.GONE);
        if (!isPriceInRange(529, minPrice, maxPrice)) ws.setVisibility(View.GONE);

        not_avail.setVisibility(View.GONE);
        if (dmm.getVisibility() == View.GONE && hwp.getVisibility() == View.GONE && dpw.getVisibility() == View.GONE && fpw.getVisibility() == View.GONE &&
                cps.getVisibility() == View.GONE && pis.getVisibility() == View.GONE && ss.getVisibility() == View.GONE && ws.getVisibility() == View.GONE) {
            not_avail.setVisibility(View.VISIBLE);
        } else {
            not_avail.setVisibility(View.GONE);
        }
    }

    public void RedirectProduct(int imageResId,String name, int price, String description){
        Intent intent = new Intent(getApplicationContext(), product.class);
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

    // Returns true if price is within [min, max] range
    private boolean isPriceInRange(int price, float min, float max) {
        return price >= min && price <= max;
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(tools.this, home.class));
    }

}
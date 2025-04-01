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

public class tools extends AppCompatActivity {

    LinearLayout main;
    LinearLayout dmm, hwp, dpw, fpw, cps, pis, ss, ws;
    AppCompatButton dmm_cart_click, hwp_cart_click, dpw_cart_click, fpw_cart_click, cps_cart_click, pis_cart_click, ss_cart_click, ws_cart_click;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        main = findViewById(R.id.main);

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

        dmm.setOnClickListener(v -> {
            String name = "Dom Metallic Mister";
            int price = 859;
            String description = "A 0.5-litre watering can, essential for home or office gardeners. Its size is perfect for spritzing small indoor plants without spilling onto nearby surfaces, and it also serves as an attractive decor piece.";
            RedirectProduct(R.drawable.dom_metallic_mister,name,price,description);
        });

        hwp.setOnClickListener(v -> {
            String name = "Hydra Watering Pitcher";
            int price = 399;
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
            int price = 969;
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
            int price = 879;
            String description = "The Pyramid Plastic Sprinkler is ideal for watering medium-sized lawns. It has an adjustable shower head that covers a radius of 15 to 20 square feet. The body is made of plastic. ";
            RedirectProduct(R.drawable.plastic_impulse_sprinkler,name,price,description);
        });

        ss.setOnClickListener(v -> {
            String name = "Sprinkler Stand";
            int price = 839;
            String description = "Primarily used as an attachment for the Concorde Brass G2 and G3 sprinkler heads, this stand is made of mild steel with brass components. It offers dual compatibility for both sprinkler types. ";
            RedirectProduct(R.drawable.sprinkler_stand,name,price,description);
        });

        ws.setOnClickListener(v -> {
            String name = "Watermatic Stack";
            int price = 299;
            String description = " An automatic watering system suitable for both indoor and outdoor plants. The Watermatic Stake is easy to use and install, providing consistent watering for your garden throughout the year. ";
            RedirectProduct(R.drawable.watermatic_stake,name,price,description);
        });

        dmm_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        hwp_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        dpw_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        fpw_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        cps_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        pis_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        ss_cart_click.setOnClickListener(v -> {
            onCartClick();
        });

        ws_cart_click.setOnClickListener(v -> {
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
        main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
        Intent intent = new Intent(getApplicationContext(), cart.class);
        startActivity(intent);
    }

}
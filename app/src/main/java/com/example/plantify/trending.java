package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class trending extends AppCompatActivity {

    LinearLayout t_bpp, t_flp, t_apbp, t_arp, t_bpx, t_csp, t_mdp, t_dmm, t_hwp, t_stp, t_bs, t_as, t_fpw, t_cps, t_bhp, t_jpm, t_bwp, t_pp, t_fbp, t_lbp, t_pgp, main;
    BottomNavigationView bnv;
    AppCompatButton small,medium,addtocart,buy_now_bottom,view_top_selling,view_best_sellers,view_indoor_plants;
    Button btnMinus,btnPlus;
    TextView size, txtCount;
    private String selectedSize = "";
    private int count = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trending);

        t_bpp = findViewById(R.id.t_bpp);
        t_flp = findViewById(R.id.t_flp);
        t_apbp = findViewById(R.id.t_apbp);
        t_arp = findViewById(R.id.t_arp);
        t_bpx = findViewById(R.id.t_bpx);
        t_csp = findViewById(R.id.t_csp);
        t_mdp = findViewById(R.id.t_mdp);
        t_dmm = findViewById(R.id.t_dmm);
        t_hwp = findViewById(R.id.t_hwp);
        t_stp = findViewById(R.id.t_stp);
        t_bs = findViewById(R.id.t_bs);
        t_as = findViewById(R.id.t_as);
        t_fpw = findViewById(R.id.t_fpw);
        t_cps = findViewById(R.id.t_cps);
        t_bhp = findViewById(R.id.t_bhp);
        t_jpm = findViewById(R.id.t_jpm);
        t_bwp = findViewById(R.id.t_bwp);
        t_pp = findViewById(R.id.t_pp);
        t_fbp = findViewById(R.id.t_fbp);
        t_lbp = findViewById(R.id.t_lbp);
        t_pgp = findViewById(R.id.t_pgp);

        view_top_selling = findViewById(R.id.view_top_selling);
        view_best_sellers = findViewById(R.id.view_best_sellers);
        view_indoor_plants = findViewById(R.id.view_indoor_plants);

        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);

        size = findViewById(R.id.size);
        txtCount = findViewById(R.id.txtCount);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);

        main = findViewById(R.id.main);

        addtocart = findViewById(R.id.addtocart);
        buy_now_bottom = findViewById(R.id.buy_now_bottom);

        t_bpp.setOnClickListener(v -> {
            String name = "Bamboo Palm Plant";
            int price = 849;
            String description = "A compact version of the Bamboo Palm, ideal for smaller spaces. It requires low to medium light and regular watering to keep the soil moist.";
            RedirectProduct(R.drawable.bamboo_palm_plant,name,price,description);
        });

        t_flp.setOnClickListener(v -> {
            String name = "Fiddle Leaf Fig Plant";
            int price = 699;
            String description = "Known for its large, violin-shaped leaves, this plant is a popular choice for modern interiors. It requires bright, indirect light and consistent watering.";
            RedirectProduct(R.drawable.fiddle_leaf_fig_plant,name,price,description);
        });

        t_apbp.setOnClickListener(v -> {
            String name = "Aglaonema Pink Beauty Plant";
            int price = 269;
            String description = "Known for its attractive pink and green foliage, this plant is both decorative and low-maintenance. It prefers indirect light and regular watering.";
            RedirectProduct(R.drawable.aglaonema_pink_beauty_plant,name,price,description);
        });

        t_arp.setOnClickListener(v -> {
            String name = "Aglaonema Red Plant";
            int price = 499;
            String description = "This plant stands out with its vibrant red and green leaves. It’s easy to care for, tolerates low light conditions, and adds a pop of color to indoor spaces.";
            RedirectProduct(R.drawable.aglaonema_red_plant,name,price,description);
        });

        t_bpx.setOnClickListener(v -> {
            String name = "Bamboo Palm XL";
            int price = 499;
            String description = "A larger variety of the Bamboo Palm, this plant adds a tropical feel to interiors. It’s effective in purifying indoor air and thrives in low to medium light conditions.";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        t_csp.setOnClickListener(v -> {
            String name = "Chlorophytum Spider Plant";
            int price = 449;
            String description = "Chlorophytum Spider aka the Spider Plant, is an impressive indoor plant and perfect for beginners. Famous for its variegated lance shaped leaves that emerge from the centre of the plant and spill over the sides of the planter giving it a full appearance. ";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        t_mdp.setOnClickListener(v -> {
            String name = "Monstera Deliciosa Plant";
            int price = 379;
            String description = "Looking to uplift your home decor with some tropical aesthetics? This large Monstera plant will do just that for you and easily become one of your favorite indoor plants. Also called the Swiss Cheese Plant, the Monstera Deliciosa is a tropical stunner brought indoors, charming people everywhere with its large leaves and wonderful fenestrations that resemble a Swiss cheese slice.";
            RedirectProduct(R.drawable.bamboo_palm_xl,name,price,description);
        });

        t_dmm.setOnClickListener(v -> {
            String name = "Dom Metallic Mister";
            int price = 699;
            String description = "A 0.5-litre watering can, essential for home or office gardeners. Its size is perfect for spritzing small indoor plants without spilling onto nearby surfaces, and it also serves as an attractive decor piece.";
            RedirectProduct(R.drawable.dom_metallic_mister,name,price,description);
        });

        t_hwp.setOnClickListener(v -> {
            String name = "Hydra Watering Pitcher";
            int price = 499;
            String description = "An ergonomically designed premium watering jug, ideal for easily watering indoor and outdoor plants without stress.";
            RedirectProduct(R.drawable.hydra_watering_pitcher,name,price,description);
        });

        t_stp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.sienna_terracotta_pots,"Sienna Terracotta Pots",359,"The Sienna Terracotta Set of 3 Pots brings you three premium pots in aesthetic colors, adorned with elegant designs. These pots are sturdy, strong, and durable, making them the perfect companions for your plants. Find luxury and convenience all in one with these stunning terracotta pots.");
            }
        });

        t_bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Beetroot Seeds";
                int price = 849;
                String description = "These open-pollinated, 100% organic seeds are designed to provide authentic taste and superior quality harvests compared to commonly found seeds.";
                RedirectProduct(R.drawable.beetroot_seeds,name,price,description);
            }
        });

        t_as.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = "Amaranth Seeds";
                int price = 379;
                String description = "Amaranth is known for its rapid growth, quick rejuvenation after each harvest, and high yield in a short time. It is highly efficient at photosynthesis and thrives even in adverse environmental conditions.";
                RedirectProduct(R.drawable.amaranth_seeds,name,price,description);
            }
        });

        t_fpw.setOnClickListener(v -> {
            String name = "Five Prong Weeder";
            int price = 879;
            String description = "This tool comes with five metal prongs and a wooden handle, making it suitable for comfortably turning soil and cleaning leaves from the garden. The product height is approximately 33 cm.";
            RedirectProduct(R.drawable.five_prong_weeder,name,price,description);
        });

        t_cps.setOnClickListener(v -> {
            String name = "Curve Pruning Saw - 33 Cm";
            int price = 499;
            String description = "The Pyramid Curve Pruning Saw features a double-edged 33 cm blade of excellent quality with a rubber grip for comfortable and firm handling. It’s popular among garden enthusiasts for cutting small branches, limbs, and trees up to 120 mm in diameter. ";
            RedirectProduct(R.drawable.curve_pruning_saw,name,price,description);
        });

        t_bhp.setOnClickListener(v -> {
            String name = "Broken Heart Plant";
            int price = 449;
            String description = "One of the most popular houseplants, and our all-time bestseller, this easy-growing plant with its heart-shaped leaves is loved for its beautiful fenestrations. Quick to grow with delicate trailing vines that can be styled for every space, the Philodendron broken heart is the monstera charm you want to add to your home if you don't have the space for the huge monstera. Scientifically known as the Monstera adansonii, this broken heart plant thrives indoors in bright indirect light and with very little care.";
            RedirectProduct(R.drawable.broken_heart_plant_2,name,price,description);
        });

        t_jpm.setOnClickListener(v -> {
            String name = "Jade Plant Mini";
            int price = 509;
            String description = "An easy-to-care-for succulent, the Crassula Green Mini boasts lush foliage that enhances any room. Its coin-like round plump leaves are considered lucky in Feng Shui.";
            RedirectProduct(R.drawable.jade_mini_plats,name,price,description);
        });

        t_bwp.setOnClickListener(v -> {
            String name = "Brazilian Wood Plant";
            int price = 289;
            String description = "Also known as Dracaena fragrans, this plant has broad, arching leaves and is known for its air-purifying qualities. It thrives in low to medium light and requires moderate watering.";
            RedirectProduct(R.drawable.brazilian_wood_plant,name,price,description);
        });

        t_pp.setOnClickListener(v -> {
            String name = "Peacock Plant";
            int price = 389;
            String description = "Featuring decorative leaves with intricate patterns resembling a peacock’s tail, this plant prefers low to medium light and high humidity. It’s a stunning addition to any indoor plant collection.";
            RedirectProduct(R.drawable.peacock_plant,name,price,description);
        });

        t_fbp.setOnClickListener(v -> {
            String name = "Ficus Bonsai Plant";
            int price = 899;
            String description = "A miniature version of the traditional Ficus tree, this Bonsai adds a touch of tranquility to indoor spaces. It requires bright indirect light and regular watering to maintain its shape and health.";
            RedirectProduct(R.drawable.ficus_bonsai_plant,name,price,description);
        });

        t_lbp.setOnClickListener(v -> {
            String name = "Lucky bamboo Plant";
            int price = 579;
            String description = "Symbolizing good fortune and prosperity, the Lucky Bamboo is easy to grow and can thrive in water or soil. It prefers indirect light and adds an elegant touch to any decor.";
            RedirectProduct(R.drawable.lucky_bamboo_plant,name,price,description);
        });

        t_pgp.setOnClickListener(v -> {
            String name = "Peperomia Green Plant";
            int price = 719;
            String description = "A compact houseplant with thick, green leaves, the Peperomia is low-maintenance and ideal for indoor settings. It thrives in moderate light and requires minimal watering.";
            RedirectProduct(R.drawable.peperomia_green_plant,name,price,description);
        });

        view_top_selling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(new Intent(trending.this,bestsellers.class));
            }
        });

        view_best_sellers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(new Intent(trending.this,tools.class));
            }
        });

        view_indoor_plants.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                startActivity(new Intent(trending.this,easy_to_care.class));
            }
        });

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                onCartClick(R.drawable.lucky_bamboo_plant,"Lucky bamboo Plant",349,"Small",1);
            }
        });

        buy_now_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                String name = "Lucky bamboo Plant";
                int price = 349;
                String description = "Symbolizing good fortune and prosperity, the Lucky Bamboo is easy to grow and can thrive in water or soil. It prefers indirect light and adds an elegant touch to any decor.";
                int qty = count;
                String size = selectedSize;
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.lucky_bamboo_plant);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("description",description);
                i.putExtra("qty",qty);
                i.putExtra("size",size);
                startActivity(i);
            }
        });

        bnv = findViewById(R.id.bnv);

//        bnv.setSelectedItemId(R.id.trending);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Intent i = new Intent(getApplicationContext(), home.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    return true;
                } else if (item.getItemId() == R.id.shop) {
                    Intent i = new Intent(getApplicationContext(), shop.class);
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

        small.setSelected(true);
        View.OnClickListener sizeClickListener = v -> {
            small.setSelected(false);
            medium.setSelected(false);
            v.setSelected(true);

            if (v == small) {
                main.performHapticFeedback(HapticFeedbackConstants.GESTURE_END);
                selectedSize = "Small";
                size.setText(selectedSize);
            } else if (v == medium) {
                main.performHapticFeedback(HapticFeedbackConstants.GESTURE_START);
                selectedSize = "Medium";
                size.setText(selectedSize);
            }

        };

        small.setOnClickListener(sizeClickListener);
        medium.setOnClickListener(sizeClickListener);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                String sel_size = selectedSize;
                onCartClick(R.drawable.jade_mini_plats,"Jade Mini Plant",279,sel_size,count);
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.GESTURE_END);
                if (count > 1) {
                    count--;
                    txtCount.setText(String.valueOf(count));
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.GESTURE_START);
                if (count < 5) {
                    count++;
                    txtCount.setText(String.valueOf(count));
                }
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
        overridePendingTransition(0, R.anim.fade_out);
    }

    protected void onResume() {
        super.onResume();
        bnv.setSelectedItemId(R.id.trending);
    }
}
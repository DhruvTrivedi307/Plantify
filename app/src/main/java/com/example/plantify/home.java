package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.content.SharedPreferences;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.Arrays;
import java.util.List;

public class home extends AppCompatActivity {

    LinearLayout main;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private ViewPager2 vp;
    BottomNavigationView bnv;
    int currentPage = 0;
    ImageView search_icon,cart_icon;
    LinearLayout tools,bestsellers,easy_to_care,pots,seeds;
    ImageView h_bhp,h_jmp,h_bwp,h_pp;
    AppCompatButton small,medium,addtocart;
    private String selectedSize = "";
    Button viewAll, h_bhp_cart_click, h_jmp_cart_click, h_bwp_cart_click, h_pp_cart_click;
    TextView size;
    TextView txtCount;
    private int count = 1;
    Button btnMinus,btnPlus,buy_now_bottom;
    TabLayout tabLayout;

    @SuppressLint({"MissingInflatedId", "WrongViewCast"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        main = findViewById(R.id.main);

        vp = findViewById(R.id.vp);
        bnv = findViewById(R.id.bnv);
        tools = findViewById(R.id.tools);
        bestsellers = findViewById(R.id.bestsellers);
        easy_to_care = findViewById(R.id.easy_to_care);
        pots = findViewById(R.id.pots);
        seeds = findViewById(R.id.seeds);

        h_bhp = findViewById(R.id.h_bhp);
        h_jmp = findViewById(R.id.h_jmp);
        h_bwp = findViewById(R.id.h_bwp);
        h_pp = findViewById(R.id.h_pp);
        viewAll = findViewById(R.id.viewAll);

        h_bhp_cart_click = findViewById(R.id.h_bhp_cart_click);
        h_jmp_cart_click = findViewById(R.id.h_jmp_cart_click);
        h_bwp_cart_click = findViewById(R.id.h_bwp_cart_click);
        h_pp_cart_click = findViewById(R.id.h_pp_cart_click);

        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        size = findViewById(R.id.size);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);
        buy_now_bottom = findViewById(R.id.buy_now_bottom);
        addtocart = findViewById(R.id.addtocart);

        addtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                onCartClick(R.drawable.jade_mini_plats,"Jade Mini Plant",279,"Small",1);
            }
        });

        buy_now_bottom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.LONG_PRESS);
                String name = "Jade Mini Plant";
                int price = 279;
                String description = "One of the most popular houseplants, and our all-time bestseller, this easy-growing plant with its heart-shaped leaves is loved for its beautiful fenestrations. Quick to grow with delicate trailing vines that can be styled for every space, the Philodendron broken heart is the monstera charm you want to add to your home if you don't have the space for the huge monstera. Scientifically known as the Monstera adansonii, this broken heart plant thrives indoors in bright indirect light and with very little care.";
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.jade_mini_plats);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("description",description);
                startActivity(i);
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


        viewAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
                Intent i = new Intent(getApplicationContext(),shop.class);
                startActivity(i);
            }
        });

        h_bhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
                String name = "Broken Heart Plant";
                int price = 499;
                String description = "One of the most popular houseplants, and our all-time bestseller, this easy-growing plant with its heart-shaped leaves is loved for its beautiful fenestrations. Quick to grow with delicate trailing vines that can be styled for every space, the Philodendron broken heart is the monstera charm you want to add to your home if you don't have the space for the huge monstera. Scientifically known as the Monstera adansonii, this broken heart plant thrives indoors in bright indirect light and with very little care.";
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.broken_heart_plant_2);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("description",description);
                startActivity(i);
            }
        });

        h_jmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
                String name = "Jade Mini Plant";
                int price = 499;
                String description = "An easy-to-care-for succulent, the Crassula Green Mini boasts lush foliage that enhances any room. Its coin-like round plump leaves are considered lucky in Feng Shui.";
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.jade_mini_plats);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("description",description);
                startActivity(i);
            }
        });

        h_bwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
                String name = "Brazilian Wood Plant";
                int price = 499;
                String description = "Also known as Dracaena fragrans, this plant has broad, arching leaves and is known for its air-purifying qualities. It thrives in low to medium light and requires moderate watering.";
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.brazilian_wood_plant);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("description",description);
                startActivity(i);
            }
        });

        h_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
                String name = "Peacock Plant";
                int price = 499;
                String description = "Featuring decorative leaves with intricate patterns resembling a peacock’s tail, this plant prefers low to medium light and high humidity. It’s a stunning addition to any indoor plant collection.";
                Intent i = new Intent(getApplicationContext(),product.class);
                i.putExtra("img",R.drawable.peacock_plant);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("description",description);
                startActivity(i);
            }
        });

        h_bhp_cart_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCartClick(R.drawable.broken_heart_plant_2,"Broken Heart Plant",299,"Small",1);
            }
        });

        h_jmp_cart_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCartClick(R.drawable.jade_mini_plats,"Jade Mini Plant",279,"Small",1);
            }
        });

        h_bwp_cart_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCartClick(R.drawable.brazilian_wood_plant,"Brazilian Wood Plant",499,"Small",1);
            }
        });

        h_pp_cart_click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onCartClick(R.drawable.peacock_plant,"Peacock Plant",699,"Small",1);
            }
        });


        List<Integer> imgs = Arrays.asList(
                R.drawable.carousel_img_1,
                R.drawable.carousel_img_2,
                R.drawable.carousel_img_3,
                R.drawable.carousel_img_4,
                R.drawable.carousel_img_5
        );

        CarouselAdapter c = new CarouselAdapter(this, imgs);
        vp.setAdapter(c);

        ViewPager2 viewPager2 = findViewById(R.id.vp);
        tabLayout = findViewById(R.id.tabLayout);

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                for (int i = 0; i < tabLayout.getTabCount(); i++) {
                    View tabView = tabLayout.getTabAt(i).getCustomView();
                    if (tabView instanceof ImageView) {
                        ((ImageView) tabView).setImageResource(i == position ? R.drawable.dot_active : R.drawable.dot_inactive);
                    }
                }
            }
        });

        // Link dots with ViewPager2
        new TabLayoutMediator(tabLayout, viewPager2, (tab, position) -> {
            tab.setCustomView(getTabView(position));
        }).attach();

        runnable = new Runnable() {
            @Override
            public void run() {
                if (currentPage == c.getItemCount()) {
                    currentPage = 0;
                }
                vp.setCurrentItem(currentPage++, true);
                handler.postDelayed(runnable, 3000);
            }
        };
        handler.postDelayed(runnable, 3000);

        search_icon = findViewById(R.id.search_icon);
        cart_icon = findViewById(R.id.cart_icon);

        search_icon.setOnClickListener(v -> {
            main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
            Intent i = new Intent(getApplicationContext(),search.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });

        cart_icon.setOnClickListener(v -> {
            main.performHapticFeedback(HapticFeedbackConstants.CONTEXT_CLICK);
            Intent i = new Intent(getApplicationContext(),cart.class);
            startActivity(i);
            overridePendingTransition(R.anim.fade_in,R.anim.fade_out);
        });

        tools.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
                Intent i = new Intent(getApplicationContext(), tools.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        bestsellers.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
                Intent i = new Intent(getApplicationContext(), bestsellers.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        easy_to_care.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
                Intent i = new Intent(getApplicationContext(), easy_to_care.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        seeds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
                Intent i = new Intent(getApplicationContext(), seeds.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });

        pots.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.performHapticFeedback(HapticFeedbackConstants.CLOCK_TICK);
                Intent i = new Intent(getApplicationContext(), pots.class);
                startActivity(i);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
            }
        });


        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.shop) {
                    Intent i = new Intent(getApplicationContext(), shop.class);
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

    }

    private View getTabView(int position) {
        ImageView dot = new ImageView(this);

        // Reduce the size of dots (optional)
        int dotSize = 30; // Change this for smaller/larger dots

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(dotSize, dotSize);
        params.setMargins(0, 0, 0, 0); // Adjust margins to reduce spacing
        dot.setLayoutParams(params);

        dot.setImageResource(R.drawable.dot_inactive); // Default: Inactive dot
        return dot;
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
        finishAffinity();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
    @Override
    protected void onResume() {
        super.onResume();
        bnv.setSelectedItemId(R.id.home);
    }
}
package com.example.plantify;

import android.annotation.SuppressLint;
import android.graphics.Paint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class home extends AppCompatActivity {

    private Handler handler = new Handler(Looper.getMainLooper());
    private Runnable runnable;
    private ViewPager2 vp;
    int currentPage = 0;

    RadioGroup rg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        vp = findViewById(R.id.vp);

        List<Integer> imgs = Arrays.asList(
                R.drawable.carousel_img_1,
                R.drawable.carousel_img_2,
                R.drawable.carousel_img_1,
                R.drawable.carousel_img_2,
                R.drawable.carousel_img_1
        );

        CarouselAdapter c = new CarouselAdapter(this, imgs);
        vp.setAdapter(c);

        TextView priceText = findViewById(R.id.priceText);
        priceText.setPaintFlags(priceText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        @SuppressLint({"MissingInflatedId", "LocalSuppress"}) TextView priceText2 = findViewById(R.id.priceText2);
        priceText2.setPaintFlags(priceText.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);

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



    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}
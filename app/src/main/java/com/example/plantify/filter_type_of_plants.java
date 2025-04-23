package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class filter_type_of_plants extends AppCompatActivity {

    ImageView cross;
    AppCompatButton applyButton;
    TextView price,i_o,type_of_plants;
    FragmentTransaction ft;
    View v_top,v_p,v_io;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_filter_type_of_plants);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cross = findViewById(R.id.cross);
        price = findViewById(R.id.price);
        i_o = findViewById(R.id.i_o);
        type_of_plants = findViewById(R.id.type_of_plants);

        v_top = findViewById(R.id.v_top);
        v_p = findViewById(R.id.v_p);
        v_io = findViewById(R.id.v_io);

        i_o.setVisibility(View.GONE);

        type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));
        price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));

        ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragment,new filter_plants());
        ft.commit();

        type_of_plants.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                type_of_plants.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
                type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));
                price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_plants());
                ft.commit();
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        price.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                type_of_plants.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
                type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_price());
                ft.commit();
            }
        });

        i_o.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                type_of_plants.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
                type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_indoor_outdoor());
                ft.commit();
            }
        });

        Intent i = getIntent();
        String p = i.getStringExtra("page");
        try {
            Class<?> cl = Class.forName(p);
            if (cl == shop.class) {
                i_o.setVisibility(View.VISIBLE);
            } else if (cl == tools.class) {
                type_of_plants.setVisibility(View.GONE);
                ft.replace(R.id.fragment,new filter_price());
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        applyButton = findViewById(R.id.apply);
        applyButton.setOnClickListener(v -> {
            SharedPreferences preferences = getSharedPreferences("PlantFilterPrefs", MODE_PRIVATE);
            String page = getIntent().getStringExtra("page");

            Intent intent = new Intent(filter_type_of_plants.this, shop.class);
            try {
                Class<?> cls = Class.forName(page);
                intent = new Intent(filter_type_of_plants.this, cls);
                // add extras here
                startActivity(intent);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            };


            // Add selected values to intent
            intent.putExtra("air_plants", preferences.getBoolean("air_plants", false));
            intent.putExtra("flowering_plants", preferences.getBoolean("flowering_plants", false));
            intent.putExtra("climbers", preferences.getBoolean("climbers", false));
            intent.putExtra("min_price", preferences.getFloat("min_price", 100f));
            intent.putExtra("max_price", preferences.getFloat("max_price", 2000f));
            intent.putExtra("small_size", preferences.getBoolean("small_size", false));
            intent.putExtra("medium_size", preferences.getBoolean("medium_size", false));
            intent.putExtra("indoor", preferences.getBoolean("indoor", false));
            intent.putExtra("outdoor", preferences.getBoolean("outdoor", false));
            intent.putExtra("outdoor_shade_loving_plant", preferences.getBoolean("outdoor_shade_loving_plant", false));
            intent.putExtra("outdoor_sun_loving_plant", preferences.getBoolean("outdoor_sun_loving_plant", false));

            startActivity(intent);
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.HapticFeedbackConstants;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.FragmentTransaction;

public class filter_type_of_plants extends AppCompatActivity {

    ImageView cross;

    TextView price,size,i_o,type_of_plants;
    FragmentTransaction ft;
    View v_top,v_p,v_s,v_io;

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
        size = findViewById(R.id.size);
        i_o = findViewById(R.id.i_o);
        type_of_plants = findViewById(R.id.type_of_plants);

        v_top = findViewById(R.id.v_top);
        v_p = findViewById(R.id.v_p);
        v_s = findViewById(R.id.v_s);
        v_io = findViewById(R.id.v_io);


        type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));
        price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
        size.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
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
                size.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_s.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_plants());
                ft.commit();
            }
        });

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(filter_type_of_plants.this, shop.class));
            }
        });

        price.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                type_of_plants.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
                type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));
                size.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));
                v_s.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_price());
                ft.commit();
            }
        });

        size.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                type_of_plants.performHapticFeedback(HapticFeedbackConstants.KEYBOARD_PRESS);
                type_of_plants.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                price.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                size.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_s.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_size());
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
                size.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.black));
                i_o.setTextColor(ContextCompat.getColor(getApplicationContext(), R.color.theme));

                v_top.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_p.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_s.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.edit_text_stroke));
                v_io.setBackgroundColor(ContextCompat.getColor(getApplicationContext(),R.color.theme));

                ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment,new filter_indoor_outdoor());
                ft.commit();
            }
        });

    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(filter_type_of_plants.this, shop.class));
    }
}
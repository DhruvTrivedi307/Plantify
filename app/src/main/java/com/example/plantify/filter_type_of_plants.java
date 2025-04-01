package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class filter_type_of_plants extends AppCompatActivity {

    ImageView cross;

    TextView price,size,i_o;

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

        cross.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(filter_type_of_plants.this, shop.class));
            }
        });

        price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(filter_type_of_plants.this, filter_by_price.class));
            }
        });

        size.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(filter_type_of_plants.this, filter_by_size.class));
            }
        });

        i_o.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(filter_type_of_plants.this, filter_by_indoor_outdoor.class));
            }
        });


    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(filter_type_of_plants.this, shop.class));
    }
}
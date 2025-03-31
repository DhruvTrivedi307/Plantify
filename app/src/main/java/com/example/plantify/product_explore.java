package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class product_explore extends AppCompatActivity {

    ImageView productImg;
    TextView productName,productPrice,description,txtCount;
    Button buy_now,btnMinus,btnPlus;
    private int count = 1;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_explore);

        productImg = findViewById(R.id.productImg);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);
        description = findViewById(R.id.description);
        buy_now = findViewById(R.id.buy_now);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);

        Intent i = getIntent();

        if (i != null) {
            int img = i.getIntExtra("img", 0);
            String name = i.getStringExtra("name");
            int price = i.getIntExtra("price", 0);
            String desc = i.getStringExtra("description");

            if (img != 0) {
                productImg.setImageResource(img);
            }

            if (name != null) {
                productName.setText(name);
            } else {
                productName.setText("No Name Available");
            }

            if (desc != null) {
                description.setText(desc);
            } else {
                description.setText("No Description Available");
            }

            productPrice.setText("₹" + price);
        }

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count > 1) {
                    count--;
                    txtCount.setText(String.valueOf(count));
                }
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (count < 5) {
                    count++;
                    txtCount.setText(String.valueOf(count));
                }
            }
        });

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), checkout.class);
                startActivity(i);
            }
        });

    }
}
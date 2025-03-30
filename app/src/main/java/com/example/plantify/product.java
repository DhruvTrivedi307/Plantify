package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class product extends AppCompatActivity {

    ImageView productImg;
    TextView productName,productPrice;
    Button buy_now;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productImg = findViewById(R.id.productImg);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);

        buy_now = findViewById(R.id.buy_now);


        Intent i = getIntent();
        if (i != null) {
            int img = i.getIntExtra("img", 0);
            String name = i.getStringExtra("name");
            int price = i.getIntExtra("price", 0);

            if (img != 0) {
                productImg.setImageResource(img);
            }

            if (name != null) {
                productName.setText(name);
            } else {
                productName.setText("No Name Available");
            }

            productPrice.setText("₹" + price);
        }

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), checkout.class);
                startActivity(i);
            }
        });




    }
}
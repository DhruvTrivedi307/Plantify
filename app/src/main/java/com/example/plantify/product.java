package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        productImg = findViewById(R.id.productImg);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);


        Intent i = getIntent();
        if (i != null) {  // Check if intent is not null
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




    }
}
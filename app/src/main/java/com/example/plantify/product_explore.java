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

    ImageView productImg,back;
    TextView productName,productPrice,description,txtCount,pageName;
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
        pageName = findViewById(R.id.pageName);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);

        back = findViewById(R.id.back);

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

        Intent i = getIntent();

//        if (i != null) {
            int img = i.getIntExtra("img", 0);
            String name = i.getStringExtra("name");
            int price = i.getIntExtra("price", 0);
            String desc = i.getStringExtra("description");

            if (img != 0) {
                productImg.setImageResource(img);
            }

            if (name != null) {
                productName.setText(name);
                pageName.setText(name);
            } else {
                productName.setText("No Name Available");
            }

            if (desc != null) {
                description.setText(desc);
            } else {
                description.setText("No Description Available");
            }

            productPrice.setText("₹" + price);
//        }

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
                Intent i = new Intent(product_explore.this, checkout.class);
                i.putExtra("page","product");
                i.putExtra("img",img);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("size","Small");
                i.putExtra("qty", Integer.parseInt(txtCount.getText().toString()));
                startActivity(i);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }
}
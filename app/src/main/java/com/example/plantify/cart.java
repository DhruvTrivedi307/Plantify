package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class cart extends AppCompatActivity {

    Button btnMinus,btnPlus;
    TextView txtCount,item_name,item_price,item_size;
    private int count = 1;
    ImageView back,item_img;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);
        back = findViewById(R.id.back);

        item_img = findViewById(R.id.item_img);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
        item_size = findViewById(R.id.item_size);

        Intent i = getIntent();

        int img = i.getIntExtra("img", 0);
        String name = i.getStringExtra("name");
        int price = i.getIntExtra("price", 0);
        String size = i.getStringExtra("size");
        int qty = i.getIntExtra("qty", 0);

        if (img != 0) {
            item_img.setImageResource(img);
        }

        if (name != null) {
            item_name.setText(name);
            item_name.setText(name);
        } else {
            item_name.setText("No Name Available");
        }

        item_price.setText("₹" + price);

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

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }
}
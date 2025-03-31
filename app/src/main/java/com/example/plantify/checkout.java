package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class checkout extends AppCompatActivity {

    ImageView p_img;
    TextView p_name;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_checkout);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        p_img = findViewById(R.id.p_img);
        p_name = findViewById(R.id.p_name);

        Intent i = getIntent();
        int img = i.getIntExtra("img",0);
        String name = i.getStringExtra("name");
        int price = i.getIntExtra("price",0);
        String page = i.getStringExtra("page");

        if("product".equals(page)){
            p_img.setImageResource(img);
            p_name.setText(name);
        } else {
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
            finish();
        }

    }
}
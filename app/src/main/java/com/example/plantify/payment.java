package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class payment extends AppCompatActivity {

    EditText e_fname,e_lname,e_mono,e_email,e_pincode,e_city,e_state,e_add1,e_add2;
    TextView grandtotalPrice,subtotalPrice,bottomnavPrice;
    AppCompatButton checkout;
    ProgressBar loading,loading2;
    ImageView logo;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        subtotalPrice = findViewById(R.id.subtotalPrice);
        grandtotalPrice = findViewById(R.id.grandtotalPrice);
        bottomnavPrice = findViewById(R.id.bottomnavPrice);

        e_fname = findViewById(R.id.e_fname);
        e_lname = findViewById(R.id.e_lname);
        e_mono = findViewById(R.id.e_mono);
        e_email = findViewById(R.id.e_email);
        e_pincode = findViewById(R.id.e_pincode);
        e_city = findViewById(R.id.e_city);
        e_state = findViewById(R.id.e_state);
        e_add1 = findViewById(R.id.e_add1);
        e_add2 = findViewById(R.id.e_add2);
        checkout = findViewById(R.id.checkout);
        loading = findViewById(R.id.loading);
        loading2 = findViewById(R.id.loading2);
        logo = findViewById(R.id.logo);

        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Intent i = getIntent();
        String fname = i.getStringExtra("fname");
        String lname = i.getStringExtra("lname");
        String mono = i.getStringExtra("mono");
        String email = i.getStringExtra("email");
        String pin_code = i.getStringExtra("pin_code");
        String city = i.getStringExtra("city");
        String state = i.getStringExtra("state");
        String add1 = i.getStringExtra("add1");
        String add2 = i.getStringExtra("add2");

        int totalPrice = i.getIntExtra("totalPrice",1);

        e_fname.setText(fname);
        e_lname.setText(lname);
        e_mono.setText(mono);
        e_email.setText(email);
        e_pincode.setText(pin_code);
        e_city.setText(city);
        e_state.setText(state);
        e_add1.setText(add1);
        e_add2.setText(add2);
        subtotalPrice.setText("₹"+totalPrice);
        grandtotalPrice.setText("₹"+totalPrice);
        bottomnavPrice.setText("₹"+totalPrice);

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading.setVisibility(View.VISIBLE);
                loading2.setVisibility(View.VISIBLE);
                new Handler().postDelayed(() -> {
                    loading.setVisibility(View.GONE);
                    loading2.setVisibility(View.GONE);
                    Intent intent = new Intent(payment.this, payment_done.class);
                    startActivity(intent);
                    finish();
                }, 3000);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
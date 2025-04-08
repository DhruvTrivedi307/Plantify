package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class checkout extends AppCompatActivity {

    TextView subtotalPrice,grandtotalPrice,bottomnavPrice,Plantsize;
    EditText fname,lname,mono,email,pin_code,city,state,add1,add2;
    AppCompatButton checkout;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);
        subtotalPrice = findViewById(R.id.subtotalPrice);
        grandtotalPrice = findViewById(R.id.grandtotalPrice);
        bottomnavPrice = findViewById(R.id.bottomnavPrice);
        Plantsize = findViewById(R.id.size);
        // Contact Information
        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        mono = findViewById(R.id.mono);
        email = findViewById(R.id.email);
        pin_code = findViewById(R.id.pin_code);
        city = findViewById(R.id.city);
        state = findViewById(R.id.state);
        add1 = findViewById(R.id.add1);
        add2 = findViewById(R.id.add2);
        checkout = findViewById(R.id.checkout);


        Intent i = getIntent();
//        int img = i.getIntExtra("img",0);
//        String name = i.getStringExtra("name");
        int price = i.getIntExtra("price",0);
//        String page = i.getStringExtra("page");
        int qty = i.getIntExtra("qty",1);
//        String size = i.getStringExtra("size");
        int totalPrice = qty*price;


//        if("product".equals(page)){
//            p_img.setImageResource(img);
//            p_name.setText(name);
//            quantity.setText(String.valueOf(qty));
            subtotalPrice.setText(String.valueOf("₹"+totalPrice));
            grandtotalPrice.setText(String.valueOf("₹"+totalPrice));
            bottomnavPrice.setText(String.valueOf("₹"+totalPrice));
//            Plantsize.setText(String.valueOf(size));
//        } else {
//            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
//            finish();
//        }

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(fname.getText().toString().trim().isEmpty() || lname.getText().toString().trim().isEmpty() || mono.getText().toString().trim().isEmpty() || email.getText().toString().trim().isEmpty() || pin_code.getText().toString().trim().isEmpty() || city.getText().toString().trim().isEmpty() || state.getText().toString().trim().isEmpty() || add1.getText().toString().trim().isEmpty()){
                    Toast.makeText(checkout.this, "Please first fill all details", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(checkout.this, payment.class);
                    i.putExtra("fname",fname.getText().toString().trim());
                    i.putExtra("lname",lname.getText().toString().trim());
                    i.putExtra("mono",mono.getText().toString().trim());
                    i.putExtra("email",email.getText().toString().trim());
                    i.putExtra("pin_code",pin_code.getText().toString().trim());
                    i.putExtra("city",city.getText().toString().trim());
                    i.putExtra("state",state.getText().toString().trim());
                    i.putExtra("add1",add1.getText().toString().trim());
                    i.putExtra("add2",add2.getText().toString().trim());
                    i.putExtra("totalPrice", totalPrice);
                    startActivity(i);
                }
            }
        });


    }
}
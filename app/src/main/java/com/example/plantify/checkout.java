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
        int price = i.getIntExtra("price",0);
        int qty = i.getIntExtra("qty",1);
        int totalPrice = qty*price;

        subtotalPrice.setText(String.valueOf("₹"+totalPrice));
        grandtotalPrice.setText(String.valueOf("₹"+totalPrice));
        bottomnavPrice.setText(String.valueOf("₹"+totalPrice));

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = fname.getText().toString().trim();
                String lastName = lname.getText().toString().trim();
                String mobileNumber = mono.getText().toString().trim();
                String emailAddress = email.getText().toString().trim();
                String pinCode = pin_code.getText().toString().trim();
                String cityName = city.getText().toString().trim();
                String stateName = state.getText().toString().trim();
                String address1 = add1.getText().toString().trim();
                String address2 = add2.getText().toString().trim();

                if (firstName.isEmpty() || lastName.isEmpty() || mobileNumber.isEmpty() ||
                    emailAddress.isEmpty() || pinCode.isEmpty() || cityName.isEmpty() ||
                    stateName.isEmpty() || address1.isEmpty()) {
                    Toast.makeText(checkout.this, "Please fill all required details", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
                    email.setError("Invalid email format");
                    return;
                }

                if (mobileNumber.length() != 10 || !mobileNumber.matches("\\d+")) {
                    mono.setError("Enter a valid 10-digit mobile number");
                    return;
                }

                if (pinCode.length() != 6 || !pinCode.matches("\\d+")) {
                    pin_code.setError("Enter a valid 6-digit PIN code");
                    return;
                }

                Intent i = new Intent(checkout.this, payment.class);
                i.putExtra("fname", firstName);
                i.putExtra("lname", lastName);
                i.putExtra("mono", mobileNumber);
                i.putExtra("email", emailAddress);
                i.putExtra("pin_code", pinCode);
                i.putExtra("city", cityName);
                i.putExtra("state", stateName);
                i.putExtra("add1", address1);
                i.putExtra("add2", address2);
                i.putExtra("totalPrice", totalPrice);
                startActivity(i);
            }
        });
    }
}
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
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class cart_explore extends AppCompatActivity {

    Button btnMinus,btnPlus;
    TextView txtCount,item_name,item_price,item_size,empty;
    private int count = 1;
    ImageView back,item_img;
    RecyclerView recyclerView;
    TextView subTotalPrice,grandTotalPrice,checkoutPrice;

    AppCompatButton checkout;

    int totalPrice = 0;

//    int[] item_images = {R.drawable.peacock_plant, R.drawable.brazilian_wood_plant, R.drawable.money_plant_golden};
//    int[] item_prices = {499, 899, 479};
//    String[] item_names = {"Peacock Plant", "Brazilian Wood Plant", "Money Plant Golden"};
//    String[] item_sizes = {"Small", "Medium", "Large"};
//    int[] item_quantities = {1, 1, 1};

    static ArrayList<Integer> img = new ArrayList<>();
    static ArrayList<Integer> price = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    static ArrayList<String> size = new ArrayList<>();
    static ArrayList<Integer> qty = new ArrayList<>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart_explore);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);
        back = findViewById(R.id.back);

        item_img = findViewById(R.id.item_img);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
        item_size = findViewById(R.id.item_size);

        checkout = findViewById(R.id.checkout);

        recyclerView = findViewById(R.id.cart_e);

        empty = findViewById(R.id.empty);

        subTotalPrice = findViewById(R.id.subTotalPrice);
        grandTotalPrice = findViewById(R.id.grandTotalPrice);
        checkoutPrice = findViewById(R.id.checkoutPrice);



//        cart_item c = new cart_item(item_images, item_prices, item_names, item_sizes, item_quantities);

//        recyclerView.setAdapter(c);

        Intent i = getIntent();


        if (i.getStringExtra("name") == null) {

        } else {
            String productName = i.getStringExtra("name");

            if (name.contains(productName)) {
                int index = name.indexOf(productName);
                int currentQty = qty.get(index);

                if (currentQty < 5) {
                    qty.set(index, currentQty + 1);
                }
            } else {
                img.add(i.getIntExtra("img", 0));
                name.add(productName);
                price.add(i.getIntExtra("price", 0));
                size.add(i.getStringExtra("size"));
                qty.add(i.getIntExtra("qty", 0));
            }
        }


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(cart_explore.this, checkout.class);
                i.putExtra("page","product");
                i.putExtra("img",img);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("size","Small");
                i.putExtra("qty", Integer.parseInt(txtCount.getText().toString()));
                startActivity(i);
            }
        });


        for (int p : price) {
            totalPrice += p;
        }



        subTotalPrice.setText(String.valueOf(totalPrice));
        grandTotalPrice.setText(String.valueOf(totalPrice));
        checkoutPrice.setText(String.valueOf(totalPrice));


        cart_item_explore c = new cart_item_explore(img, price, name, qty);
        c.setOnQuantityChangeListener(new cart_item_explore.OnQuantityChangeListener() {
            @Override
            public void onQuantityChanged() {
                updateTotalPrice();
            }
        });
//        c.setOnQuantityChangeListener(new cart_item_explore() {
//            @Override
//            public void onQuantityChanged() {
//                updateTotalPrice();
//            }
//        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(c);

    }

    private void updateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            totalPrice += price.get(i) * qty.get(i);
        }

        subTotalPrice.setText("₹"+String.valueOf(totalPrice));
        grandTotalPrice.setText("₹"+String.valueOf(totalPrice));
        checkoutPrice.setText("₹"+String.valueOf(totalPrice));
    }
}
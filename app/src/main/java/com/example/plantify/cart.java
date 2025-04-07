package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class cart extends AppCompatActivity {

    Button btnMinus,btnPlus;
    TextView txtCount,item_name,item_price,item_size,empty;
    private int count = 1;
    ImageView back,item_img;
    RecyclerView recyclerView;
    TextView subTotalPrice,grandTotalPrice,checkoutPrice;

    int totalPrice = 0;
    int totalQty = 0;

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
        setContentView(R.layout.activity_cart);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);
        back = findViewById(R.id.back);

        item_img = findViewById(R.id.item_img);
        item_name = findViewById(R.id.item_name);
        item_price = findViewById(R.id.item_price);
        item_size = findViewById(R.id.item_size);

        recyclerView = findViewById(R.id.cart);

        empty = findViewById(R.id.empty);

        subTotalPrice = findViewById(R.id.subTotalPrice);
        grandTotalPrice = findViewById(R.id.grandTotalPrice);
        checkoutPrice = findViewById(R.id.checkoutPrice);

//        cart_item c = new cart_item(item_images, item_prices, item_names, item_sizes, item_quantities);

//        recyclerView.setAdapter(c);

        Intent i = getIntent();


        if(i.getStringExtra("name") == null){

        } else {
            img.add(i.getIntExtra("img", 0));
            name.add(i.getStringExtra("name"));
            price.add(i.getIntExtra("price", 0));
            size.add(i.getStringExtra("size"));
            qty.add(i.getIntExtra("qty", 0));
        }

        for (int p : price) {
            totalPrice += p;
        }



        subTotalPrice.setText(String.valueOf(totalPrice));
        grandTotalPrice.setText(String.valueOf(totalPrice));
        checkoutPrice.setText(String.valueOf(totalPrice));

//        img.(i.getIntExtra("img", 0));
//        item_price.append(String.valueOf(price));
//        item_size.append(size);
//        item_images.append(String.valueOf(img));
//        txtCount.setText(String.valueOf(qty));


//        cart_item c = new cart_item(img, price, name, size, qty);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        recyclerView.setAdapter(c);

        cart_item c = new cart_item(img, price, name, size, qty);
        c.setOnQuantityChangeListener(new cart_item.OnQuantityChangeListener() {
            @Override
            public void onQuantityChanged() {
                updateTotalPrice();
            }
        });

        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setAdapter(c);



    }

    private void updateTotalPrice() {
        int totalPrice = 0;
        for (int i = 0; i < price.size(); i++) {
            totalPrice += price.get(i) * qty.get(i); // Multiply price by quantity
        }

        subTotalPrice.setText("₹"+String.valueOf(totalPrice));
        grandTotalPrice.setText("₹"+String.valueOf(totalPrice));
        checkoutPrice.setText("₹"+String.valueOf(totalPrice));
    }
}
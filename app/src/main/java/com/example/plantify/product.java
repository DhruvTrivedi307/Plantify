package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class product extends AppCompatActivity {

    ImageView productImg,back;
    TextView productName,productPrice,txtCount;
    Button btnMinus,btnPlus;
    AppCompatButton small,medium;
    private String selectedSize = "";
    private int count = 1;
    TextView size,description,pageName;
    AppCompatButton buy_now, add_to_cart;

    LinearLayout p_bhp,p_jmp,p_bwp,p_pp,p_fbp,p_lbp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        productImg = findViewById(R.id.productImg);
        productName = findViewById(R.id.productName);
        productPrice = findViewById(R.id.productPrice);

        buy_now = findViewById(R.id.buy_now);

        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        txtCount = findViewById(R.id.txtCount);

        small = findViewById(R.id.small);
        medium = findViewById(R.id.medium);
        size = findViewById(R.id.size);
        description = findViewById(R.id.description);
        pageName = findViewById(R.id.pageName);
        add_to_cart = findViewById(R.id.add_to_cart);

        p_bhp = findViewById(R.id.p_bhp);
        p_jmp = findViewById(R.id.p_jmp);
        p_bwp = findViewById(R.id.p_bwp);
        p_pp = findViewById(R.id.p_pp);
        p_fbp = findViewById(R.id.p_fbp);
        p_lbp = findViewById(R.id.p_lbp);


        p_bhp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.broken_heart_plant,"Broken Heart Plant",499,"One of the most popular houseplants, and our all-time bestseller, this easy-growing plant with its heart-shaped leaves is loved for its beautiful fenestrations. Quick to grow with delicate trailing vines that can be styled for every space, the Philodendron broken heart is the monstera charm you want to add to your home if you don't have the space for the huge monstera. Scientifically known as the Monstera adansonii, this broken heart plant thrives indoors in bright indirect light and with very little care.");
            }
        });

        p_jmp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.jade_mini_plats,"Jade Mini Plant",499,"An easy-to-care-for succulent, the Crassula Green Mini boasts lush foliage that enhances any room. Its coin-like round plump leaves are considered lucky in Feng Shui.");
            }
        });

        p_bwp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.brazilian_wood_plant,"Brazillian Wood Plant",499,"Also known as Dracaena fragrans, this plant has broad, arching leaves and is known for its air-purifying qualities. It thrives in low to medium light and requires moderate watering.");
            }
        });

        p_pp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.peacock_plant,"Peacock Plant",499,"Featuring decorative leaves with intricate patterns resembling a peacock’s tail, this plant prefers low to medium light and high humidity. It’s a stunning addition to any indoor plant collection.");
            }
        });

        p_fbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.ficus_bonsai_plant,"Ficus Bonsai Plant",499,"A miniature version of the traditional Ficus tree, this Bonsai adds a touch of tranquility to indoor spaces. It requires bright indirect light and regular watering to maintain its shape and health.");
            }
        });

        p_lbp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedirectProduct(R.drawable.lucky_bamboo_plant,"Lucky Bamboo Plant",499,"Symbolizing good fortune and prosperity, the Lucky Bamboo is easy to grow and can thrive in water or soil. It prefers indirect light and adds an elegant touch to any decor.");
            }
        });

        back = findViewById(R.id.back);

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




        small.setSelected(true);
        size.setText("Small");
        View.OnClickListener sizeClickListener = v -> {
            small.setSelected(false);
            medium.setSelected(false);
            v.setSelected(true);

            if (v == small) {
                selectedSize = "Small";
                size.setText(selectedSize);
            } else if (v == medium) {
                selectedSize = "Medium";
                size.setText(selectedSize);

            }

        };

        small.setOnClickListener(sizeClickListener);
        medium.setOnClickListener(sizeClickListener);

        Intent i = getIntent();

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


        if (cart_item.item_names != null && cart_item.item_quantities != null) {
            int index = cart_item.item_names.indexOf(name);
            if (index != -1) {
                count = cart_item.item_quantities.get(index);
                txtCount.setText(String.valueOf(count));
            } else {
                count = 1;
                txtCount.setText(String.valueOf(count));
            }
        }


        if (desc != null) {
            description.setText(desc);
        } else {
            description.setText("No Description Available");
        }

        productPrice.setText("₹" + price);

        buy_now.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), checkout.class);
                i.putExtra("page","product");
                i.putExtra("img",img);
                i.putExtra("name",name);
                i.putExtra("price",price);
                i.putExtra("size",selectedSize);
                i.putExtra("qty", Integer.parseInt(txtCount.getText().toString()));

                startActivity(i);
            }
        });

        back.setOnClickListener(view -> {
            finish();
        });

        add_to_cart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(product.this, cart.class);
                i.putExtra("img",img);
                i.putExtra("name", name);
                i.putExtra("price",price);
                i.putExtra("size","Small");
                i.putExtra("qty",1);
                startActivity(i);
            }
        });
    }

    public void RedirectProduct(int img,String name,int price,String desc){
        Intent i = new Intent(product.this,product.class);
        i.putExtra("img",img);
        i.putExtra("name",name);
        i.putExtra("price",price);
        i.putExtra("description",desc);
        startActivity(i);
    }
}
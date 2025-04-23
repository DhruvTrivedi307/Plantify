package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class profile_logout extends AppCompatActivity {
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView name,email,first_letter,second_letter;
    Button sign_out;
    BottomNavigationView bnv;
    FirebaseAuth auth;
    FirebaseUser user;
    private DatabaseReference userRef;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_logout);

        sign_out = findViewById(R.id.sign_out);
        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        first_letter = findViewById(R.id.first_letter);
        second_letter = findViewById(R.id.second_letter);

        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();

        if (user != null) {
            String userId = user.getUid();
            userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
        }

        if (userRef != null){
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    if (snapshot.exists()){
                        String f_name = snapshot.child("firstName").getValue(String.class);
                        String l_name = snapshot.child("lastName").getValue(String.class);
                        String email_id = snapshot.child("email").getValue(String.class);
                        name.setText(f_name+",");
                        String fl = String.valueOf(f_name.charAt(0));
                        String sl = String.valueOf(l_name.charAt(0));
                        email.setText(email_id);
                        first_letter.setText(fl);
                        second_letter.setText(sl);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {

                }
            });
        }

        sign_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                gsc.signOut().addOnCompleteListener(task -> {
                    Intent i = new Intent(getApplicationContext(),profile_signin.class);
                    startActivity(i);
                    finish();
                });
            }
        });

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct != null){
            String personName = acct.getDisplayName();
            String[] parts = personName.split(" ",2);
            String firstName = parts[0];
            String lastName = parts[1];
            String personEmail = acct.getEmail();
            first_letter.setText(String.valueOf(firstName.charAt(0)));
            second_letter.setText(String.valueOf(lastName.charAt(0)));
            name.setText(firstName+",");
            email.setText(personEmail);
        }

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

//        sign_out.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                signOut();
//            }
//        });

        bnv = findViewById(R.id.bnv);

        bnv.setSelectedItemId(R.id.profile);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Intent i = new Intent(getApplicationContext(), home.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                } else if (item.getItemId() == R.id.shop) {
                    Intent i = new Intent(getApplicationContext(), shop.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                } else if (item.getItemId() == R.id.trending) {
                    Intent i = new Intent(getApplicationContext(), trending.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                } else if (item.getItemId() == R.id.profile) {
                    Intent i = new Intent(getApplicationContext(), profile_logout.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                }
                return true;
            }
        });

    }
}
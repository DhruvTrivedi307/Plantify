package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

public class profile extends AppCompatActivity {
    private DatabaseReference userRef;
    private FirebaseAuth mAuth;

    EditText fname, lname, phone_no, email_id;
    AppCompatButton save;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        // Initialize Firebase Auth and Database Reference
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();

        if (user != null) {
            String userId = user.getUid();
            userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);
        }

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        phone_no = findViewById(R.id.phone_no);
        email_id = findViewById(R.id.email);

        if (userRef != null) {
            userRef.addListenerForSingleValueEvent(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    if (dataSnapshot.exists()) {
                        String firstName = dataSnapshot.child("firstName").getValue(String.class);
                        String lastName = dataSnapshot.child("lastName").getValue(String.class);
                        String phone = dataSnapshot.child("phone").getValue(String.class);
                        String email = dataSnapshot.child("email").getValue(String.class);

                        fname.setText(firstName);
                        lname.setText(lastName);
                        phone_no.setText(phone);
                        email_id.setText(email);
                    }
                }

                @Override
                public void onCancelled(DatabaseError databaseError) {
                }
            });
        }

        save = findViewById(R.id.save);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updatedFirstName = fname.getText().toString().trim();
                String updatedLastName = lname.getText().toString().trim();
                String updatedPhone = phone_no.getText().toString().trim();
                String updatedEmail = email_id.getText().toString().trim();

                if (userRef != null) {
                    userRef.child("firstName").setValue(updatedFirstName);
                    userRef.child("lastName").setValue(updatedLastName);
                    userRef.child("phone").setValue(updatedPhone);
                    userRef.child("email").setValue(updatedEmail)
                        .addOnCompleteListener(task -> {
                            if (task.isSuccessful()) {
                                Toast.makeText(profile.this, "Profile updated successfully!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(getApplicationContext(), profile_logout.class);
                                startActivity(i);
                                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                                finish();
                            } else {
                                Toast.makeText(profile.this, "Failed to update profile.", Toast.LENGTH_SHORT).show();
                            }
                        });
                }
            }
        });

    }
}
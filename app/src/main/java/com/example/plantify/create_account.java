package com.example.plantify;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class create_account extends AppCompatActivity {
    EditText passwordEditText;
    CheckBox toggleCheckBox;
    ImageView sign_in;
    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    EditText fname, lname, phone, email, password;
    CheckBox toggle;
    AppCompatButton createAccount;
    DatabaseHelper dbHelper;
    FirebaseAuth mAuth;
    TextView signin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        passwordEditText = findViewById(R.id.password);
        toggleCheckBox = findViewById(R.id.toggle);
        sign_in = findViewById(R.id.sign_in);
        signin = findViewById(R.id.signin);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        phone = findViewById(R.id.phone_no);
        email = findViewById(R.id.email_id);
        password = findViewById(R.id.password);
        toggle = findViewById(R.id.toggle);
        createAccount = findViewById(R.id.createAccount);

        mAuth = FirebaseAuth.getInstance();

        // Initialize Database Helper
//        dbHelper = new DatabaseHelper(this);

        // Password Toggle Feature
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                password.setTransformationMethod(null); // Show password
            } else {
                password.setTransformationMethod(new android.text.method.PasswordTransformationMethod()); // Hide password
            }
        });

//         Handle Create Account Button Click
        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String f_name = fname.getText().toString().trim();
                String l_name = lname.getText().toString().trim();
                String phone_n = phone.getText().toString().trim();
                String email_id = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (f_name.isEmpty() || l_name.isEmpty() || phone_n.isEmpty() || email_id.isEmpty() || pass.isEmpty()) {
                    Toast.makeText(create_account.this, "Please enter all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.createUserWithEmailAndPassword(email_id, pass)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null) {
                                        String userId = user.getUid();
                                        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference("users").child(userId);

                                        // Create a HashMap to store user details
                                        HashMap<String, String> userData = new HashMap<>();
                                        userData.put("firstName", f_name);
                                        userData.put("lastName", l_name);
                                        userData.put("phone", phone_n);
                                        userData.put("email", email_id);

                                        userRef.setValue(userData).addOnCompleteListener(task1 -> {
                                            if (task1.isSuccessful()) {
//                                                Toast.makeText(create_account.this, "Account created successfully!", Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(create_account.this, "Failed to store user data.", Toast.LENGTH_SHORT).show();
                                            }
                                        });
                                    }
                                    Toast.makeText(create_account.this, "Success!", Toast.LENGTH_SHORT).show();

                                } else {

                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    Toast.makeText(getApplicationContext(), "Authentication failed.",
                                            Toast.LENGTH_SHORT).show();

                                }
                            }
                        });
            }
        });

        toggleCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct != null){
            finish();
            Intent i = new Intent(getApplicationContext(),profile_logout.class);
            startActivity(i);
        }

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(),profile_signin.class);
                startActivity(i);
            }
        });
    }

//    private void registerUser() {
//        String firstName = fname.getText().toString().trim();
//        String lastName = lname.getText().toString().trim();
//        String phoneNumber = phone.getText().toString().trim();
//        String emailId = email.getText().toString().trim();
//        String pass = password.getText().toString().trim();
//
//        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || emailId.isEmpty() || pass.isEmpty()) {
//            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
//        } else {
//            boolean isInserted = dbHelper.insertUser(firstName, lastName, phoneNumber, emailId, pass);
//            if (isInserted) {
//                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, profile_signin.class); // Redirect to Login
//                startActivity(intent);
//                finish();
//            } else {
//                Toast.makeText(this, "Error: Could not create account", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }


    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(create_account.this,profile_logout.class);
            startActivity(i);
            finish();
        }
    }

    public void signIn(){
        Intent signInInten = gsc.getSignInIntent();
        startActivityForResult(signInInten,1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                task.getResult(ApiException.class);
                finish();
                Intent i = new Intent(getApplicationContext(),profile_logout.class);
                startActivity(i);
            } catch (ApiException e){
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
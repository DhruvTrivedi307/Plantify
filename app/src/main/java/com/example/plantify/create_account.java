package com.example.plantify;

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

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        passwordEditText = findViewById(R.id.password);
        toggleCheckBox = findViewById(R.id.toggle);
        sign_in = findViewById(R.id.sign_in);

        fname = findViewById(R.id.fname);
        lname = findViewById(R.id.lname);
        phone = findViewById(R.id.phone_no);
        email = findViewById(R.id.email_id);
        password = findViewById(R.id.password);
        toggle = findViewById(R.id.toggle);
        createAccount = findViewById(R.id.createAccount);

        // Initialize Database Helper
        dbHelper = new DatabaseHelper(this);

        // Password Toggle Feature
        toggle.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                password.setTransformationMethod(null); // Show password
            } else {
                password.setTransformationMethod(new android.text.method.PasswordTransformationMethod()); // Hide password
            }
        });

//         Handle Create Account Button Click
        createAccount.setOnClickListener(view -> registerUser());

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
    }

    private void registerUser() {
        String firstName = fname.getText().toString().trim();
        String lastName = lname.getText().toString().trim();
        String phoneNumber = phone.getText().toString().trim();
        String emailId = email.getText().toString().trim();
        String pass = password.getText().toString().trim();

        if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || emailId.isEmpty() || pass.isEmpty()) {
            Toast.makeText(this, "Please fill all fields", Toast.LENGTH_SHORT).show();
        } else {
            boolean isInserted = dbHelper.insertUser(firstName, lastName, phoneNumber, emailId, pass);
            if (isInserted) {
                Toast.makeText(this, "Account Created Successfully", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, profile_signin.class); // Redirect to Login
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(this, "Error: Could not create account", Toast.LENGTH_SHORT).show();
            }
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
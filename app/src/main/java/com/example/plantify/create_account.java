package com.example.plantify;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class create_account extends AppCompatActivity {
    EditText passwordEditText;
    CheckBox toggleCheckBox;


    private EditText fname, lname, phone, email, password;
    private CheckBox toggle;
    private Button createAccount;
    private DatabaseHelper dbHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_create_account);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        passwordEditText = findViewById(R.id.password);
        toggleCheckBox = findViewById(R.id.toggle);

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

        // Handle Create Account Button Click
        createAccount.setOnClickListener(view -> registerUser());

        toggleCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
            } else {
                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
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


}
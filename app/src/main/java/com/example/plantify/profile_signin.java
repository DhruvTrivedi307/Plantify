package com.example.plantify;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.HapticFeedbackConstants;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class profile_signin extends AppCompatActivity {

    BottomNavigationView bnv;

    LinearLayout sign_in;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;
    TextView create_account;

    EditText password,email;
//    CheckBox toggleCheckBox;
    FirebaseAuth mAuth;
    AppCompatButton login;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile_signin);

        sign_in = findViewById(R.id.sign_in);
        create_account = findViewById(R.id.create_account);
        gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        gsc = GoogleSignIn.getClient(this, gso);

        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        mAuth = FirebaseAuth.getInstance();

        GoogleSignInAccount acct = GoogleSignIn.getLastSignedInAccount(this);
        if(acct != null){
            finish();
            Intent i = new Intent(profile_signin.this,profile_logout.class);
            startActivity(i);
        }

        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

        create_account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(profile_signin.this,create_account.class));
            }
        });

//        passwordEditText = findViewById(R.id.password_toggle);
//        toggleCheckBox = findViewById(R.id.toggle);
//
//        toggleCheckBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
//            if (isChecked) {
//                passwordEditText.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
//            } else {
//                passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance());
//            }
//        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email_id = email.getText().toString().trim();
                String pass = password.getText().toString().trim();

                if (email_id.isEmpty() || pass.isEmpty()){
                    Toast.makeText(profile_signin.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                mAuth.signInWithEmailAndPassword(email_id, pass)
                        .addOnCompleteListener( new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in success, update UI with the signed-in user's information
//                                    Log.d(TAG, "signInWithEmail:success");
//                                    FirebaseUser user = mAuth.getCurrentUser();
                                    Intent i = new Intent(profile_signin.this,profile_logout.class);
                                    startActivity(i);
                                    finish();
                                } else {
                                    // If sign in fails, display a message to the user.
                                    Log.w(TAG, "signInWithEmail:failure", task.getException());
                                    Toast.makeText(profile_signin.this, "Please Create your Account First ", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        bnv = findViewById(R.id.bnv);

        bnv.setSelectedItemId(R.id.profile);

        bnv.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if (item.getItemId() == R.id.home) {
                    Intent i = new Intent(getApplicationContext(), home.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    return true;
                } else if (item.getItemId() == R.id.shop) {
                    Intent i = new Intent(getApplicationContext(), shop.class);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    return true;
                } else if (item.getItemId() == R.id.trending) {
                    Intent i = new Intent(getApplicationContext(), trending.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    bnv.performHapticFeedback(HapticFeedbackConstants.VIRTUAL_KEY);
                    return true;
                }
                return true;
            }
        });

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

    }

    public void signIn(){
        Intent signInInten = gsc.getSignInIntent();
        startActivityForResult(signInInten,1000);
    }

    @Override
    public void onStart() {
        super.onStart();
        //// Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser != null){
            Intent i = new Intent(profile_signin.this,profile_logout.class);
            startActivity(i);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 1000){
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);

            try{
                task.getResult(ApiException.class);
                finish();
                Intent i = new Intent(profile_signin.this,profile_logout.class);
                startActivity(i);
            } catch (ApiException e){
                Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(0, R.anim.fade_out);
    }
}
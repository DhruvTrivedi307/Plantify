package com.example.plantify;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class payment_done extends AppCompatActivity {

    VideoView payment;
    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_done);

        payment = findViewById(R.id.payment);

        String path = "android.resource://"+getPackageName()+"/"+R.raw.payment;
        Uri uri = Uri.parse(path);
        payment.setVideoURI(uri);
        payment.start();

        new Handler().postDelayed(() -> {
            startActivity(new Intent(this, home.class));
            finish();
        }, SPLASH_TIME_OUT);

        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION |View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );

    }
}
package com.thesis.protocode;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.thesis.protocode.main.nav_drawer;

public class splashscreen extends AppCompatActivity {
    PlayGifView mGifView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(splashscreen.this, nav_drawer.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }
}

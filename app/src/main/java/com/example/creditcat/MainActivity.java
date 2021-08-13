package com.example.creditcat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    Button btnBuyCat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuyCat = findViewById(R.id.btnBuyCat);
        btnBuyCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Increment cat num
                // Spawn Cat
                ImageView iv = new ImageView( MainActivity.this );
                Glide.with(MainActivity.this)
                        .load(R.drawable.cat)
                        .override(150,150)
                        .into(iv);
                // iv.setBackgroundResource( R.drawable.cathead);
                ViewGroup view = (ViewGroup) findViewById(R.id.my_container_id_in_my_layout);
                view.addView(iv);

            }
        });
    }
}
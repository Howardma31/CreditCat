package com.example.creditcat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.parse.Parse;
import com.parse.ParseUser;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";
    TextView tvCoinNum;
    Button btnBuyCat;
    Button btnTasks;
    int currentCatNum;
    int currentCoinNum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvCoinNum = findViewById(R.id.tvCoinNum);
        currentCatNum = ParseUser.getCurrentUser().getInt("catNum");
        currentCoinNum = ParseUser.getCurrentUser().getInt("coinNum");
        btnBuyCat = findViewById(R.id.btnBuyCat);
        tvCoinNum.setText("Coin Number: " + String.valueOf(currentCoinNum));
        btnBuyCat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentCoinNum >= 100) {
                    // Increment and update cat&coin num
                    ParseUser.getCurrentUser().put("catNum", ++currentCatNum);
                    currentCoinNum -= 100;
                    ParseUser.getCurrentUser().put("coinNum", currentCoinNum);
                    currentCatNum = ParseUser.getCurrentUser().getInt("catNum");
                    currentCoinNum = ParseUser.getCurrentUser().getInt("coinNum");
                    tvCoinNum.setText("Coin Number: " + String.valueOf(currentCoinNum));

                    // Spawn Cat
                    spawnCat();
                } else {
                    Toast.makeText(MainActivity.this, "You need 100 coins to get a new cat!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnTasks = findViewById(R.id.btnTasks);
        btnTasks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TaskActivity.class);
                MainActivity.this.startActivity(i);
            }
        });

        for (int i = 0; i < currentCatNum; i++) {
            //spawnCat();
        }
    }

    private void spawnCat () {
        ImageView iv = new ImageView( MainActivity.this );
        Glide.with(MainActivity.this)
                .load(R.drawable.cat)
                .override(150,150)
                .into(iv);
        ViewGroup view = (ViewGroup) findViewById(R.id.my_container_id_in_my_layout);
        view.addView(iv);
    }
}
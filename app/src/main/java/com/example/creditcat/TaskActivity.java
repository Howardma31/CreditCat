package com.example.creditcat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.parse.ParseUser;

import bolts.Task;

public class TaskActivity extends AppCompatActivity {

    Button btnReturn;
    Button btnClaim;
    int currentCoinNum;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task);
        currentCoinNum = ParseUser.getCurrentUser().getInt("coinNum");

        btnClaim = findViewById(R.id.btnClaim);
        btnClaim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentCoinNum += 100;
                ParseUser.getCurrentUser().put("coinNum", currentCoinNum);
                Toast.makeText(TaskActivity.this, "Claimed Reward", Toast.LENGTH_SHORT).show();
            }
        });

        btnReturn = findViewById(R.id.btnReturn);
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(TaskActivity.this, MainActivity.class);
                TaskActivity.this.startActivity(i);
            }
        });
    }
}

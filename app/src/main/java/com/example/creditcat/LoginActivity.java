package com.example.creditcat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = etUsername.getText().toString();
                String passWord = etPassword.getText().toString();

                if (userName.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Sorry, your Username cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (passWord.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Sorry, your passWord cannot be empty", Toast.LENGTH_SHORT).show();
                    return;
                }
                Toast.makeText(LoginActivity.this, userName + passWord, Toast.LENGTH_SHORT).show();
            }
        });
    }
}

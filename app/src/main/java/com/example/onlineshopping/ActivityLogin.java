package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.onlineshopping.databinding.ActivityLoginBinding;

public class ActivityLogin extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.loginButton.setOnClickListener(view -> {

            if (binding.userEmail.getText().toString().equals("")){
                binding.userEmail.setError("Email can't be empty");
                return;
            }

            String userEmail = binding.userEmail.getText().toString();

            if (binding.userPassword.getText().toString().equals("")){
                binding.userPassword.setError("Password can't be empty");
                return;
            }

            String password = binding.userPassword.getText().toString();

            //TODO: Add login logic here

            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        });
    }
}
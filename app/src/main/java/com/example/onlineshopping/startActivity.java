package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.onlineshopping.databinding.ActivityRegisterBinding;
import com.example.onlineshopping.databinding.ActivityStartBinding;

public class startActivity extends AppCompatActivity {

    private ActivityStartBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.alreadyMemberButton.setOnClickListener(view -> {

            startActivity(new Intent(this,ActivityLogin.class));


        });

        binding.registerButton.setOnClickListener(view -> {
            startActivity(new Intent(this,RegisterActivity.class));


        });




    }


}
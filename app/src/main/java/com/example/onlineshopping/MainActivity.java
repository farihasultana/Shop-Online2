package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.example.onlineshopping.databinding.ActivityMainBinding;
import com.example.onlineshopping.databinding.ActivityRegisterBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<String> productList;
    RecyclerView recyclerView;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityRegisterBinding binding = null;
        setContentView(binding.getRoot());



        productList = new ArrayList<>();









//
//
////login button in the start page
//        binding.already_member_button.setOnClickListener(v -> {
//
//            Intent intent =new Intent(this,ActivityLogin.class);
//            startActivity(intent);
//
//
//        });
//        //register button in the start page
//        binding.register_button.setOnClickListener(view -> {
//            String name= binding.userNameEdt.getText.toString().trim();
//            String email= binding.userEmailEdt.getText.toString().trim();
//            String password = binding.userPassword.getText.toString().trim();
//
//            if (name.equals("")){
//
//                binding.userName.setError("Name can't be empty");
//            }
//
//            else{
//
//                registerUser(name, email, password);
//
//
//
//            }
//
//
//
//
//                    Intent i = new Intent(this, RegisterActivity.class);
//                    startActivity(i);
//
//
//        });
//
//        private void registerUser(String name,email,password){
//
//            mAuth.createUserWithEmailAndPassword(emai, password).addOnSuccessListener(new onSuccessLi)
//
//        }
//
//
//
//




    }
}
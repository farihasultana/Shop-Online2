package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;

import com.example.onlineshopping.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        mAuth = FirebaseAuth.getInstance();

        binding.singUpNowButton.setOnClickListener(view -> {
            startActivity(new Intent(this, ActivityLogin.class));
            finish();
        });

        binding.logInBtn.setOnClickListener(view -> {
            String name = binding.userName.getText().toString().trim();
            String email = binding.userEmail.getText().toString().trim();
            String password = binding.userPassword.getText().toString().trim();

            if (name.equals("")) {
                binding.userName.setError("Name can't be empty");

            }

            else if (email.equals("")) {
                binding.userName.setError("email can't be empty");

            } else {
                registerUser(name, email, password);
            }


        });


//        //signup now button
//        sign_up_now_button.setOnClickListener(view -> {
//
//            if (enter_name.getText().toString().equals("")){
//                enter_name.setError("Name can't be empty");
//                return;
//            }
//
//            String username = enter_name.getText().toString();
//
//            if (enter_email.getText().toString().equals("")){
//                enter_email.setError("email can't be empty");
//                return;
//            }
//
//            String useremail = enter_email.getText().toString();
//
//            if (enter_password.getText().toString().equals("")){
//                enter_password.setError("Password can't be empty");
//                return;
//            }
//
//            String password = enter_password.getText().toString();
//
//
//
//        });
//
//        Intent intent =new Intent(this,ActivityLogin.class);
//        startActivity(intent);
//    }


    }

    private void registerUser(String name, String email, String password) {

        mAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });
    }
}
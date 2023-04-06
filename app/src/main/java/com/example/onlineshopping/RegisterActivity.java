package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.onlineshopping.databinding.ActivityRegisterBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegisterActivity extends AppCompatActivity {

    private ActivityRegisterBinding binding;

    FirebaseAuth userAuth;
    private FirebaseUser firebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        if (firebaseUser!= null){
            startActivity( new Intent(this, MainActivity.class));
            finish();
        }

        userAuth =FirebaseAuth.getInstance();

        binding.singUpNowButton.setOnClickListener(v -> {
            String name =binding.userName.getText().toString().trim();
            String email =binding.userEmail.getText().toString().trim();
            String password =binding.userPassword.getText().toString().trim();


            if (name.equals("")){
                binding.userName.setError("Name can't be empty");
            }
            else if (email.equals("")){
                binding.userEmail.setError("Email can't be empty");
            }

            else if (password.equals("")){
                binding.userPassword.setError("password can't be empty");
            }

            else{
                registerButton(name, email,password);
            }

        });
    }

    private void registerButton(String name, String email, String password) {

        userAuth.createUserWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                Toast.makeText(RegisterActivity.this, "Successfully registered..", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RegisterActivity.this, MainActivity.class));
                finish();

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                showAlert(e.getLocalizedMessage() );

            }
        });
    }

    private void showAlert(String errMsg){
        AlertDialog.Builder builder= new AlertDialog.Builder(this);
        builder.setTitle("Warning!");
        builder.setMessage(errMsg);
        builder.setIcon(android.R.drawable.stat_notify_error);

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

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
package com.example.onlineshopping;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.onlineshopping.databinding.ActivityCategoryBinding;
import com.example.onlineshopping.databinding.ActivityRegisterBinding;

import java.net.URI;

public class category extends AppCompatActivity {
    private ActivityCategoryBinding binding;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCategoryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());





        binding.tShirtImage.setOnClickListener(v ->{

        Intent intent = new Intent(category.this, tshirt.class);
        intent.putExtra("category","tshirt");
        startActivity(intent);


    });
        binding.sweaterImage.setOnClickListener(v ->{

            Intent intent = new Intent(category.this, coat.class);
            intent.putExtra("category","coat");
            startActivity(intent);


        });
        binding.sportImage.setOnClickListener(v ->{

            Intent intent = new Intent(category.this, jersy.class);
            intent.putExtra("category","jersy");
            startActivity(intent);


        });

        binding.shoeImage.setOnClickListener(v ->{

            Intent intent = new Intent(category.this, shoe.class);
            intent.putExtra("category","shoe");
            startActivity(intent);


        });

        binding.purseImage.setOnClickListener(v ->{

            Intent intent = new Intent(category.this, bag.class);
            intent.putExtra("category","bag");
            startActivity(intent);


        });

        binding.watchImage.setOnClickListener(v ->{

            Intent intent = new Intent(category.this, watch.class);
            intent.putExtra("category","watch");
            startActivity(intent);


        });

        binding.mobileImage.setOnClickListener(v ->{

            Intent intent = new Intent(category.this, mobile.class);
            intent.putExtra("category","mobile");

            startActivity(intent);


        });
}

    private void openGallery() {

        Intent galleryIntent = new Intent();
        galleryIntent.setAction(Intent.ACTION_GET_CONTENT);
        galleryIntent.setType("image/*");

    }


}
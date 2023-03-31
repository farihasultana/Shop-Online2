package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Toast;

import com.example.onlineshopping.databinding.ActivityAdminpanelBinding;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.ktx.Firebase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicMarkableReference;

public class adminpanel<productImageRef> extends AppCompatActivity {

    private ActivityAdminpanelBinding binding;
    private static final int gallaryPic =1;

    private String categoryName, saveCurrentDate, saveCurrentTime, ProductName, ProductPrice;
    private Uri imageUri;
    private String ProductRandomKey, downloadImageUrl;
    private StorageReference productImageRef;
    private DatabaseReference productRef;



   // productImageRef = FirebaseStorage.getInstance().getReference().child("Product Images");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdminpanelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        categoryName = getIntent().getExtras().get("category").toString();

        productImageRef = FirebaseStorage.getInstance().getReference().child("Product Images");
        productRef= FirebaseDatabase.getInstance().getReference().child("products");

        binding.productImage.setOnClickListener(view -> {
            openGallery();
        });
        binding.addNewProduct.setOnClickListener(view -> {
            ValidateProductData();
        });
    }



    private void openGallery() {

        Intent gallaryIntent = new Intent();
        gallaryIntent.setAction(Intent.ACTION_GET_CONTENT);
        gallaryIntent.setType("image/*");
        startActivityForResult(gallaryIntent, gallaryPic);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == gallaryPic && resultCode == RESULT_OK && data != null){
            binding.productImage.setImageURI(imageUri);


        }

    }

    private void ValidateProductData() {
        binding.ProductName.getText().toString();
        binding.productPrice.getText().toString();

        
        if (imageUri==null){
            Toast.makeText(this, "Product image is required!", Toast.LENGTH_SHORT).show();
        }
        
        else {
            storeProductInformation();
        }


    }

    private void storeProductInformation() {
        Calendar calendar =Calendar.getInstance();
        SimpleDateFormat currentDate = new SimpleDateFormat("DD MM YYYY");
        saveCurrentDate = currentDate.format(calendar.getTime());
        SimpleDateFormat currentTime = new SimpleDateFormat("HH:mm ss a");
        saveCurrentTime =currentTime.format(calendar.getTime());
        ProductRandomKey = saveCurrentDate+ saveCurrentTime;

        // Create a reference to the file you want to upload
        StorageReference fileRef = productImageRef.child(ProductRandomKey + ".jpg");
        final UploadTask uploadTask = fileRef.putFile(imageUri);

        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                String message =e.toString();
                Toast.makeText(adminpanel.this, "Error:"+message, Toast.LENGTH_SHORT).show();

            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                Toast.makeText(adminpanel.this, "Image uploaded successfully", Toast.LENGTH_SHORT).show();
                Task<Uri> uriTask=uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
                    @Override
                    public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
                        if (!task.isSuccessful()){
                             throw task.getException();
                        }
                        downloadImageUrl= fileRef.getDownloadUrl().toString();
                        return fileRef.getDownloadUrl();
                    }
                }).addOnCompleteListener(new OnCompleteListener<Uri>() {
                    @Override
                    public void onComplete(@NonNull Task<Uri> task) {
                        if (task.isSuccessful()){
                            Toast.makeText(adminpanel.this, "Image saved..", Toast.LENGTH_SHORT).show();
                            saveProductInfo();
                        }


                    }
                });
            }
        });
    }

    private void saveProductInfo() {
        HashMap<String, Object> productMap = new HashMap<>();
        productMap.put("productID", ProductRandomKey);
        productMap.put("date", saveCurrentDate);
        productMap.put("time", saveCurrentTime);
        productMap.put("category", categoryName);

        productMap.put("productName", ProductName);
        productMap.put("productPrice", ProductPrice);

        productRef.child(ProductRandomKey).updateChildren(productMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){

                    Toast.makeText(adminpanel.this, "Product added successfully", Toast.LENGTH_SHORT).show();
                }

                else{
                    String message =task.getException().toString();
                    Toast.makeText(adminpanel.this, "Error:"+message, Toast.LENGTH_SHORT).show();

                }


            }
        });
    }
}
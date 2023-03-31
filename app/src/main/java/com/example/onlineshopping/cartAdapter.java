package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class cartAdapter extends RecyclerView.Adapter<cartViewHolder> {


    List<String> cartList;
    Context context;


    @NonNull
    @Override
    public cartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_view,parent,false);


        cartViewHolder cartViewHolder = new cartViewHolder();

        return cartViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull cartViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
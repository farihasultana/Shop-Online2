package com.example.onlineshopping;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class cartViewHolder extends RecyclerView.ViewHolder {

    TextView cartProductName, cartProductPrice;
    ImageView cartProductImage;



    public cartViewHolder(@NonNull View itemView) {
        super(itemView);

        cartProductName = itemView.findViewById(R.id.cartProductName);
        cartProductPrice=itemView.findViewById(R.id.cartProductPrice);
        cartProductImage=itemView.findViewById(R.id.cartProductImage);
    }



}
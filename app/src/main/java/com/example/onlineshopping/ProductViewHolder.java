package com.example.onlineshopping;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ProductViewHolder extends RecyclerView.ViewHolder {

    TextView prodName, prodPrice;
    ImageView prodImage;
    public ProductViewHolder(@NonNull View view) {
        super(view);

        prodName= view.findViewById(R.id.productTitle);
        prodPrice =view.findViewById(R.id.prodPrice);
        prodImage = view.findViewById(R.id.productPhoto);
    }
}

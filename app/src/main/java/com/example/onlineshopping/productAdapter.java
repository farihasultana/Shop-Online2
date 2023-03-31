package com.example.onlineshopping;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class productAdapter extends RecyclerView.Adapter<ProductViewHolder> {

    List<String> productList;
    Context context;

    public productAdapter(List<String> productList, Context context){

        this.productList = productList;
        this.context= context;

    }


    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_view,parent,false);


        ProductViewHolder productViewHolder = new ProductViewHolder();

        return productViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        String product =productList.get(position);
        holder.prodName.setText(product);
        holder.prodImage.setImageURI(Uri.parse(product));
        holder.prodPrice.setText(product);

    }

    @Override
    public int getItemCount() {
        return productList.size();
    }
}

//package com.example.onlineshopping;
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//
//import androidx.annotation.NonNull;
//
//import com.firebase.ui.database.FirebaseRecyclerOptions;
//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;
//
//public abstract class FirebaseRecyclerAdapter<MyViewHolder, product> {
//    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("users");
//
//    FirebaseRecyclerOptions<product> options =
//            new FirebaseRecyclerOptions.Builder<product>()
//                    .setQuery(databaseReference, product.class)
//                    .build();
//
//    FirebaseRecyclerAdapter<product, MyViewHolder> adapter =
//            new FirebaseRecyclerAdapter<product, MyViewHolder>(options) {
//                protected void onBindViewHolder(@NonNull product myViewHolder, int position, @NonNull product model) {
//
//                }
//
//                @Override
//                protected void onBindViewHolder(@NonNull product product, int position, @NonNull User model) {
//
//                }
//
//                @Override
//                protected void onBindViewHolder(@NonNull product product, int position, @NonNull product model) {
//
//                }
//
//                @Override
//                protected void onBindViewHolder(product user, int position, MyViewHolder model) {
//
//                }
//
//                protected void onBindViewHolder(MyViewHolder user, int position, product model) {
//
//                }
//
//                @Override
//                protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull product model) {
//                    holder.setproductName(model.getProductName());
//                    holder.setProductImagee(model.getProductImage());
//                }
//
//                @NonNull
//                @Override
//                public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//                    View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
//                    return new MyViewHolder(view);
//                }
//            };
//
//    protected abstract void onBindViewHolder(@NonNull product product, int position, @NonNull product model);
//
//    protected abstract void onBindViewHolder(@NonNull product product, int position, @NonNull product model);
//}

package com.example.fptu.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fptu.ProductDetailsActivity;
import com.example.fptu.R;
import com.example.fptu.bean.Product;

import java.util.List;

public class ProductListAdapter extends RecyclerView.Adapter<ProductListAdapter.ProductViewHolder> {
    private List<Product> productList;
    private Context context;
    public ProductListAdapter() {
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public ProductListAdapter(List<Product> productList, Context context) {
        this.productList = productList;
        this.context = context;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.product_item, parent, false);

        //ProductViewHolder quản lý layout của product_item
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, int position) {
        Product product = productList.get(position);
        holder.productId.setText(product.getProductId());
        holder.productName.setText(product.getProductName());
        holder.productPrice.setText(String.valueOf(product.getPrice()));


    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public  class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        private TextView productId, productName, productPrice;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productId = itemView.findViewById(R.id.product_id);
            productName = itemView.findViewById(R.id.product_name);
            productPrice = itemView.findViewById(R.id.product_price);
            productName.setOnClickListener(this);
        }



        @Override
        public void onClick(View v) {
            Intent intent = new Intent(context, ProductDetailsActivity.class);
            intent.putExtra("PRODUCT_ID", productId.getText().toString());
            context.startActivity(intent);
        }
    }
}

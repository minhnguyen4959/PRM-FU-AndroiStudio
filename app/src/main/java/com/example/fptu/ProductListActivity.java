package com.example.fptu;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fptu.adapter.ProductListAdapter;
import com.example.fptu.bean.Product;
import com.google.android.material.carousel.CarouselLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProductListActivity extends AppCompatActivity {
    private List<Product> productList = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getProductList();
        RecyclerView recyclerView = findViewById(R.id.recycler_view_product_list);
        ProductListAdapter productListAdapter = new ProductListAdapter(productList,this);
        recyclerView.setAdapter(productListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }


    private void getProductList(){
        Random random = new Random(500);
        for (int i = 0; i < 50; i++) {
            Product product = new Product();
            product.setProductId("0"+i);
            product.setProductName("Product name "+i);
            product.setPrice(random.nextFloat());
            productList.add(product);
        }
    }
}

package com.ezamora.prueba.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.ezamora.prueba.Adapters.ListProductsAdapter;
import com.ezamora.prueba.Database.Entity.ProductModel;
import com.ezamora.prueba.Database.ProductApp;
import com.ezamora.prueba.R;
import com.google.android.material.snackbar.Snackbar;

import java.util.List;

public class ViewProductsActivity extends AppCompatActivity {

    //VIEWS
    private RecyclerView mRecyclerView;

    private ProductModel mProductModel;
    private ProductApp mProductApp;
    private List<ProductModel> mListProducts;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_products);

        mProductApp = ProductApp.get(this);

        getProductsList();
        initializeComponents();
    }

    private void getProductsList(){
        mListProducts = mProductApp.getProducts();
        if (mListProducts.size() == 0){
            Toast.makeText(this, "No hay productos almacenados", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializeComponents(){
        mRecyclerView = findViewById(R.id.recyclerViewProducts);

    }

    @Override
    protected void onResume() {
        super.onResume();
        showListProducts();
    }

    private void showListProducts(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        ListProductsAdapter listProductsAdapter = new ListProductsAdapter(mListProducts);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, linearLayoutManager.getOrientation());
        mRecyclerView.addItemDecoration(dividerItemDecoration);
        mRecyclerView.setAdapter(listProductsAdapter);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(linearLayoutManager);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
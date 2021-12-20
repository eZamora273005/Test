package com.ezamora.prueba.Database;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import androidx.room.Room;

import com.ezamora.prueba.Constants;
import com.ezamora.prueba.Database.DAO.ProductDAO;
import com.ezamora.prueba.Database.Entity.ProductModel;

import java.util.List;

public class ProductApp extends Application {
    @SuppressLint("StaticFieldLeak")
    private static ProductApp sProductApp;

    private ProductDAO mProductDAO;

    private ProductApp(Context context){
        Context appContext = context.getApplicationContext();
        AppDatabase database = Room.databaseBuilder(appContext, AppDatabase.class, Constants.DB_NAME)
                .allowMainThreadQueries()
                .build();
        mProductDAO = database.productDAO();

    }

    public static ProductApp get(Context context) {
        if (sProductApp == null) {
            sProductApp = new ProductApp(context);
        }
        return sProductApp;
    }

    public void addProduct(ProductModel productModel) {
        mProductDAO.insertAll(productModel);
    }

    public List<ProductModel> getProducts(){
        return mProductDAO.getAll();
    }
}

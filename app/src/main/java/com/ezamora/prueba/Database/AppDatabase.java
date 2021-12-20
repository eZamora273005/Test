package com.ezamora.prueba.Database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.ezamora.prueba.Database.DAO.ProductDAO;
import com.ezamora.prueba.Database.Entity.ProductModel;

@Database(entities = {ProductModel.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ProductDAO productDAO();
}

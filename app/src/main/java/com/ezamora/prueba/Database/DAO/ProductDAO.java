package com.ezamora.prueba.Database.DAO;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.ezamora.prueba.Database.Entity.ProductModel;

import java.util.List;


@Dao
public interface ProductDAO {
    //DAO for DB actions
    @Query("SELECT * FROM ProductModel")
    List<ProductModel> getAll();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    //void insertAll(ProductModel... productModels);
    void insertAll(ProductModel productModels);

}

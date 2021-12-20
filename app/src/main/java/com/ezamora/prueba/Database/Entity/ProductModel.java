package com.ezamora.prueba.Database.Entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class ProductModel {
    //DB model
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(index = true, name = "id")
    public Integer productId;
    @ColumnInfo(name = "product_name")
    public String productName;
    @ColumnInfo(name = "product_type")
    public String product_type;
    @ColumnInfo(name = "product_description")
    public String product_description;
    @ColumnInfo(name = "product_date_acquisition")
    public String product_date_acquisition;
    @ColumnInfo(name = "product_date_register")
    public String product_date_register;

    public String getProduct_date_register() {
        return product_date_register;
    }

    public void setProduct_date_register(String product_date_register) {
        this.product_date_register = product_date_register;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_date_acquisition() {
        return product_date_acquisition;
    }

    public void setProduct_date_acquisition(String product_date_acquisition) {
        this.product_date_acquisition = product_date_acquisition;
    }


    public ProductModel(Integer productId, String productName, String product_type, String product_description, String product_date_acquisition, String product_date_register) {
        this.productId = productId;
        this.productName = productName;
        this.product_type = product_type;
        this.product_description = product_description;
        this.product_date_acquisition = product_date_acquisition;
        this.product_date_register = product_date_register;
    }
}

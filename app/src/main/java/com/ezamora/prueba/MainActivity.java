package com.ezamora.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.ezamora.prueba.Database.Entity.ProductModel;
import com.ezamora.prueba.Database.ProductApp;
import com.ezamora.prueba.ui.ViewProductsActivity;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Views
    private AutoCompleteTextView vAutoComplete;
    private TextInputEditText vEdtName, vEdtDescription, vEdtDate;
    private MaterialButton btnSaveData, btnSeeList;
    private ArrayAdapter arrayAdapter;

    //VARS
    private String mDate, mName, mType, mDescription;

    private ProductModel mProductModel;
    private ProductApp mProductApp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mProductApp = ProductApp.get(this);

        initializeComponents();
        setListeners();

    }

    private void initializeComponents(){
        vAutoComplete = findViewById(R.id.tvAutoComplete);
        vEdtName = findViewById(R.id.etName);
        vEdtDescription = findViewById(R.id.etMultilineDescription);
        vEdtDate = findViewById(R.id.etDatePicker);
        btnSaveData = findViewById(R.id.btnSaveData);
        btnSeeList = findViewById(R.id.btnSeeList);

        fillTypesList();

    }

    private void fillTypesList(){
        List<String> list = new ArrayList<>();
        list.add("Electrónico");
        list.add("Inmobiliario");
        list.add("Decoración");

        arrayAdapter = new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,list);
        vAutoComplete.setAdapter(arrayAdapter);
    }

    private void setListeners(){
        vEdtDate.setOnClickListener(view -> {
            showDatePickerDialog();
        });

        btnSaveData.setOnClickListener(view -> {
            mName = vEdtName.getText().toString();
            mDescription = vEdtDescription.getText().toString();
            mType = vAutoComplete.getText().toString();

            guardar();
        });

        btnSeeList.setOnClickListener(view -> {
            Intent intent = new Intent(getApplicationContext(), ViewProductsActivity.class);
            startActivity(intent);
        });
    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(this);
        datePickerDialog.show();
        datePickerDialog.setOnDateSetListener((datePicker, y, m, d) -> {
            mDate = (y + "/" + (m + 1) + "/" + d);
            vEdtDate.setText(mDate);
        });

    }

    private void guardar(){
        if (mName != null && mName.length() > 0 && mType != null && mType.length() > 0 && mDescription != null && mDescription.length() > 0 && mDate != null && mDate.length() > 0){
            String currentDateTimeString = DateFormat.getDateTimeInstance().format(new Date());
            mProductApp.addProduct(new ProductModel(null, mName, mType, mDescription, mDate, currentDateTimeString));

            clearFieldsAndVariables();
            Snackbar
                    .make(btnSaveData, "Registro agregado exitosamente", BaseTransientBottomBar.LENGTH_LONG)
                    .show();
        }else{
            Snackbar
                    .make(btnSaveData, "Error. No puede haber campos vacíos", BaseTransientBottomBar.LENGTH_LONG)
                    .show();
        }
    }

    private void clearFieldsAndVariables(){
        mName = "";
        mType = "";
        mDescription = "";
        mDate = "";
        vEdtName.setText("");
        vEdtDescription.setText("");
        vAutoComplete.setText("");
        vEdtDate.setText("");
    }
}
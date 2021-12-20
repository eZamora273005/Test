package com.ezamora.prueba.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ezamora.prueba.Database.Entity.ProductModel;
import com.ezamora.prueba.R;

import java.util.List;

public class ListProductsAdapter extends RecyclerView.Adapter<ListProductsAdapter.ViewHolder> {
    List<ProductModel> mProductsList;

    public ListProductsAdapter(List<ProductModel> mProductsList){
        this.mProductsList = mProductsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.products_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.vTvNameItem.setText("Nombre: " + mProductsList.get(position).productName);
        holder.vTvDescriptionItem.setText("Descripcion: " + mProductsList.get(position).product_description);
        holder.vTvTypeItem.setText("Tipo: " + mProductsList.get(position).product_type);
        holder.vTvDateItem.setText("Fecha adquisicion: " + mProductsList.get(position).product_date_acquisition);
        holder.vTvDateRegisterItem.setText("Fecha registro: " + mProductsList.get(position).product_date_register);
    }

    @Override
    public int getItemCount() {
        return mProductsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView vTvNameItem, vTvDescriptionItem, vTvTypeItem, vTvDateItem, vTvDateRegisterItem;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            vTvNameItem = itemView.findViewById(R.id.tvNameItem);
            vTvDescriptionItem = itemView.findViewById(R.id.tvDescriptionItem);
            vTvTypeItem = itemView.findViewById(R.id.tvTypeItem);
            vTvDateItem = itemView.findViewById(R.id.tvDateItem);
            vTvDateRegisterItem = itemView.findViewById(R.id.tvDateRegister);
        }
    }
}

package com.example.filtrado;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductoAdapter extends RecyclerView.Adapter<ProductoAdapter.ViewHolder>{

    private List<Producto> productoList;
    private Context context;

    final OnItemClickListener listener;

    public interface  OnItemClickListener{
        void onItemClick(Producto item);
    }

    public void setProductoList(List<Producto> productos) {
        productoList = productos;
        notifyDataSetChanged();
    }
    public ProductoAdapter(List<Producto> productoList, Context context, OnItemClickListener listener){
        this.productoList = productoList;
        this.context     = context;
        this.listener    = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_productos,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Producto producto = productoList.get(position);
        holder.txtNombre.setText(productoList.get(position).getNom_producto());
        holder.txtCategoria.setText(productoList.get(position).getCategoria_ID());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onItemClick(producto);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productoList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        private TextView txtNombre;
        private TextView txtCategoria;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtNombre = itemView.findViewById(R.id.txt_nombreProducto);
            txtCategoria = itemView.findViewById(R.id.txtCategoria);
        }

    }
}

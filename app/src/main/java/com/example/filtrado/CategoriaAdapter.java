package com.example.filtrado;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CategoriaAdapter extends RecyclerView.Adapter<CategoriaAdapter.ViewHolder> {

    private List<Categoria> categoriaList;
    private Context context;

    final OnItemClickListener listener;

    private int categoriaSeleccionada;

    public interface  OnItemClickListener{
        void onItemClick(Categoria item);
    }


    public CategoriaAdapter(List<Categoria> categoriaList, Context context, OnItemClickListener listener){
        this.categoriaList = categoriaList;
        this.context     = context;
        this.listener    = listener;
        categoriaSeleccionada = -1;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.tarjeta_usuarios,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Categoria categoria = categoriaList.get(position);

        holder.txtNombre.setText(categoriaList.get(position).getNom_categoria());

        if (categoriaSeleccionada == position) {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#5EA7DE"));
        } else {
            holder.cardView.setCardBackgroundColor(Color.parseColor("#123456"));
        }


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int previousItem = categoriaSeleccionada;
                categoriaSeleccionada = position;
                notifyItemChanged(previousItem);
                notifyItemChanged(position);

                listener.onItemClick(categoria);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoriaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        private TextView txtNombre;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtNombre = itemView.findViewById(R.id.txt_nombre);
        }

    }
}

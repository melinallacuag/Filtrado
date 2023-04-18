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

public class CardDetalleAdapter extends RecyclerView.Adapter<CardDetalleAdapter.ViewHolder> {

    private List<CardDetalle> cardDetalleList;
    private Context context;


    public CardDetalleAdapter(List<CardDetalle> cardDetalleList, Context context){
        this.cardDetalleList = cardDetalleList;
        this.context     = context;
    }

    @NonNull
    @Override
    public CardDetalleAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carddetalle,parent,false);
        return new CardDetalleAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardDetalleAdapter.ViewHolder holder, int position) {
        holder.txtNombreProducto.setText(cardDetalleList.get(position).getDetalle_nom_producto());
        holder.txtNombreCategoria.setText(cardDetalleList.get(position).getDetalle_nom_categoria());
    }

    @Override
    public int getItemCount() {
        return cardDetalleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public CardView cardView;
        private TextView txtNombreProducto;
        private TextView txtNombreCategoria;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            cardView = itemView.findViewById(R.id.cardView);
            txtNombreProducto = itemView.findViewById(R.id.txt_nombreProducto);
            txtNombreCategoria = itemView.findViewById(R.id.txt_nombreCategoria);
        }

    }
}

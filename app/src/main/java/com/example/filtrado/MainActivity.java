package com.example.filtrado;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerCategoria,recyclerProductos,recyclerDetalles;

    Button btnguardar;

    List<Categoria> categoriaList;
    CategoriaAdapter categoriaAdapter;

    List<Producto> productosFiltrados;

    List<Producto> productoList;
    ProductoAdapter productoAdapter;

    List<CardDetalle> cardDetalleList;
    CardDetalleAdapter cardDetalleAdapter;

    String getnom,nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnguardar = findViewById(R.id.btnguardar);

        /** Listado de Card - Categoria */
        recyclerCategoria = findViewById(R.id.recyclerCategoria);
        recyclerCategoria.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        categoriaList = new ArrayList<>();

        for (int i = 0; i < 1; i++){
            categoriaList.add(new Categoria("Frutas"));
            categoriaList.add(new Categoria("Verduras"));
            categoriaList.add(new Categoria("Artefactos"));
            categoriaList.add(new Categoria("Carreras"));
        }

        categoriaAdapter = new CategoriaAdapter(categoriaList, getApplicationContext(), new CategoriaAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Categoria item) {

                productosFiltrados = new ArrayList<>();

                for (Producto producto : productoList) {
                    if (producto.getCategoria_ID().equals(item.getNom_categoria())) {
                        productosFiltrados.add(producto);
                    }
                }

                getnom = item.getNom_categoria();

                productoAdapter.setProductoList(productosFiltrados);
                productoAdapter.notifyDataSetChanged();

            }

        });


        recyclerCategoria.setAdapter(categoriaAdapter);

        /** Listado de Card - Manguera */
        recyclerProductos = findViewById(R.id.recyclerProductos);
        recyclerProductos.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false));

        productoList = new ArrayList<>();

        for (int i = 0; i < 1; i++){
            productoList.add(new Producto("Pera","Frutas"));
            productoList.add(new Producto("Apio","Verduras"));
            productoList.add(new Producto("Cocina","Artefactos"));
            productoList.add(new Producto("Electrica","Carreras"));
            productoList.add(new Producto("Manzana","Frutas"));
            productoList.add(new Producto("Cebolla","Verduras"));
            productoList.add(new Producto("Taza","Artefactos"));
            productoList.add(new Producto("Docente","Carreras"));
        }

        productoAdapter = new ProductoAdapter(productoList, getApplicationContext(), new ProductoAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Producto item) {

                nombre = item.getNom_producto();
            }
        });
        productoAdapter.notifyDataSetChanged();

        recyclerProductos.setAdapter(productoAdapter);

        /** Button */
        btnguardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (CardDetalle cardDetalle : cardDetalleList ){

                    if(cardDetalle.getDetalle_nom_categoria().equals(getnom)){

                        cardDetalle.setDetalle_nom_producto(nombre);

                        Toast.makeText(MainActivity.this, "Selecciono Producto " + nombre, Toast.LENGTH_SHORT).show();
                    }

                    recyclerDetalles.setAdapter(cardDetalleAdapter);


                }
            }
        });

        /** Listado de Card - Detalle */
        recyclerDetalles = findViewById(R.id.recyclerDetalles);
        recyclerDetalles.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        cardDetalleList = new ArrayList<>();

        for (int i = 0; i < 1; i++){
            cardDetalleList.add(new CardDetalle("Frutas",""));
            cardDetalleList.add(new CardDetalle("Verduras",""));
            cardDetalleList.add(new CardDetalle("Artefactos",""));
            cardDetalleList.add(new CardDetalle("Carreras",""));
        }

        cardDetalleAdapter = new CardDetalleAdapter(cardDetalleList, getApplicationContext());
        cardDetalleAdapter.notifyDataSetChanged();

        recyclerDetalles.setAdapter(cardDetalleAdapter);
    }
}
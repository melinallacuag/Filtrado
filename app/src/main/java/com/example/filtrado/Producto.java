package com.example.filtrado;

public class Producto {

    private String nom_producto;
    private String categoria_ID;

    public Producto(String nom_producto, String categoria_ID) {
        this.nom_producto = nom_producto;
        this.categoria_ID = categoria_ID;
    }

    public String getNom_producto() {
        return nom_producto;
    }

    public void setNom_producto(String nom_producto) {
        this.nom_producto = nom_producto;
    }

    public String getCategoria_ID() {
        return categoria_ID;
    }

    public void setCategoria_ID(String categoria_ID) {
        this.categoria_ID = categoria_ID;
    }
}

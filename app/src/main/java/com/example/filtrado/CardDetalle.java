package com.example.filtrado;

public class CardDetalle {

    private String detalle_nom_categoria;
    private String detalle_nom_producto;

    public CardDetalle(String detalle_nom_categoria, String detalle_nom_producto) {
        this.detalle_nom_categoria = detalle_nom_categoria;
        this.detalle_nom_producto = detalle_nom_producto;
    }

    public String getDetalle_nom_categoria() {
        return detalle_nom_categoria;
    }

    public void setDetalle_nom_categoria(String detalle_nom_categoria) {
        this.detalle_nom_categoria = detalle_nom_categoria;
    }

    public String getDetalle_nom_producto() {
        return detalle_nom_producto;
    }

    public void setDetalle_nom_producto(String detalle_nom_producto) {
        this.detalle_nom_producto = detalle_nom_producto;
    }
}

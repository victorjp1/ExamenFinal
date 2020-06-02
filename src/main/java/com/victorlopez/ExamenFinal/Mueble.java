package com.victorlopez.ExamenFinal;

import java.util.Comparator;

public abstract class Mueble implements Comparable<Mueble> {
    protected String codigo;
    protected String nombre;
    protected double ancho;
    protected double alto;
    protected double profundo;
    protected double precio;
    protected int stock;
    protected abstract double costeEnvio(double km);

    public Mueble(String codigo, String nombre, double ancho, double alto, double profundo, double precio, int stock) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.ancho = ancho;
        this.alto = alto;
        this.profundo = profundo;
        this.precio = precio;
        this.stock = stock;
    }

    protected String getCodigo() {
        return codigo;
    }
    protected String getNombre() {
        return nombre;
    }

    protected double getAncho() {
        return ancho;
    }

    protected double getAlto() {
        return alto;
    }

    protected double getProfundo() {
        return profundo;
    }

    protected double getPrecio() {
        return precio;
    }

    protected int getStock() {
        return stock;
    }
    protected void venderMueble(){
        this.stock -= 1;
    }
    public static class ComparatorMueblePrecioAsc implements Comparator<Mueble>{
        @Override
        public int compare(Mueble m1, Mueble m2) {
            return (int)m1.getPrecio() - (int)m2.getPrecio();
        }
    }
    public static class ComparatorMuebleCod implements Comparator<Mueble>{
        @Override
        public int compare(Mueble m1, Mueble m2) {
            return m1.getCodigo().compareTo(m2.getCodigo());
        }
    }
    public static class ComparatorMuebleStock implements Comparator<Mueble>{
        @Override
        public int compare(Mueble m1, Mueble m2) {
            return m1.getStock() - m2.getStock();
        }
    }
}

package com.victorlopez.ExamenFinal;

import java.util.ArrayList;

public class Catalogo implements Comparable<Catalogo>{
    private static int nCatalogos = 0;
    private int id;
    private String nombre;
    private ArrayList<Mueble> muebles;

    public Catalogo(String nombre) {
        this.nombre = nombre;
        this.id = ++nCatalogos;
        muebles = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return id;
    }
    public ArrayList<Mueble> getMuebles(){
        return this.muebles;
    }

    @Override
    public int compareTo(Catalogo o) {
        return this.getNombre().compareTo(o.getNombre());
    }

    @Override
    public String toString() {
        return "Catalogo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}' + "\n";
    }
}

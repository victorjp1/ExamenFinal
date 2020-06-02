package com.victorlopez.ExamenFinal;

public class MuebleAuxiliar extends Mueble{
    private String color;

    @Override
    protected double costeEnvio(double km) {
        double costeEnvio;
        costeEnvio = alto * ancho * km;
        return costeEnvio;
    }

    public MuebleAuxiliar(String codigo, String nombre, double ancho, double alto, double profundo, double precio, int stock, String color) {
        super(codigo, nombre, ancho, alto, profundo, precio, stock);
        this.color = color;
    }

    @Override
    public String toString() {
        return "MuebleAuxiliar{" +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                "color='" + color + '\'' +
                ", ancho=" + ancho +
                ", alto=" + alto +
                ", profundo=" + profundo +
                ", precio=" + precio +
                ", stock=" + stock +
                '}' + "\n";
    }

    @Override
    public int compareTo(Mueble o) {
        return this.getNombre().compareTo(o.getNombre());
    }
}

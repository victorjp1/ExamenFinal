package com.victorlopez.ExamenFinal;

public class MuebleClasico extends Mueble{
    private double peso;
    private String tipoMadera;

    public MuebleClasico(String codigo, String nombre, double ancho, double alto, double profundo, double precio, int stock, double peso, String tipoMadera) {
        super(codigo, nombre, ancho, alto, profundo, precio, stock);
        this.peso = peso;
        this.tipoMadera = tipoMadera;
    }

    @Override
    protected double costeEnvio(double km) {
        double costeEnvio;
        costeEnvio = 0.10 * peso * km + 30;
        return costeEnvio;
    }

    @Override
    public String toString() {
        return "MuebleClasico{" +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                "peso=" + peso +
                ", tipoMadera='" + tipoMadera + '\'' +
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

package com.victorlopez.ExamenFinal;

import java.time.LocalDate;

public class Venta {
    private LocalDate fecha;
    private String nombreCliente;
    private Mueble mueble;

    public Venta(LocalDate fecha, String nombreCliente, Mueble mueble) {
        this.fecha = fecha;
        this.nombreCliente = nombreCliente;
        this.mueble = mueble;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public Mueble getMueble() {
        return mueble;
    }
}

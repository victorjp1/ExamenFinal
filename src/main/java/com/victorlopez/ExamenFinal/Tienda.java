package com.victorlopez.ExamenFinal;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class Tienda {
    private ArrayList<Catalogo> catalogos;
    private ArrayList<Venta> ventas;
    public Tienda() {
        catalogos = new ArrayList<>();
        ventas = new ArrayList<>();
        addCatalogos();
        casosPrueba();
    }
    private void casosPrueba(){
        catalogos.get(1).getMuebles().add(new MuebleClasico("C0001", "Sofa", 2,1,3,400, 2, 50, "Roble"));
        catalogos.get(1).getMuebles().add(new MuebleClasico("C0002", "Cama", 3,1,2,500, 1, 100, "Castaño"));
        catalogos.get(1).getMuebles().add(new MuebleClasico("C0003", "Aparador", 2,2,1,100, 5, 200, "Pino"));
        catalogos.get(1).getMuebles().add(new MuebleClasico("C0004", "Mesa de noche", 1,1,1,20, 10, 73, "Roble"));
        catalogos.get(1).getMuebles().add(new MuebleClasico("C0005", "Estantería", 2,1,3,50, 2, 65, "Pino"));
        catalogos.get(1).getMuebles().add(new MuebleAuxiliar("A0001", "Silla", 0.5, 1,0.5,10, 50,"Rojo"));
        catalogos.get(1).getMuebles().add(new MuebleAuxiliar("A0002", "Mesa", 1, 1,2,200, 30,"Marrón"));
        catalogos.get(1).getMuebles().add(new MuebleAuxiliar("A0003", "Cama", 3, 1,3,1000, 8,"Blanco"));
        catalogos.get(1).getMuebles().add(new MuebleAuxiliar("A0004", "Sofa", 3, 1,3,1500, 3,"Gris"));
        catalogos.get(1).getMuebles().add(new MuebleAuxiliar("A0005", "Rinconera", 0.45, 0.5,0.3,40, 50,"Negro"));

        catalogos.get(0).getMuebles().add(new MuebleClasico("C0006", "Aparador", 1,2,4,425.90, 2, 105, "Pino"));
        catalogos.get(0).getMuebles().add(new MuebleClasico("C0007", "Cama", 3,1,2,500, 1, 27, "Castaño"));
        catalogos.get(0).getMuebles().add(new MuebleClasico("C0008", "Aparador", 2,2,1,100, 5, 15.6, "Roble"));
        catalogos.get(0).getMuebles().add(new MuebleClasico("C0009", "Mesa de noche", 1,1,1,20, 10, 190, "Olivo"));
        catalogos.get(0).getMuebles().add(new MuebleClasico("C00010", "Estantería", 2,1,3,50, 2, 54, "Pino"));
        catalogos.get(0).getMuebles().add(new MuebleAuxiliar("A0006", "Rinconera", 0.5, 1,0.5,10, 50,"Marrón"));
        catalogos.get(0).getMuebles().add(new MuebleAuxiliar("A0007", "Mesa", 1, 3,2,200, 30,"Rojo"));
        catalogos.get(0).getMuebles().add(new MuebleAuxiliar("A0008", "Sofa", 3, 1,3,1000, 11,"Gris"));
        catalogos.get(0).getMuebles().add(new MuebleAuxiliar("A0009", "Sofa", 3, 3,2,1500, 17,"Blanco"));
        catalogos.get(0).getMuebles().add(new MuebleAuxiliar("A00010", "Rinconera", 1, 1,0.5,199.9, 20,"Negro"));

        catalogos.get(2).getMuebles().add(new MuebleClasico("C0011", "Aparador", 2,2,3,726, 5, 5, "Castaño"));
        catalogos.get(2).getMuebles().add(new MuebleClasico("C0012", "Mesa de noche", 1,1,1,333.3, 99, 3, "Pino"));
        catalogos.get(2).getMuebles().add(new MuebleClasico("C0013", "Aparador", 2,2,1,99.9, 5, 50, "Pino"));
        catalogos.get(2).getMuebles().add(new MuebleClasico("C0014", "Silla", 1,1,1,19.99, 11, 20, "Roble"));
        catalogos.get(2).getMuebles().add(new MuebleClasico("C0015", "Estantería", 2,1,3,75, 2, 60, "Olivo"));
        catalogos.get(2).getMuebles().add(new MuebleAuxiliar("A0011", "Silla", 0.5, 1,0.5,9.9, 30,"Rojo"));
        catalogos.get(2).getMuebles().add(new MuebleAuxiliar("A0012", "Mesa", 1, 1,2,50, 50,"Marrón"));
        catalogos.get(2).getMuebles().add(new MuebleAuxiliar("A0013", "Cama", 3, 1,5,499.9, 10,"Blanco"));
        catalogos.get(2).getMuebles().add(new MuebleAuxiliar("A0014", "Sofa", 5, 2,4,1500, 6,"Gris"));
        catalogos.get(2).getMuebles().add(new MuebleAuxiliar("A0015", "Rinconera", 1, 1,1,9.99, 25,"Negro"));

        ventas.add(new Venta(LocalDate.now(), "Victor", catalogos.get(2).getMuebles().get(1)));
        ventas.add(new Venta(LocalDate.of(2018, 10, 30), "Luis", catalogos.get(1).getMuebles().get(3)));
        ventas.add(new Venta(LocalDate.of(2019, 05, 15), "Raul", catalogos.get(2).getMuebles().get(7)));
        ventas.add(new Venta(LocalDate.of(2020, 04, 15), "Paco", catalogos.get(2).getMuebles().get(1)));
        ventas.add(new Venta(LocalDate.of(2020, 04, 18), "Rosa", catalogos.get(0).getMuebles().get(1)));
    }
    private void addCatalogos(){
        catalogos.add(new Catalogo("Invierno 2020"));
        catalogos.add(new Catalogo("Primavera 2020"));
        catalogos.add(new Catalogo("Verano 2020"));
    }
    public ArrayList<Mueble> getMueblesClasicos(){
        Catalogo c;
        ArrayList<Mueble> muebles = new ArrayList<>();
        for (int i = 0; i < catalogos.size(); i++) {
            c = catalogos.get(i);
            for (int j = 0; j < c.getMuebles().size(); j++) {
                if (c.getMuebles().get(j) instanceof MuebleClasico){
                    muebles.add(c.getMuebles().get(j));
                }
            }
        }
        return muebles;
    }
    public ArrayList<Mueble> getMueblesAux(){
        Catalogo c;
        ArrayList<Mueble> muebles = new ArrayList<>();
        for (int i = 0; i < catalogos.size(); i++) {
            c = catalogos.get(i);
            for (int j = 0; j < c.getMuebles().size(); j++) {
                if (c.getMuebles().get(j) instanceof MuebleAuxiliar){
                    muebles.add(c.getMuebles().get(j));
                }
            }
        }
        return muebles;
    }

    public Catalogo buscarCatalogoId(int id){
        Catalogo c;
        for (int i = 0; i < catalogos.size(); i++) {
            c = catalogos.get(i);
            if (c.getId() == id){
                return c;
            }
        }
        return null;
    }
    public ArrayList<Mueble> getAllMuebles(){
        Catalogo c;
        ArrayList<Mueble> muebles = new ArrayList<>();
        for (int i = 0; i < catalogos.size(); i++) {
            c = catalogos.get(i);
            for (int j = 0; j < c.getMuebles().size(); j++) {
                muebles.add(c.getMuebles().get(j));
            }
        }
        return muebles;
    }
    public ArrayList<Catalogo> getCatalogos() {
        return catalogos;
    }
    public double getMediaPrecioMuebles(){
        Mueble aux;
        double resultado = 0;
        int contador = 0;
        Catalogo c;
        for (int i = 0; i < catalogos.size(); i++) {
            c = catalogos.get(i);
            for (int j = 0; j < c.getMuebles().size(); j++) {
                aux = c.getMuebles().get(j);
                resultado = aux.getPrecio();
                contador++;
            }
        }
        return resultado / contador;
    }
    public Mueble getMuebleMasGrande(){
        Mueble masGrande = null;
        double medidasMax = Integer.MIN_VALUE;
        double medidasAux;
        Mueble aux;
        Catalogo c;
        for (int i = 0; i < catalogos.size(); i++) {
            c = catalogos.get(i);
            for (int j = 0; j < c.getMuebles().size(); j++) {
                aux = c.getMuebles().get(j);
                medidasAux = aux.getAlto() * aux.getAncho() * aux.getProfundo();
                if (medidasAux > medidasMax){
                    masGrande = aux;
                    medidasMax = medidasAux;
                }
            }
        }
        return masGrande;
    }
    public Mueble buscarMuebleId(Catalogo c,String cod){
        ArrayList<Mueble> muebles = c.getMuebles();
        Mueble m;
        for (int i = 0; i < muebles.size(); i++) {
            m = muebles.get(i);
            if (m.getCodigo().equalsIgnoreCase(cod)){
                return m;
            }
        }
        return null;
    }
    public double venderMueble(Mueble m,double km, String nombreCliente){
        if (m.getStock() <= 0){
            return -1;
        }
        ventas.add(new Venta(LocalDate.now(), nombreCliente, m));
        m.venderMueble();
        return m.costeEnvio(km);
    }
    public Mueble muebleMasVendido(){
        Mueble mAux;
        Mueble m = null;
        int mayor = Integer.MIN_VALUE;
        int actual;
        HashMap<Mueble, Integer> muebles = new HashMap<>();
        for (int i = 0; i < ventas.size(); i++) {
            mAux = ventas.get(i).getMueble();
            if (muebles.containsKey(mAux)){
                muebles.put(mAux, muebles.get(mAux) + 1);
            }else {
                muebles.put(mAux,1);
            }
        }
        for (Mueble key : muebles.keySet()) {
            actual = muebles.get(key);
            if (actual > mayor){
                m = key;
            }
        }
        return m;
    }
}

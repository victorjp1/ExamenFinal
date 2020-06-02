package com.victorlopez.ExamenFinal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static boolean validado;
    private static Scanner lector = new Scanner(System.in);
    private static Tienda tienda = new Tienda();
    public static void main(String[] args) {
        boolean salir = false;
        do {
            int opcion = mostrarMenu();
            switch (opcion){
                case 1:
                    venderMueble();
                    break;
                case 2:
                    consultas();
                    break;
                case 3:
                    estadísticas();
                    break;
                case 0:
                    salir = true;
                    break;
            }
        }while (!salir);
    }
    private static void estadísticas(){
        boolean volver = false;
        do {
            int opcion = menuEstadisticas();
            switch (opcion){
                case 1:
                    System.out.println(tienda.getMuebleMasGrande().toString());
                    break;
                case 2:
                    System.out.println("La media de precio de los muebles es: " + tienda.getMediaPrecioMuebles());
                    break;
                case 3:
                    System.out.println(tienda.muebleMasVendido().toString());
                    break;
            }
        }while (!volver);
    }
    private static int menuEstadisticas(){
        int opcion = -1;
        do {
            try {
                System.out.println("******************");
                System.out.println("** Estadísticas **");
                System.out.println("******************");
                System.out.println("1. Mueble más grande");
                System.out.println("2. Media de precios de todos los muebles");
                System.out.println("3. Mueble más vendido");
                System.out.println("-----------------------------------------");
                System.out.println("0. Volver al menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion <= 3 && opcion >= 0){
                    validado = true;
                }else {
                    validado = false;
                    System.out.println("Opción incorrecta");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
       return opcion;
    }
    private static void consultas(){
        boolean volver = false;
        do {
            int opcion = menuConsultas();
            switch (opcion){
                case 1:
                    porCatalogo();
                    break;
                case 2:
                    porTipo();
                    break;
                case 3:
                    porStock();
                    break;
                case 0:
                    volver = true;
                    System.out.println("Has elegido volver al menú principal...");
            }
            Lib.pausa();
            Lib.limpiarPantalla();
        }while (!volver);
    }
    private static void porStock(){
        ArrayList<Mueble> muebles = tienda.getAllMuebles();
        Collections.sort(muebles, new Mueble.ComparatorMuebleStock());
        System.out.println(muebles.toString());
    }
    private static void porTipo(){
        int opcion = menuTipoMueble();
        ArrayList<Mueble> muebles;
        switch (opcion){
            case 1:
                muebles = tienda.getMueblesClasicos();
                Collections.sort(muebles, new Mueble.ComparatorMuebleCod());
                System.out.println(muebles.toString());
                break;
            case 2:
                muebles = tienda.getMueblesAux();
                Collections.sort(muebles, new Mueble.ComparatorMuebleCod());
                System.out.println(muebles.toString());
                break;
        }
    }
    private static int menuTipoMueble(){
        int opcion = -1;
        do {
            try {
                System.out.println("******************");
                System.out.println("** TIPO MUEBLES **");
                System.out.println("******************");
                System.out.println("1. Clásicos");
                System.out.println("2. Auxiliar");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion == 1 || opcion == 2){
                    validado = true;
                }else {
                    validado = false;
                    System.out.println("Opción incorrecta");
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
            }
        }while (!validado);
        return opcion;
    }
    private static void porCatalogo(){
        Collections.sort(tienda.getCatalogos());
        Catalogo c = pedirCatalogo(tienda.getCatalogos());
        Collections.sort(c.getMuebles(), new Mueble.ComparatorMueblePrecioAsc());
        System.out.println(c.getMuebles().toString());
    }
    private static int menuConsultas(){
        int opcion = -1;
        do {
            try {
                System.out.println("***************");
                System.out.println("** CONSULTAS **");
                System.out.println("***************");
                System.out.println("1. Por catálogo");
                System.out.println("2. Por tipo");
                System.out.println("3. Por stock");
                System.out.println("________________");
                System.out.println("0. Menú principal");
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion <= 3 && opcion >= 0){
                    validado = true;
                }else {
                    validado =false;
                    System.out.println("Opción incorrecta!");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }
    private static void venderMueble(){
        double km;
        double precio;
        String nombreCliente;
        Catalogo c;
        Mueble m;
        ArrayList<Catalogo> cs = tienda.getCatalogos();
        Collections.sort(cs);
        c = pedirCatalogo(cs);
        Collections.sort(c.getMuebles());
        km = pedirKm();
        m = pedirMueble(c);
        nombreCliente = pedirNombre();
        precio = tienda.venderMueble(m, km, nombreCliente);
        if (precio < 0){
            System.out.println("No quedan existencias de este mueble");
        }else {
            System.out.println("Mueble vendido correctamente");
            System.out.println("Su precio es: " + precio);
        }
        Lib.pausa();
        Lib.limpiarPantalla();
    }
    /**
     * Método para pedir el nombre del paciente
     * @return devuelve el nombre ya validado y en minúsculas
     */
    public static String pedirNombre(){
        String nombre;
        do {
            System.out.println("Introduce el nombre del cliente:");
            nombre = lector.nextLine().trim().toLowerCase();
            if (nombre.length() >= 3){
                validado = true;
            }else{
                validado = false;
                System.out.println("El nombre debe tener mínimo 3 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
            }
        }while (!validado);
        return nombre;
    }

    private static Mueble pedirMueble(Catalogo c){
        String cod;
        Mueble m;
        do {
            System.out.println(c.getMuebles().toString());
            cod =pedirCodMueble();
            m = tienda.buscarMuebleId(c, cod);
            if (c == null){
                System.out.println("No existe ningún mueble con ese código");
                Lib.pausa();
            }
        }while (m == null);
        return m;
    }
    private static Catalogo pedirCatalogo(ArrayList<Catalogo> cs){
        int id;
        Catalogo c;
        do {
            System.out.println(cs.toString());
            id = pedirId("catálogo");
            c = tienda.buscarCatalogoId(id);
            if (c == null){
                System.out.println("No existe ningún catálogo con ese ID");
                Lib.pausa();
            }
        }while (c == null);
        return c;
    }
    private static double pedirKm(){
        double km = -1;
        do {
            try {
                System.out.println("Introduce los km de distancia del envío:");
                km = Double.parseDouble(lector.nextLine());
                if (km < 0){
                    validado = false;
                    System.out.println("Los km no pueden ser negativos!");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto!");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return km;
    }
    private static String pedirCodMueble(){
        String cod;
        do {
            System.out.println("Introduce el código del mueble:");
            cod = lector.nextLine().toUpperCase();
            if (cod.length() != 5){
                System.out.println("El código debe tener exactamente 5 caracteres");
                Lib.pausa();
                Lib.limpiarPantalla();
                validado = false;
            }else {
                validado = true;
            }
        }while (!validado);
        return cod;
    }
    private static int pedirId(String nombre){
        int opcion = -1;
        do {
            try{
                System.out.println("Introduce el ID del " + nombre);
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion <= 0){
                    validado = false;
                    System.out.println("No puede existir un ID negativo");
                }else {
                    validado = true;
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto");
                Lib.pausa();
            }
        }while (!validado);
        return opcion;
    }
    private static int mostrarMenu(){
        int opcion = -1;
        do {
            System.out.println("***********************");
            System.out.println("** TIENDA DE MUEBLES **");
            System.out.println("***********************");
            System.out.println("1. Vender mueble");
            System.out.println("2. Búsquedas");
            System.out.println("3. Estadísticas");
            System.out.println("------------------------");
            System.out.println("0. Salir");
            try{
                opcion = Integer.parseInt(lector.nextLine());
                if (opcion >= 0 && opcion <= 3){
                    validado = true;
                }else{
                    validado = false;
                    System.out.println("Opción incorrecta!!");
                    Lib.pausa();
                }
            }catch (NumberFormatException nfe){
                validado = false;
                System.out.println("Formato incorrecto!");
                Lib.pausa();
            }
            Lib.limpiarPantalla();
        }while (!validado);
        return opcion;
    }
}

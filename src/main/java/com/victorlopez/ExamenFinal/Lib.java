package com.victorlopez.ExamenFinal;

import java.util.Random;
import java.util.Scanner;

public class Lib {
    /**
     * Método para dar tiempo al user a leer datos, esperando un intro
     */
    public static void pausa(){
        Scanner lector = new Scanner(System.in);
        System.out.println("Pulsa intro para continuar.");
        lector.nextLine();
    }

    /**
     * Método para limpiar la pantalla y colocar el cursor arriba a la izquierda
     */
    public static void limpiarPantalla(){
        System.out.print("\u001B[H\u001B[2J");
        System.out.flush();
    }
}

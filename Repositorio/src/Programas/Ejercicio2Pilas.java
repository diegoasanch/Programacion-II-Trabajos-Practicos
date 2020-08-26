package Programas;

import Interfaces.PilaTDA;
import Metodos.MetodosPilas;
import Implementaciones.PilaTopeIni;

import java.util.Scanner;

class Ejercicio2Pilas {
    public static void main(String[] args) {
        PilaTDA pila1 = new PilaTopeIni();
        PilaTDA pila2 = new PilaTopeIni();

        // Cargamos los metodos de pilas
        MetodosPilas pilas = new MetodosPilas();

        pila1.inicializarPila();
        pila2.inicializarPila();

        // Cargamos valores de prueba a pila1
        pilas.cargaPila(pila1);

        System.out.println("Que desea hacer con la pila?");
        System.out.println(" 1 - Transferir a otra pila.");
        System.out.println(" 2 - Copiar la pila.");
        System.out.println(" 3 - Invertir la pila.");
        System.out.print("Ingrese una opcion: ");

        Scanner teclado = new Scanner(System.in);
        int opcion = teclado.nextInt();
        teclado.close();

        switch(opcion) {
            case 1:
                pilas.pilaToPila(pila1, pila2);
                // Imprimimos los valores en la lista2
                pilas.imprimePila(pila2);
                break;

            case 2:
                pilas.copyPila(pila1, pila2);
                // Imprimimos ambas pilas para ver si funciono
                pilas.imprimePila(pila1);
                pilas.imprimePila(pila2);
                break;

            case 3:
                pilas.copyPila(pila1, pila2);
                pilas.inviertePila(pila2);
                System.out.println("Pila original");
                pilas.imprimePila(pila1);
                System.out.println("Pila Invertida");
                pilas.imprimePila(pila2);
                break;
            
                default:
                System.out.println("Ingreso una opcion invalida!");
        }

    }


}
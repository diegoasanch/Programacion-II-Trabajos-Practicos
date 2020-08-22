package Programas;

import Interfaces.PilaTDA;
import Metodos.Metodos_pilas;
import Implementaciones.PilaTopeIni;

import java.util.Scanner;

class Ejercicio_2_pilas {
    public static void main(String[] args) {
        PilaTDA pila1 = new PilaTopeIni();
        PilaTDA pila2 = new PilaTopeIni();

        // Cargamos los metodos de pilas
        Metodos_pilas pilas = new Metodos_pilas();

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
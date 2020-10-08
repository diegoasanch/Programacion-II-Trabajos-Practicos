package Programas;

import java.util.Random;

public class EjercicioClase8 {

    public static class Nodo {
        int valor;
        Nodo sig;
    }

    public static void main(String[] args) {

        Random random = new Random(System.currentTimeMillis());
        final int CANT = 10;


        // Suma de vector

        int [] miVector;
        miVector = new int[CANT];
        int i;

        for (i = 0; i < CANT; i++)
            miVector[i] = random.nextInt(1000);

        System.out.println("\n\nLa suma de todos los elementos es: " + sumaVector(miVector, CANT - 1));


        // Menor en lista enlazada

        Nodo inicio = new Nodo();
        inicio.valor = random.nextInt(1000);
        Nodo actual = inicio;

        for (i = 0; i < CANT; i++) {
            actual.sig = new Nodo();
            actual = actual.sig;
            actual.valor = random.nextInt(1000);
        }

        System.out.println("El menor elemento de la lista enlazada es: " + menorEnLista(inicio) + "\n\n");
    }


    public static int sumaVector(int[] vector, int longitud) {
        if (longitud == 0)
            return vector[0];
        else
            return vector[longitud] + sumaVector(vector, longitud - 1);
    }

    public static int menorEnLista(Nodo actual) {
        if (actual.sig == null)
            return actual.valor;
        else
            return menor(actual.valor, menorEnLista(actual.sig));
    }

    public static int menor(int a, int b) {
        return (a < b) ? a : b;
    }
}

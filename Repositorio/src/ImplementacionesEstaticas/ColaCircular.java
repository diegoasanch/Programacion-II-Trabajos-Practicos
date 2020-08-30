package ImplementacionesEstaticas;

import Interfaces.ColaTDA;

public class ColaCircular implements ColaTDA {
    private int [] vector;
    private int primero;
    private int ultimo;

    public void inicializarCola() {
        vector = new int[100];
        primero = 0;
        ultimo = 0;
    }
    public void acolar(int x) {
        vector[ultimo] = x;
        ultimo ++;
        if (ultimo > 100) {
            ultimo = 0;
        }
    }
    public void desacolar() {
        primero ++;
        if (primero > 100) {
            primero = 0;
        }
    }
    public int primero() {
        return vector[primero];
    }
    public boolean colaVacia() {
        return (primero == ultimo);
    }
}
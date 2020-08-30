package ImplementacionesEstaticas;

import Interfaces.ColaPrioridadTDA;

public class ColaPrioridad implements ColaPrioridadTDA {
    
    class Elem {
        int valor;
        int prioridad;
    }

    private Elem [] vector;
    private int cant;

    public void inicializarCola() {
        vector = new Elem[100];
        cant = 0;
    }

    public void acolarPrioridad(int valor, int prioridad) {
        int i = cant-1;

        while (i >= 0 && prioridad < vector[i].prioridad) {
            vector[i + 1] = vector[i];
            i --;
        }
        vector[i + 1] = new Elem();
        vector[i + 1].prioridad = prioridad;
        vector[i + 1].valor = valor;

        cant ++;
    }

    public void desacolar() {
        cant --;
    }

    public int primerValor() {
        return vector[cant - 1].valor;
    }

    public int primeraPrioridad() {
        return vector[cant - 1].prioridad;
    }

    public boolean colaVacia() {
        return cant == 0;
    }

}
package ImplementacionesDinamicas;
import Interfaces.ColaTDA;

public class ColaPrimIni implements ColaTDA {
    class Nodo {
        int dato;
        Nodo sig;
    }
    private Nodo inicio;
    private Nodo ultimo;

    public void inicializarCola() {
        inicio = null;
    }

    public void acolar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.dato = x;
        nuevo.sig = null;

        // Si el item inicio no es el primero
        if (inicio != null) {
            ultimo.sig = nuevo;
            ultimo = nuevo;
        }
        else {
            inicio = ultimo = nuevo;
        }
    }

    public void desacolar() {
        if (inicio == ultimo) {
            inicio = ultimo = null;
        }
        else {
            inicio = inicio.sig;
        }
    }

    public int primero() {
        return inicio.dato;
    }

    public boolean colaVacia() {
        return inicio == null;
    }
}

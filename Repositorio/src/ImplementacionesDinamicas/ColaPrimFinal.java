package ImplementacionesDinamicas;
import Interfaces.ColaTDA;

public class ColaPrimFinal implements ColaTDA {
    class Nodo {
        int dato;
        Nodo sig;
    }

    private Nodo inicio;
    private Nodo fin;

    public void inicializarCola() {
        inicio = fin = null;
    }

    public void acolar(int dato) {
        Nodo nuevo = new Nodo();
        nuevo.dato = dato;
        nuevo.sig = inicio;
        inicio = nuevo;
        if (inicio.sig == null)
            fin = inicio;
    }

    public void desacolar() {
        if (inicio.sig == null) {
            inicio = fin = null;
        }
        else {
            Nodo anterior;
            Nodo actual = inicio;
            do {
                anterior = actual;
                actual = actual.sig;
            } while (actual.sig != null);
            
            anterior.sig = null;
            fin = anterior;
        }
    }

    public int primero() {
        return fin.dato;
    }

    public boolean colaVacia() {
        return inicio == null;
    }

}

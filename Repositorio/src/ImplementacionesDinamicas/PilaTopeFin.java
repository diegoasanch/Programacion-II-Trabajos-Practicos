package ImplementacionesDinamicas;
import Interfaces.PilaTDA;

public class PilaTopeFin implements PilaTDA {
    class Nodo {
        int dato;
        Nodo siguiente;
    }
    private Nodo inicio;
    private Nodo fin;

    public void inicializarPila() {
        inicio = null;
        fin = null;
    }

    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.dato = x;
        nuevo.siguiente = null;
        if (inicio == null)
            inicio = fin = nuevo;
        else {
            fin.siguiente = nuevo;
            fin = nuevo;
        }
    }

    public int topeSacar() {
        int tope = fin.dato;

        // cuando solo queda un elemento
        if (inicio.siguiente == null)
            inicio = fin = null;
        // cuando quedan mas de 1
        else {
            Nodo actual = inicio;
            Nodo anterior = actual;

            while (actual.siguiente != null) {
                anterior = actual;
                actual = actual.siguiente;
            }
            anterior.siguiente = null;
            fin = anterior;
        }
        return tope;
    }

    public boolean pilaVacia() {
        return inicio == null;
    }
    
}
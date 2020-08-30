package ImplementacionesDinamicas;
import Interfaces.PilaTDA;


public class PilaTopeIni implements PilaTDA {
    class Nodo {
        int valor;
        Nodo siguiente;
    }
    private Nodo inicio;

    public void inicializarPila() {
        inicio = null;
    }

    public void apilar(int x) {
        Nodo nuevo = new Nodo();
        nuevo.valor = x;
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }

    public int topeSacar() {
        int tope = inicio.valor;
        inicio = inicio.siguiente;

        return tope;
    }

    public boolean pilaVacia() {
        return inicio == null;
    }
}
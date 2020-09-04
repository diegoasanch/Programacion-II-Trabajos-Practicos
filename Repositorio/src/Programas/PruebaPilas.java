package Programas;

import ImplementacionesDinamicas.PilaTopeIni;
import Metodos.MetodosPilas;

class PruebaPilas {
    public static void main(String[] args) {
        
        MetodosPilas metodos = new MetodosPilas();

        PilaTopeIni pila = new PilaTopeIni();
        pila.inicializarPila();

        metodos.cargaPila(pila);

        System.out.println("Pila original:");
        metodos.imprimePila(pila);

        metodos.eliminaRepetidos(pila);
        System.out.println("Pila sin repetidos");
        metodos.imprimePila(pila);
    }
}
package Programas;

import Interfaces.PilaTDA;
import Interfaces.ColaTDA;
import Metodos.MetodosPilas;

import Metodos.MetodosColas;
import ImplementacionesDinamicas.PilaTopeFin;
import ImplementacionesEstaticas.ColaCircular;

class Ejercicio2Pilas {
    public static void main(String[] args) {
        PilaTDA pila = new PilaTopeFin();
        ColaTDA cola = new ColaCircular();

        // Cargamos los metodos de pilas
        MetodosPilas metodosPilas = new MetodosPilas();
        MetodosColas metodosColas = new MetodosColas();

        pila.inicializarPila();
        cola.inicializarCola();

        // Cargamos valores de prueba a pila
        metodosPilas.cargaPila(pila);

        System.out.println("Pila");
        metodosPilas.imprimePila(pila);
        
        System.out.println("Cola");
        metodosPilas.pilaACola(pila, cola);
        metodosColas.imprimeCola(cola);

    }
}
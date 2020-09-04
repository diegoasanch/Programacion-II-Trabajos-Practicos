package Programas;

import ImplementacionesDinamicas.ColaPrioridad;
import Metodos.MetodosColasPrioridad;

class PruebasColas {
    public static void main(String[] args) {

        MetodosColasPrioridad metodos = new MetodosColasPrioridad();

        ColaPrioridad cola1 = new ColaPrioridad();
        ColaPrioridad cola2 = new ColaPrioridad();
        cola1.inicializarCola();
        cola2.inicializarCola();

        metodos.cargaCola(cola1);
        metodos.copiaCola(cola1, cola2);

        metodos.imprimeCola(cola1);
        metodos.imprimeCola(cola2);

    }
}
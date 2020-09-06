package Programas;

import ImplementacionesDinamicas.ColaPrioridad;
import Metodos.MetodosColasPrioridad;
import Interfaces.ColaPrioridadTDA;

class PruebasColas {
    public static void main(String[] args) {

        MetodosColasPrioridad metodos = new MetodosColasPrioridad();

        ColaPrioridadTDA cola1 = new ColaPrioridad();
        ColaPrioridadTDA cola2 = new ColaPrioridad();
        cola1.inicializarCola();
        cola2.inicializarCola();

        System.out.println("Cargue la cola 1.");
        metodos.cargaCola(cola1);

        System.out.println("Cargue la cola 2.");
        metodos.cargaCola(cola2);

        ColaPrioridadTDA dif = metodos.diferenciaSimetrica(cola1, cola2);

        System.out.println("La diferencia de las colas es:");
        metodos.imprimeCola(dif);
    }
}
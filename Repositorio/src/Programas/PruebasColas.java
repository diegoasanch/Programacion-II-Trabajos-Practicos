package Programas;

import Implementaciones.ColaPrioridadDes;

import Metodos.MetodosColasPrioridad;

class PruebasColas {
    public static void main(String[] args) {

        MetodosColasPrioridad metodos = new MetodosColasPrioridad();

        ColaPrioridadDes cola1 = new ColaPrioridadDes();
        cola1.inicializarCola();

        metodos.cargaCola(cola1);

        metodos.imprimeCola(cola1);

    }
}
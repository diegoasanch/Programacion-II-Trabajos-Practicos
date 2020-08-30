package Programas;

import ImplementacionesEstaticas.Conjunto;
import Metodos.MetodosConjuntos;

class Ejercicio4 {
    public static void main(String[] args) {

        MetodosConjuntos metodos = new MetodosConjuntos();

        Conjunto conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        
        Conjunto conjunto2 = new Conjunto();
        conjunto2.inicializarConjunto();
        
        metodos.cargar(conjunto);
    

        metodos.imprimir(conjunto);

    }
}
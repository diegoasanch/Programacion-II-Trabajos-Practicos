package Programas;

import Implementaciones.Conjunto;
import Metodos.MetodosConjuntos;

class Ejercicio4 {
    public static void main(String[] args) {

        MetodosConjuntos metodos = new MetodosConjuntos();

        Conjunto conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        
        Conjunto conjunto2 = new Conjunto();
        conjunto2.inicializarConjunto();
        
        for (int i = 4; i < 16; i++) {
            conjunto.agregar(i);
        }
        
        for (int i = 0; i < 10; i++) {
            conjunto2.agregar(i);
        }
    
        Conjunto difSim = metodos.diferenciaSimetrica(conjunto, conjunto2);
        metodos.imprimir(difSim);

    }
}
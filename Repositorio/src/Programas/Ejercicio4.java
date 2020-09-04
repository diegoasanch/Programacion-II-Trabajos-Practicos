package Programas;

import ImplementacionesDinamicas.Conjunto;
import Metodos.MetodosConjuntos;

class Ejercicio4 {
    public static void main(String[] args) {

        MetodosConjuntos metodos = new MetodosConjuntos();

        System.out.println("Cargue el conjunto 1");
        Conjunto conjunto = new Conjunto();
        conjunto.inicializarConjunto();
        metodos.cargar(conjunto);
        
        System.out.println("Cargue el conjunto 2");
        Conjunto conjunto2 = new Conjunto();
        conjunto2.inicializarConjunto();        
        metodos.cargar(conjunto2);

        metodos.imprimir(conjunto);
        System.out.println("-----------");
        metodos.imprimir(conjunto2);

        if (metodos.sonIguales(conjunto, conjunto2)) {
            System.out.println("Los conjuntos son iguales");
        }
        else {
            System.out.println("Los conjuntos son ditintos");
        }

    }
}
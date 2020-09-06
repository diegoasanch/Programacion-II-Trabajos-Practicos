package Programas;

import ImplementacionesDinamicas.ColaPrimFinal;
import Interfaces.ColaTDA;
import Metodos.MetodosColas;

class Ejercicio5Colas {
    public static void main(String[] args) {
        
        ColaTDA cola = new ColaPrimFinal();
        cola.inicializarCola();
        MetodosColas metodos = new MetodosColas();
        metodos.cargaCola(cola);

        int masLarga = metodos.secuenciaMasLarga(cola);
        System.out.println("La secuencia mas larga es de " + masLarga + " elementos");
    }
}
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

        ColaTDA[] contenedor = metodos.colaMitades(cola);

        System.out.println("Cola original");
        metodos.imprimeCola(cola);
        
        for (int i = 0; i < 2; i++) {
            System.out.println("Mitad " + (i + 1));
            metodos.imprimeCola(contenedor[i]);
        }
    }
}
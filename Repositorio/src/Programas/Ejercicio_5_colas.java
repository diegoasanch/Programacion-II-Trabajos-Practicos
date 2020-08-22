package Programas;

import Interfaces.ColaTDA;
import Implementaciones.ColaCircular;
import Metodos.Metodos_colas;

class Ejercicio_5_colas {
    public static void main(String[] args) {
        
        ColaTDA cola = new ColaCircular();
        cola.inicializarCola();

        Metodos_colas metodos = new Metodos_colas();

        metodos.cargaCola(cola);

        metodos.invierteCola(cola);

        System.out.println("Cola invertida:");
        metodos.imprimeCola(cola);
    }
}
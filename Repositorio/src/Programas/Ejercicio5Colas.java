package Programas;

import Interfaces.ColaTDA;
import Implementaciones.ColaCircular;
import Metodos.MetodosColas;

class Ejercicio5Colas {
    public static void main(String[] args) {
        
        ColaTDA cola = new ColaCircular();
        cola.inicializarCola();

        MetodosColas metodos = new MetodosColas();

        metodos.cargaCola(cola);

        metodos.invierteCola(cola);

        System.out.println("Cola invertida:");
        metodos.imprimeCola(cola);
    }
}
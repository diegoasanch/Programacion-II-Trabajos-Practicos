package Programas;
import Interfaces.ColaTDA;
import Metodos.Metodos_colas;
import Implementaciones.ColaCircular;

class Ejercicio_3 {
    public static void main(String[] args) {
        ColaTDA cola = new ColaCircular();
        Metodos_colas metodos = new Metodos_colas();
        
        cola.inicializarCola();
        metodos.cargaCola(cola);

        metodos.imprimeCola(cola);
    }
}
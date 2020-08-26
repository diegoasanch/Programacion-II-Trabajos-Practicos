package Programas;
import Interfaces.ColaTDA;
import Metodos.MetodosColas;
import Implementaciones.ColaCircular;

class Ejercicio3 {
    public static void main(String[] args) {
        ColaTDA cola = new ColaCircular();
        MetodosColas metodos = new MetodosColas();
        
        cola.inicializarCola();
        metodos.cargaCola(cola);

        metodos.imprimeCola(cola);
    }
}
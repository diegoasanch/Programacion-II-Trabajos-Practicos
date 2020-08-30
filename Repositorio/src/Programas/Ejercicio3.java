package Programas;
import ImplementacionesEstaticas.ColaCircular;
import Interfaces.ColaTDA;
import Metodos.MetodosColas;

class Ejercicio3 {
    public static void main(String[] args) {
        ColaTDA cola = new ColaCircular();
        MetodosColas metodos = new MetodosColas();
        
        cola.inicializarCola();
        metodos.cargaCola(cola);

        metodos.imprimeCola(cola);
    }
}
package Programas;
import Interfaces.ColaTDA;
import Implementaciones.ColaPrimIni;

class Ejercicio_4 {
    public static void main(String[] args) {
        ColaTDA cola = new ColaPrimIni();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        cola.acolar(4);

        while (! cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }
}
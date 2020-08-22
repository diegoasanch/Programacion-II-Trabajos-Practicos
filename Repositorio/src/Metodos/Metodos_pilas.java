package Metodos;

import Interfaces.PilaTDA;
import Implementaciones.PilaTopeIni;
import java.util.Scanner;

import Implementaciones.ColaCircular;


public class Metodos_pilas {

    // Cargar los valores en una pila hasta que se ingrese -1
    public void cargaPila(PilaTDA pila) {
        Scanner input = new Scanner(System.in);
        int num;

        System.out.print("Ingrese un numero: ");
        num = input.nextInt();
        while (num != -1) {
            pila.apilar(num);
            System.out.print("Ingrese un numero: ");
            num = input.nextInt();
        }

    }

    public void imprimePila(PilaTDA pila) {
        while (! pila.pilaVacia()) {
            System.out.println(pila.topeSacar());
        }
    }

    //  Pasar los valores de una pila a otra pila
    public void pilaToPila(PilaTDA pila1, PilaTDA pila2) {
        PilaTDA pilaaux = new PilaTopeIni();
        pilaaux.inicializarPila();
        
        // Pasamos de pila1 a pilaaux
        while (! pila1.pilaVacia()) {
            pilaaux.apilar(pila1.topeSacar());
        }

        // Pasamos de pilaaux a pila2
        while (! pilaaux.pilaVacia()) {
            pila2.apilar(pilaaux.topeSacar());
        }
    }

    // Copiar una pila a otra preservando la original
    public void copyPila(PilaTDA pila1, PilaTDA pila2) {
        PilaTDA pilaaux = new PilaTopeIni();
        pilaaux.inicializarPila();

        // Pasamos de pila1 a la auxiliar
        while (! pila1.pilaVacia()) {
            pilaaux.apilar(pila1.topeSacar());
        }

        int temporal;
        // Pasamos de pila aux a pila1 y 2
        while (! pilaaux.pilaVacia()) {
            temporal = pilaaux.topeSacar();
            pila1.apilar(temporal);
            pila2.apilar(temporal);
        }
    }

    // Invierte una pila, la pila resultante queda grabada sobre la pila original
    public void inviertePila(PilaTDA pila) {
        ColaCircular cola = new ColaCircular();
        cola.inicializarCola();

        // Pasamos los valores de pila a una cola auxiliar
        while (! pila.pilaVacia()) {
            cola.acolar(pila.topeSacar());
        }
        // Devolvemos los valores a la pila original
        while (! cola.colaVacia()) {
            pila.apilar(cola.primero());
            cola.desacolar();
        }
    }
}
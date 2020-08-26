package Metodos;

import Interfaces.PilaTDA;
import Implementaciones.PilaTopeIni;
import java.util.Scanner;

import Implementaciones.ColaCircular;


public class MetodosPilas {

    // Cargar los valores por tec;ado en una pila hasta que se ingrese -1
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
        input.close();
    }

    // Imprime los valores de pila de manera NO destructiva
    public void imprimePila(PilaTDA pila) {
        PilaTDA pilaAux = new PilaTopeIni();
        pilaAux.inicializarPila();
        int temporal;

        // Pasamos los valores impresos a una pila temporal
        while (! pila.pilaVacia()) {
            temporal = pila.topeSacar();
            pilaAux.apilar(temporal);

            System.out.println(temporal);
        }
        // Devolvemos los valores a pila og
        while (! pilaAux.pilaVacia()) {
            pila.apilar(pilaAux.topeSacar());
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

    /** Ordena de forma ascendente una pila sobre si misma utilizando el metodo de seleccion
     * @Precondicion La pila no debe estar vacia
     */
    public void ordenaPila(PilaTDA pila) {
        PilaTDA pilaAux = new PilaTopeIni();
        PilaTDA pilaOrd = new PilaTopeIni();

        pilaAux.inicializarPila();
        pilaOrd.inicializarPila();

        int menor;
        int valor;

        // Conseguimos el menor valor de la pila y lo pasamos a pilaOrd
        while (! pila.pilaVacia() || ! pilaAux.pilaVacia()) {
            
            // Inicializamos menor con el primer valor de pila
            menor = pila.topeSacar();
            
            while (! pila.pilaVacia()) {
                valor = pila.topeSacar();

                if (valor < menor) {
                    pilaAux.apilar(menor);
                    menor = valor;
                }
                else {
                    pilaAux.apilar(valor);
                }
            }
            // Apilamos el menor en pilaOrd y pasamos los valores de pilaAux a pila
            pilaOrd.apilar(menor);
            while (! pilaAux.pilaVacia()) {
                pila.apilar(pilaAux.topeSacar());
            }
        }
        
        // Pasamos los valores de pilaOrd a pila (original)
        while (! pilaOrd.pilaVacia()) {
            pila.apilar(pilaOrd.topeSacar());
        }
    }

    /** Retorna boolean indicando si dos pilas son iguales y sus valores
     * estan guardados en el mismo orden
     * @Precondicion Las pilas a comparar no deben estar vacias
     */
    public boolean sonIguales(PilaTDA pila1, PilaTDA pila2) {

        // Copiamos las pilas recibidas para no alterarlas al recorrerlas
        PilaTDA p1 = new PilaTopeIni();
        PilaTDA p2 = new PilaTopeIni();

        p1.inicializarPila();
        p2.inicializarPila();

        copyPila(pila1, p1);
        copyPila(pila2, p2);

        boolean iguales = true;

        while (iguales && ! (p1.pilaVacia() || p2.pilaVacia())) {
            iguales = (p1.topeSacar() == p2.topeSacar());
        }

        // Si una pila se termino, pero la otra no
        if (p1.pilaVacia() ^ p2.pilaVacia())
            iguales = false;
        
        return iguales;
    }

}
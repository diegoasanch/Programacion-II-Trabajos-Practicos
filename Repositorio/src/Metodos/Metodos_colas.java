package Metodos;

import Interfaces.ColaTDA;
import Implementaciones.ColaCircular;
import java.util.Scanner;

public class Metodos_colas {

    /** @tarea cargaCola carga valores enteros en una cola
     * Finaliza la carga al ingresar -1
     */
    public void cargaCola(ColaTDA cola) {
        Scanner teclado = new Scanner(System.in);
        int numero;

        System.out.print("Ingrese un numero: ");
        numero = teclado.nextInt();

        while (numero != -1) {
            cola.acolar(numero);
            System.out.print("Ingrese un numero: ");
            numero = teclado.nextInt();
        }
    }

    // @tarea transfiere los elementos de cola1 a cola2
    public void colaToCola(ColaTDA cola1, ColaTDA cola2) {
        while (! cola1.colaVacia()) {
            cola2.acolar(cola1.primero());
            cola1.desacolar();
        }
    }

    /** @tarea imprimeCola imprime Destructivamente los valores
     * cargados en una cola.
     */
    public void imprimeCola(final ColaTDA cola) {
        while (!cola.colaVacia()) {
            System.out.println(cola.primero());
            cola.desacolar();
        }
    }

    // @tarea invierteCola sobre si misma sin la ayuda de una pila
    public void invierteCola(ColaTDA cola) {
        
        int temporal;

        ColaTDA cola_aux = new ColaCircular();
        ColaTDA cola_inv = new ColaCircular();

        cola_aux.inicializarCola();
        cola_inv.inicializarCola();

        // Invertimos y guardamos en cola_inv
        while (! cola.colaVacia() || ! cola_aux.colaVacia()) {
            
            temporal = cola.primero();
            cola.desacolar();

            // Acolamos el temporal (utlimo de lista original) a inv y devolvemos los valores a la original
            if (cola.colaVacia()) {
                cola_inv.acolar(temporal);
                colaToCola(cola_aux, cola);
            }
            else {
                cola_aux.acolar(temporal);
            }
        }
        // Pasamos de cola_inv a cola original
        colaToCola(cola_inv, cola);
    }
}
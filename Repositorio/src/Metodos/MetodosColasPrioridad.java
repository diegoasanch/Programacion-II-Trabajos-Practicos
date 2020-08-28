package Metodos;

import Interfaces.ColaPrioridadTDA;
import Implementaciones.ColaPrioridad;
import java.util.Scanner;

public class MetodosColasPrioridad {

    /** @tarea cargaCola carga valores enteros en una cola con prioridad
     * Finaliza la carga al ingresar valor -1
     */
    public void cargaCola(ColaPrioridadTDA cola) {
        Scanner teclado = new Scanner(System.in);
        
        int valor;
        int prioridad;

        System.out.print("Ingrese un valor: ");
        valor = teclado.nextInt();

        while (valor != -1) {
            System.out.print("Ingrese la prioridad: ");
            prioridad = teclado.nextInt();

            cola.acolarPrioridad(valor, prioridad);

            System.out.print("Ingrese un valor: ");
            valor = teclado.nextInt();
        }
        teclado.close();
    }

    /** @tarea Imprime cola imprime los pares de (prioridad, valor) de una 
     * cola con prioridad 
     */
    public void imprimeCola(ColaPrioridadTDA cola) {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();

        int valor;
        int prioridad;

        // Imprimimos los valores y los almacenamos temporalmente en colaAux
        while (! cola.colaVacia()) {
            valor = cola.primerValor();
            prioridad = cola.primeraPrioridad();
            cola.desacolar();
            
            colaAux.acolarPrioridad(valor, prioridad);

            System.out.println("Valor: " + valor + " - Prioridad: " + prioridad);
        }
        // Devolvemos los valores cola
        colaToCola(colaAux, cola);
    }

    /** @tarea colaToCola transfiere los valores y prioridades de una colaPrioridad a otra
     * @Precondicion Ambas colas deben estar inicializadas
     */
    public void colaToCola(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
        
        int valor;
        int prioridad;

        while (! cola1.colaVacia()) {
            valor = cola1.primerValor();
            prioridad = cola1.primeraPrioridad();
            cola1.desacolar();

            cola2.acolarPrioridad(valor, prioridad);
        }
    }

    /** @tarea copiaCola copia a cola2 el contenido de cola1 sin modificar su contenido
     * @precondicion ambas colas deben estar inicializadas
     */
    public void copiaCola(ColaPrioridad cola1, ColaPrioridad cola2) {

        int valor;
        int prioridad;

        ColaPrioridad colaAux = new ColaPrioridad();
        colaAux.inicializarCola();

        colaToCola(cola1, colaAux);
        
        while (!colaAux.colaVacia()) {
            valor = colaAux.primerValor();
            prioridad = colaAux.primeraPrioridad();

            colaAux.desacolar();
            cola1.acolarPrioridad(valor, prioridad);
            cola2.acolarPrioridad(valor, prioridad);
        }
    }

}
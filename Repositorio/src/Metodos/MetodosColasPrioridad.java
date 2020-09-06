package Metodos;

import Interfaces.ColaPrioridadTDA;
import java.util.Scanner;
import ImplementacionesDinamicas.ColaPrioridad;
import Interfaces.ConjuntoTDA;
import ImplementacionesDinamicas.Conjunto;

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
        // teclado.close();
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
    public void copiaCola(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {

        int valor;
        int prioridad;

        ColaPrioridadTDA colaAux = new ColaPrioridad();
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

    // Determina si dos colas con prioridad son iguales
    public boolean sonIguales(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
        boolean iguales = true;

        while (iguales && !(cola1.colaVacia() || cola2.colaVacia())) {
            iguales = (cola1.primerValor() == cola2.primerValor() && cola1.primeraPrioridad() == cola2.primeraPrioridad());
            cola1.desacolar();
            cola2.desacolar();
        }
        if (iguales)
            iguales = (cola1.colaVacia() && cola2.colaVacia());

        return iguales;
    }

    // Devuelve conjunto con los valores de una colaConPrioridad
    public ConjuntoTDA valoresCola(ColaPrioridadTDA cola) {
        ColaPrioridadTDA colaAux = new ColaPrioridad();
        colaAux.inicializarCola();
        copiaCola(cola, colaAux);

        ConjuntoTDA valores = new Conjunto();
        valores.inicializarConjunto();
        int num;

        while (!colaAux.colaVacia()) {
            num = colaAux.primerValor();
            colaAux.desacolar();
            
            if (!valores.pertenece(num))
                valores.agregar(num);
        }
        return valores;
    }

    /** Dadas dos colas con prioridad sin valores repetidos dentro de cada una
     * de ellas, generar una nueva cola con prioridad con aquellos valores de
     * la colas que solo estén en una de ellas.
    */
    public ColaPrioridadTDA diferenciaSimetrica(ColaPrioridadTDA cola1, ColaPrioridadTDA cola2) {
        // Creamos copias de las colas recibidas
        ColaPrioridadTDA colaAux1 = new ColaPrioridad();        
        ColaPrioridadTDA colaAux2 = new ColaPrioridad();
        colaAux1.inicializarCola();
        colaAux2.inicializarCola();
        copiaCola(cola1, colaAux1);
        copiaCola(cola2, colaAux2);
        ColaPrioridadTDA[] colas = new ColaPrioridadTDA[] {cola1, cola2};

        // Guardamos los valores de cada cola
        ConjuntoTDA valores1 = valoresCola(cola1);
        ConjuntoTDA valores2 = valoresCola(cola2);

        // Creamos un conjunto con los valores que solo estan en una de las colas
        MetodosConjuntos metodosConjuntos = new MetodosConjuntos();
        ConjuntoTDA diferencia = metodosConjuntos.diferenciaSimetrica(valores1, valores2);

        // Inicializamos la nueva cola
        ColaPrioridadTDA nuevaCola = new ColaPrioridad();
        nuevaCola.inicializarCola();

        for (int i = 0; i < 2; i++) {
            ColaPrioridadTDA cola = colas[i];
            while (! cola.colaVacia()) {
                int num = cola.primerValor();
                int pri = cola.primeraPrioridad();
                cola.desacolar();
                if (diferencia.pertenece(num)) {
                    nuevaCola.acolarPrioridad(num, pri);
                }
            }
        }
        return nuevaCola;
    }
}

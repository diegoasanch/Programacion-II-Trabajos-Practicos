package Metodos;

import Interfaces.ColaTDA;

import java.util.Scanner;

import ImplementacionesEstaticas.ColaCircular;
import ImplementacionesDinamicas.ColaPrimIni;

public class MetodosColas {

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
        teclado.close();
    }

    // @tarea transfiere los elementos de cola1 a cola2
    public void colaToCola(ColaTDA cola1, ColaTDA cola2) {
        while (! cola1.colaVacia()) {
            cola2.acolar(cola1.primero());
            cola1.desacolar();
        }
    }

    /** @tarea imprimeCola imprime de manera NO destructiva los valores
     * cargados en una cola.
     */
    public void imprimeCola(final ColaTDA cola) {

        ColaCircular colaTemp = new ColaCircular();
        colaTemp.inicializarCola();
        int valor;

        // Guardamos el valor impreso en una cola temporal
        while (!cola.colaVacia()) {
            valor = cola.primero();
            cola.desacolar();

            colaTemp.acolar(valor);
            System.out.println(valor);
        }
        // Devolvemos los valores a la cola original
        colaToCola(colaTemp, cola);
    }

    // @tarea invierteCola sobre si misma sin la ayuda de una pila
    public void invierteCola(ColaTDA cola) {
        
        int temporal;

        ColaTDA colaAux = new ColaCircular();
        ColaTDA colaInv = new ColaCircular();

        colaAux.inicializarCola();
        colaInv.inicializarCola();

        // Invertimos y guardamos en colaInv
        while (! cola.colaVacia() || ! colaAux.colaVacia()) {
            
            temporal = cola.primero();
            cola.desacolar();

            // Acolamos el temporal (utlimo de lista original) a inv y devolvemos los valores a la original
            if (cola.colaVacia()) {
                colaInv.acolar(temporal);
                colaToCola(colaAux, cola);
            }
            else {
                colaAux.acolar(temporal);
            }
        }
        // Pasamos de colaInv a cola original
        colaToCola(colaInv, cola);
    }

    // Copia los elementos de cola1 a cola2
    public void copiaCola(ColaTDA cola1, ColaTDA cola2) {
        // Creamos una cola auxiliar
        ColaTDA colaAux = new ColaCircular();
        colaAux.inicializarCola();

        // Pasamos todos los valores a colaAux
        while (! cola1.colaVacia()) {
            colaAux.acolar(cola1.primero());
            cola1.desacolar();
        }
        
        int valor;
        // Copiamos los valores de colaAux a las ambas colas recibidas
        while (! colaAux.colaVacia()) {
            valor = colaAux.primero();
            colaAux.desacolar();

            cola1.acolar(valor);
            cola2.acolar(valor);
        }
    }


    /** Verifica si los ultimos elementos de cola1 son iguales a los elementos
     * de cola2
     * @Precondicion cola1 debe ser >= cola2
     */
    public boolean terminaIgual(ColaTDA c1, ColaTDA c2) {
        // Copiamos ambas y las invertimos para comparar desde el final
        // hacia adelante sin modificar las colas recibidas

        ColaTDA cola1 = new ColaCircular();
        ColaTDA cola2 = new ColaCircular();

        cola1.inicializarCola();
        cola2.inicializarCola();

        copiaCola(c1, cola1);
        copiaCola(c2, cola2);

        invierteCola(cola1);
        invierteCola(cola2);

        boolean iguales = true;
        
        while (iguales && ! cola2.colaVacia()) {
            iguales = (cola1.primero() == cola2.primero());
            cola1.desacolar();
            cola2.desacolar();
        }

        return iguales;
    }

    // Devuelve la cantidad de elementos que tiene una cola
    public int longitud(ColaTDA cola) {
        ColaTDA colaAux = new ColaCircular();
        colaAux.inicializarCola();

        int cant = 0;

        // Guardamos los valores en colaAux y sumamos una cant
        while (! cola.colaVacia()) {
            colaAux.acolar(cola.primero());
            cola.desacolar();
            cant ++;
        }

        // Devolvemos los valores a cola
        colaToCola(colaAux, cola);

        return cant;
    }

    // Devuelve el promedio de los numeros pares pertenecientes a la cola
    public float promedioPares(ColaTDA cola) {

        ColaCircular colaAux = new ColaCircular();
        colaAux.inicializarCola();

        int suma = 0;
        int pares = 0;
        int num;

        // Registramos los pares y guardamos momentaneamente en colaAux
        while (! cola.colaVacia()) {

            num = cola.primero();
            colaAux.acolar(num);
            cola.desacolar();

            if (num % 2 == 0) {
                suma += num;
                pares ++;
            }
        }

        // Devolvemos los valores a la cola original
        colaToCola(colaAux, cola);

        float promedio;

        if (pares != 0)
            promedio = (float) suma / pares;
        else
            promedio = 0;
        
        return promedio;
    }

    // Retorna arreglo de dos colas con la primera y segunda mitad (en orden) de la cola recibida
    public ColaTDA[] colaMitades(ColaTDA cola) {
        ColaTDA mitad1 = new ColaPrimIni();
        ColaTDA mitad2 = new ColaPrimIni();
        mitad1.inicializarCola();
        mitad2.inicializarCola();

        final int mitad = (longitud(cola) / 2);

        // Pasamos la primera mitad a mitad1
        for (int i =0; i < mitad; i++) {
            mitad1.acolar(cola.primero());
            cola.desacolar();
        }
        // Segunda mitad a mitad2
        while (!cola.colaVacia()) {
            mitad2.acolar(cola.primero());
            cola.desacolar();
        }

        ColaTDA[] contenedor = new ColaTDA[2];
        contenedor[0] = mitad1;
        contenedor[1] = mitad2;
        
        return contenedor;
    }
}
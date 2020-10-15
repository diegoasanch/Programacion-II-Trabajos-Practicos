/** 
 Dada una cola con secuencias de números, separadas por el valor -1, genere otra cola
 con las secuencias de números donde los valores dentro de la misma secuencia estén
 ordenados. Todas las secuencias tienen valores únicos. 

 Ejemplo:
     * Cola origen  1 2 -3 -1 6 22 -1 7 99 4 2 -1 2 -1 -1 
     * Cola destino 6 22 -1 2 -1 -1 
 */

package Programas;

import ImplementacionesDinamicas.ColaPrimIni;
import ImplementacionesDinamicas.Conjunto;
import Interfaces.ColaTDA;
import Interfaces.ConjuntoTDA;
import Metodos.MetodosColas;
import Metodos.MetodosConjuntos;

public class EjercicioParcial3 {
    public static void main(String[] args) {
        MetodosColas colas = new MetodosColas();
        MetodosConjuntos conjuntos = new MetodosConjuntos();

        ColaTDA colaOrigen = new ColaPrimIni();
        colaOrigen.inicializarCola();
        
        colas.cargaColaCust(colaOrigen, -11);

          
        // cola donde guardaremos los indices de las subcolas a agregar a la nueva
        ConjuntoTDA ordenados = new Conjunto();
        ordenados.inicializarConjunto();
        
        int sep = -1;
        int indice = 0;

        ColaTDA subCola = colas.extraeSubCola(colaOrigen, indice, sep);

        while (!subCola.colaVacia()) {
            // Si la subcola esta ordenada
            if (colas.ColaOrdenada(subCola))
                ordenados.agregar(indice);
            
            indice++;
            subCola = colas.extraeSubCola(colaOrigen, indice, sep);
        }
        ColaTDA colaDest = new ColaPrimIni();
        colaDest.inicializarCola();

        // Añadimos a la cola destino las subcolas cuyos indices guardamos en ordenados
        indice = 0;
        int valor;

        while (!colaOrigen.colaVacia()) {
            valor = colaOrigen.primero();
            if (valor == sep)
                indice++;

            else if (ordenados.pertenece(indice))
                colaDest.acolar(valor);
            colaOrigen.desacolar();
        }

        System.out.println("Cola Resultante:");
        colas.imprimeCola(colaDest);
    }
}
/** 
    Dada una cola con secuencias de números, separadas por el valor -1, generar otra cola acolando las
    secuencias cuyos valores no están repetidos en ninguna de las otras secuencias. Todas las secuencias
    tienen valores únicos.

    Ejemplo:
        * Cola origen 1 2 3 -1 6 22 -1 7 9 4 2 -1 2 -1 -1 2 8 9 -1
        * Cola destino 6 22 -1 -1
 */

package Programas;
import ImplementacionesDinamicas.ColaPrimIni;
import Interfaces.ColaTDA;
import Interfaces.ConjuntoTDA;
import Metodos.MetodosColas;
import Metodos.MetodosConjuntos;

public class EjercicioParcial1 {
    public static void main(String[] args) {
        MetodosColas colas = new MetodosColas();
        MetodosConjuntos conjuntos = new MetodosConjuntos();

        ColaTDA colaOrigen = new ColaPrimIni();
        colaOrigen.inicializarCola();
        
        colas.cargaColaCust(colaOrigen, -11);
        
        // cola donde guardaremos los indices de las subcolas a agregar a la nueva
        ColaTDA noReps = new ColaPrimIni();
        noReps.inicializarCola();
        
        int sep = -1;
        int indice = 0;

        ConjuntoTDA subConj = colas.colaToConj(colas.extraeSubCola(colaOrigen, indice, sep));

        while (!subConj.conjuntoVacio()) {
            // Si la subcola de indice "indice" no tiene elementos en comun con el resto de la cola
            if (conjuntos.interseccion(subConj, colas.colaToConj(colas.excluyeSubCola(colaOrigen, indice, sep))).conjuntoVacio())
                noReps.acolar(indice);
            
            indice++;
            subConj = colas.colaToConj(colas.extraeSubCola(colaOrigen, indice, sep));
        }
        ColaTDA colaDest = new ColaPrimIni();
        colaDest.inicializarCola();

        // Añadimos a la cola destino las subcolas cuyos indices guardamos en noReps
        while (!noReps.colaVacia()) {
            colas.colaToCola(colas.extraeSubCola(colaOrigen, noReps.primero(), sep), colaDest);
            noReps.desacolar();
        }

        System.out.println("Cola Resultante:");
        colas.imprimeCola(colaDest);
    }
}

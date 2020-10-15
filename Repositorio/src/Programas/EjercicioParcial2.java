/**
  Dada una cola con secuencias de números, separadas por el valor 0, genere
  otra cola con las secuencias de números donde al menos uno de sus valores
  pertenezca a otra secuencia. Todas las secuencias tienen valores únicos.

  Ejemplo: 
        Cola origen 1 2 3 0 6 22 0 7 9 4 2 0 2 0 
        Cola destino 1 2 3 0 7 9 4 2 0 2 0
 */
package Programas;
import ImplementacionesDinamicas.ColaPrimIni;
import Interfaces.ColaTDA;
import Interfaces.ConjuntoTDA;
import Metodos.MetodosColas;
import Metodos.MetodosConjuntos;

public class EjercicioParcial2 {
    public static void main(String[] args) {
        MetodosColas colas = new MetodosColas();
        MetodosConjuntos conjuntos = new MetodosConjuntos();

        ColaTDA colaOrigen = new ColaPrimIni();
        colaOrigen.inicializarCola();
        
        colas.cargaCola(colaOrigen);

          
        // cola donde guardaremos los indices de las subcolas a agregar a la nueva
        ColaTDA compartidos = new ColaPrimIni();
        compartidos.inicializarCola();
        
        int sep = 0;
        int indice = 0;

        ConjuntoTDA subConj = colas.colaToConj(colas.extraeSubCola(colaOrigen, indice, sep));

        while (!subConj.conjuntoVacio()) {
            // Si la subcola de indice "indice" no tiene elementos en comun con el resto de la cola
            if (!conjuntos.interseccion(subConj, colas.colaToConj(colas.excluyeSubCola(colaOrigen, indice, sep))).conjuntoVacio())
                compartidos.acolar(indice);
            
            indice++;
            subConj = colas.colaToConj(colas.extraeSubCola(colaOrigen, indice, sep));
        }
        ColaTDA colaDest = new ColaPrimIni();
        colaDest.inicializarCola();

        // Añadimos a la cola destino las subcolas cuyos indices guardamos en compartidos
        while (!compartidos.colaVacia()) {
            colas.colaToCola(colas.extraeSubCola(colaOrigen, compartidos.primero(), sep), colaDest);
            compartidos.desacolar();
        }

        System.out.println("Cola Resultante:");
        colas.imprimeCola(colaDest);
    }
}
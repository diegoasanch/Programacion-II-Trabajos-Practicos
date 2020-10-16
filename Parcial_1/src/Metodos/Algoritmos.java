/** @author Diego Sanchez
 * Metodos para la resolucion de los items del ejercicio B - Algoritmos
 */

package Metodos;

import Api.ABBTDA;
import Api.ColaTDA;
import Api.ConjuntoTDA;
import Api.DiccionarioSimpleTDA;
import Implementaciones.Cola;
import Implementaciones.DiccionarioSimple;

public class Algoritmos {

    /** Ej1 Dados dos árboles generar una cola con los elementos
     * que no sean comunes a ambos árboles */
    public ColaTDA colaElemUnicos(ABBTDA arbol1, ABBTDA arbol2) {

        ColaTDA resultado = new Cola();
        resultado.inicializarCola();

        // Filtramos los valores recursivamente de ambos arboles
        filtraValores(arbol1, arbol2, resultado);
        filtraValores(arbol2, arbol1, resultado);

        return resultado;
    }

    private void filtraValores(ABBTDA base, ABBTDA referencia, ColaTDA resultado) {
        if (!base.arbolVacio()) {
            filtraValores(base.hijoIzq(), referencia, resultado);
            if (!referencia.pertenece(base.raiz()))
                resultado.acolar(base.raiz());
            filtraValores(base.hijoDer(), referencia, resultado);
        }
    }

    /** Ej2 Dados dos diccionarios simples, generar un nuevo diccionario con
     * las claves que son comunes a los dos y el que el valor asociado sea el
     * promedio de los valores asociados a esa clave en los diccionarios de origen.
     */
    public DiccionarioSimpleTDA clavesComunes(DiccionarioSimpleTDA dic1, DiccionarioSimpleTDA dic2) {
        DiccionarioSimpleTDA resultado = new DiccionarioSimple();
        resultado.inicializarDiccionarioSimple();

        ConjuntoTDA claves1 = dic1.claves();
        ConjuntoTDA claves2 = dic2.claves();
        int actual;

        while (!claves1.conjuntoVacio()) {
            actual = claves1.elegir();
            claves1.sacar(actual);

            // Si el valor es comun a ambos diccionarios
            if (claves2.pertenece(actual))
                resultado.agregar(actual, promedio(dic1.obtener(actual), dic2.obtener(actual)));
        }

        return resultado;
    }
    private int promedio(int a, int b) {
        return (a + b) / 2;
    }
}

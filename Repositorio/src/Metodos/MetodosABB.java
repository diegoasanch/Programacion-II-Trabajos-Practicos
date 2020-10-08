package Metodos;
import Interfaces.ABBTDA;

public class MetodosABB {

    // Imprime el arbol de manera recursiva
    public void imprimeOrden(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            imprimeOrden(arbol.hijoIzq());
            System.out.println(arbol.raiz());
            imprimeOrden(arbol.hijoDer());
        }
    }

    // Imprime el arbol de manera recursiva
    public void imprimePre(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            System.out.println(arbol.raiz());
            imprimePre(arbol.hijoIzq());
            imprimePre(arbol.hijoDer());
        }
    }

    // Imprime el arbol de manera recursiva
    public void imprimePost(ABBTDA arbol) {
        if (!arbol.arbolVacio()) {
            imprimePost(arbol.hijoIzq());
            imprimePost(arbol.hijoDer());
            System.out.println(arbol.raiz());
        }
    }

    // Devuelve la cantidad de elementos que contiene el arbol
    public int cantElem(ABBTDA arbol) {
        if (arbol.arbolVacio())
            return 0;
        return 1 + cantElem(arbol.hijoIzq()) + cantElem(arbol.hijoDer());
    }

    // Devuelve la suma de todos lo elementos del arbol
    public int sumaArbol(ABBTDA arbol) {
        if (arbol.arbolVacio())
            return 0;
        return arbol.raiz() + sumaArbol(arbol.hijoIzq()) + sumaArbol(arbol.hijoDer());
    }

    // Devuelve el menor valor del arbol
    public int menorValor(ABBTDA arbol) {
        if (arbol.hijoIzq().arbolVacio())
            return arbol.raiz();
        return menorValor(arbol.hijoIzq());
    }

    // Devuelve el mayor valor del arbol
    public int mayorValor(ABBTDA arbol) {
        if (arbol.hijoDer().arbolVacio())
            return arbol.raiz();
        return mayorValor(arbol.hijoDer());
    }

    // Copia un arbol de busqueda binaria manteniendo el balance del original
    public void copiaArbol(ABBTDA desde, ABBTDA hacia) {
        if (!desde.arbolVacio()) {
            hacia.agregar(desde.raiz());
            copiaArbol(desde.hijoIzq(), hacia);
            copiaArbol(desde.hijoDer(), hacia);
        }
    }

    // Vacia todos los elementos del arbol
    public void vaciar(ABBTDA arb) {
        if (!arb.arbolVacio()) {
            vaciar(arb.hijoIzq());
            vaciar(arb.hijoDer());
            arb.eliminar(arb.raiz());
        }
    }

    // Devuelve la canridad de elementos pares contenidos en el arbol
    public int cantPares(ABBTDA arb) {
        if (! arb.arbolVacio()) {
            int par = (arb.raiz() % 2 == 0) ? 1 : 0;
            return par + cantPares(arb.hijoIzq()) + cantPares(arb.hijoDer());
        }
        return 0;
    }

    // Devuelve la canridad de elementos pares contenidos en el arbol
    public int cantImpares(ABBTDA arb) {
        if (! arb.arbolVacio()) {
            int impar = (arb.raiz() % 2 != 0) ? 1 : 0;
            return impar + cantImpares(arb.hijoIzq()) + cantImpares(arb.hijoDer());
        }
        return 0;
    }

    // Devuelve la profundidad de un elemento perteneciente al arbol
    public int profundidad(ABBTDA arbol, int n) {
        if (n == arbol.raiz())
            return 1;
        else if (n < arbol.raiz())
            return 1 + profundidad(arbol.hijoIzq(), n);
        else
            return 1 + profundidad(arbol.hijoDer(), n);
    }

    // Devuelve la profundidad de la rama mas profunda del arbol
    public int altura(ABBTDA arbol) {
        if (! arbol.arbolVacio()) {
            int altIzq = altura(arbol.hijoIzq());
            int altDer = altura(arbol.hijoDer());

            return (altIzq > altDer ? altIzq : altDer) + 1;
        }
        return 0;
    }
}

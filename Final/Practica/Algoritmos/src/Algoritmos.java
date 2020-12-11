public class Algoritmos {

    public int profundidadNodo(ABBTDA arbol, int valor_nodo) {
        if (valor_nodo == arbol.raiz())
            return 1;
        else if (valor_nodo < arbol.raiz())
            return 1 + profundidadNodo(arbol.hijoIzq(), valor_nodo);

        return 1 + profundidadNodo(arbol.hijoDer(), valor_nodo);
    }

    public void imprimeVerticesOrd(GrafoTDA grafo) {
        //
    }
}

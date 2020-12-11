package Ejercicios;
import TDAs.GrafoTDA;
import TDAs.ABBTDA;
import TDAs.ConjuntoTDA;
import Implementaciones.Conjunto;

public class ParteB {

    /** Ejercicio B. 1
     * Dado dos objetos de tipo GrafoTDA, G1, G2, de enteros, generar un conjuntoTDA correspondiente
     * a los vértices de igual etiqueta que tengan igual promedio de pesos de las aristas salientes
     * e igual promedio de pesos de aristas entrantes.
     */
    public ConjuntoTDA verticesIgualPromedio(GrafoTDA G1, GrafoTDA G2) {
        ConjuntoTDA vertices_1 = G1.vertices();
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();

        int vert_actual;
        int prom_sal_1, prom_ent_1, prom_sal_2, prom_ent_2;

        // Recorremos todos los vertices de G1
        while (!vertices_1.conjuntoVacio()) {
            vert_actual = vertices_1.elegir();
            vertices_1.sacar(vert_actual);

            // Si el vertice tambien pertenece a G2 verificamos que tengan igual promedio de peso de
            // aristas entrantes y salientes
            if (G2.vertices().pertenece(vert_actual)) {
                prom_sal_1 = promedioAristasSalientes(G1, vert_actual);
                prom_sal_2 = promedioAristasSalientes(G2, vert_actual);
                prom_ent_1 = promedioAristasEntrantes(G1, vert_actual);
                prom_ent_2 = promedioAristasEntrantes(G2, vert_actual);

                // Si el promedio de aristas salientes es igual y el promedio de aristas entrantes
                // es igual, agregamos el vertice al conjunto resultado
                if (prom_ent_1 == prom_ent_2 && prom_sal_1 == prom_sal_2)
                    resultado.agregar(vert_actual);
            }
        }

        return resultado;
    }

    /** Calcula el valor promedio de los pesos de aristas salientes del vertice "vertice_referencia"
     * dentro del grafo "grafo"
     * @Precondicion el grafo recibido debe estar inicializado
     * @Precondicion el vertice recibido debe pertenecer al grafo recibido
      */
    public int promedioAristasSalientes(GrafoTDA grafo, int vertice_referencia) {
        int total = 0;
        int cant = 0;
        int vert_actual;
        ConjuntoTDA verts = grafo.vertices();

        // Recorremos los vertices
        while (!verts.conjuntoVacio()) {
            vert_actual = verts.elegir();
            verts.sacar(vert_actual);

            // Si existe una arista saliente desde vertice_referencia hacia vert_actual, acumulamos su peso
            if (grafo.ExisteArista(vertice_referencia, vert_actual)) {
                total += grafo.PesoArista(vertice_referencia, vert_actual);
                cant++;
            }
        }
        return (cant != 0) ? total / cant : 0;
    }

    /** Calcula el valor promedio de los pesos de aristas entrantes al vertice "vertice_referencia"
     * dentro del grafo "grafo"
     * @Precondicion el grafo recibido debe estar inicializado
     * @Precondicion el vertice recibido debe pertenecer al grafo recibido
      */
    public int promedioAristasEntrantes(GrafoTDA grafo, int vertice_referencia) {
        int total = 0;
        int cant = 0;
        int vert_actual;
        ConjuntoTDA verts = grafo.vertices();

        // Recorremos los vertices
        while (!verts.conjuntoVacio()) {
            vert_actual = verts.elegir();
            verts.sacar(vert_actual);

            // Si existe una arista entrante desde vertice_actual hacia vertice_ref, acumulamos su peso
            if (grafo.ExisteArista(vert_actual, vertice_referencia)) {
                total += grafo.PesoArista(vert_actual, vertice_referencia);
                cant++;
            }
        }
        return (cant != 0) ? total / cant : 0;
    }


    /** Ejercicio B. 2
     * Dado un ABBTDA A y un grafoTDA G, generar un conjunto que contenga todos los nodos
     * del árbol cuyo valor sea igual a la suma de pesos de las aristas salientes y
     * entrantes de alguno de los vértices del grafo.
     */
    public ConjuntoTDA nodosIgualSumaAristas(ABBTDA A, GrafoTDA G) {
        ConjuntoTDA resultado = new Conjunto();
        resultado.inicializarConjunto();

        // Primero recorremos el Grafo para calcular y guardar la suma de los pesos de sus aristas
        ConjuntoTDA suma_pesos = sumaAristas(G);

        // Luego recorremos el ABB en pre-orden y si el valor de un nodo pertenece a suma_pesos y
        // no pertenece al conjunto resultado, lo agregamos
        recorreYAgrega(A, suma_pesos, resultado);

        return resultado;
    }

    // Retorna la suma de los pesos de las aristas entrantes y salientes de todos los vertices
    private ConjuntoTDA sumaAristas(GrafoTDA G) {

        ConjuntoTDA sumas = new Conjunto();
        ConjuntoTDA recorrido = G.vertices();
        ConjuntoTDA sub_recorrido;
        int vert, referencia, suma_actual;

        // Sumamos los pesos entrantes y salientes de todos los vertices, con todos los demas vertices
        while (!recorrido.conjuntoVacio()) {
            vert = recorrido.elegir();
            recorrido.sacar(vert);

            sub_recorrido = G.vertices();
            suma_actual = 0;

            while (!sub_recorrido.conjuntoVacio()) {
                referencia = sub_recorrido.elegir();
                sub_recorrido.sacar(referencia);

                // Si hay aristas entrantes o salientes, sumamos su peso en suma_actual
                if (G.ExisteArista(vert, referencia))
                    suma_actual += G.PesoArista(vert, referencia);
                if (G.ExisteArista(referencia, vert))
                    suma_actual += G.PesoArista(referencia, vert);
            }

            // Si no era un nodo aislado y no teniamos ese valor en sumas, lo agregamos
            if (suma_actual != 0 && !sumas.pertenece(suma_actual))
                sumas.agregar(suma_actual);
        }

        return sumas;
    }

    private void recorreYAgrega(ABBTDA arbol, ConjuntoTDA sumas, ConjuntoTDA resultado) {
        if (!arbol.arbolVacio()) {
            recorreYAgrega(arbol.hijoIzq(), sumas, resultado);

            if (sumas.pertenece(arbol.raiz()))
                resultado.agregar(arbol.raiz());

            recorreYAgrega(arbol.hijoDer(), sumas, resultado);
        }
    }
}

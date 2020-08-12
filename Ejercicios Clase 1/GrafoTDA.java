/** @author Diego Sanchez
 * @Grafo es una coleccion de vertices y aristas tipo dirigido, sun aristas
 * paralelas ni bucles, donde los vertices y los pesos son enteros.
 */

public interface GrafoTDA {
    /* @tarea inicializarGrafo ininicaliza el grafo */
    void inicializarGrafo();

    /** @tarea agregarVertice agrega un vertice
     * @Precondicion el grafo debe estar inicializado y el vertice no debe existir
     */
    void agregarVertice(int vertice);

    /** @tarea eliminarVertice elimina un vertice suministrado
     * @Precondiciones El vertice debe existir
     */
    void eliminarVertice(int vertice);

    /** @tarea agregarArista agrega una arista suministrando vertices de origen y
     * destino y el peso de la misma.
     * @Precondicion los vertices deben existir pero no la arista
     */
    void agregarArista(int v_orig, int v_dest, int peso);

    /** @tarea eliminarArista elimina la arista donde se suministro los vertices de
     * origen y destino
     * @Precondicion la arista debe existir
     */
    void eliminarArista(int v_orig, int v_dest);
    
    /** @tarea vertices devuelve el conjunto de vertices del grafo.
     * @Precondicion el grafo debe estar inicializado
     */
    int vertices();

    /** @tarea peso debuelve el peso de la arista identificada por los vertices de
     * origen y destino
     * @Precondicion la arista debe existir
     */
    int peso(int v_orig, int v_dest);

    /** @tarea existeArista devuelve verdadero si existe la arista identificada por
     * los vertices de origen y destino
     * @Precondicion el grafo debe estar inicializado
    */
    boolean existeArista(int v_orig, int v_dest);
}

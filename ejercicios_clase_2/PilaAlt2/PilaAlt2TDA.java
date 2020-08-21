/**@author Diego Sanchez
* @Pila es una estructura que permite almacenar una colección de valores, eliminarlos y recuperarlos, con
* a particularidad de que el elemento que se recupera o elimina es el último que ingresó.
*/
public interface PilaAlt2TDA {
    // @Tarea InicializarPila inicializa la estructura de la pila
    void inicializarPila();

    // @Tarea apilar agrega un elemento. Precondición la pila debe estar inicializada
    void apilar(int x);

    /** @Tarea TopeSacar devuelve el último elemento agregado a la pila y lo elimina el último elemento.
     * Precondición la pila debe estar inicializada y no vacía.
     */
    int topeSacar();

    /** @Tarea pilaVacia indica si la pila contiene elementos o no.
     * Precondición la pila debe estar inicializada.
     */
    boolean pilaVacia();
}
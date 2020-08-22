package Interfaces;

/** @author Diego Sanchez
 * @Pila es una estructura que permite almacenar una coleccion de valores enteros,
 * con la particularidad de que el ultimo elemento ene entrar es el primero en salir.
 * Tambien se la conoce como una estructura LIFO (Last In First Out)
 */

public interface PilaTDA {
    /* @tarea inicializarPila inicializa la estructura pila */
    void inicializarPila();

    /** @tarea apilar agrega un elemento.
     * @Precondicion la estructura debe estar inicializada
     */
    void apilar(int x);

    /** @tarea topeSacar obtiene el primer elemento a eliminar y lo elimina
     * @Precondicion la estructura no debe estar vacia
    */
    int topeSacar();

    /** @tarea pilaVacia indica si la pila contiene elementos o no
     * @Precondicion la estructura debe estar inicializada
     */
    boolean pilaVacia();
}

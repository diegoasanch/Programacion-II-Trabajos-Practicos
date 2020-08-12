/** @author Diego Sanchez
 * @Pila e suna estructura que permite almacenar una coleccion de valores enteros,
 * con la particularidad de que el ultimo elemento ene entrar es el primero en salir.
 * Tambien se la conoce como una estructura LIFO (Last In First Out)
 */

public interface PilaTDA {
    /* @tarea inicializarPila inicializa la estructura pila */
    void inicializarPila();

    /** @tarea apilar agrega un elemento.
     * @Precondicion la estructura debe estar inicializada
     */
    void apilat(int x);

    /** @tarea desapilar elimina el ultimo elemento agregado
     * @Precondicion la etructura no debe estar vacia
    */
    void desapilar();

    /** @tarea tope obtiene el primer elemento a eliminar
     * @Precondicion la estructura no debe estar vacia
    */
    int tope();

    /** @tarea pilaVacia indica si la pila contiene elementos o no
     * @Precondicion la estructura debe estar inicializada
     */
    boolean pilaVacia();
}

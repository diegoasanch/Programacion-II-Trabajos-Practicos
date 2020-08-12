/** @author Diego Sanchez
 * @ColaConPrioridad es una estructura que permite almacenar una coleccion de
 * valores enteros, con la particularidad de que el primer elemento en ingresar
 * es el primer elemento en salir
 */

public interface ColaConPrioridadTDA {
    /* @tarea inicializarCola inicializa la estructura cola */
    void inicializaCola();

    /** @tarea acolarPrioridad agrega un elemento x con prioridad p suministrados
     * @Precondicion la estructura debe estar inicializada
     */
    void acolarPrioridad(int p);

    /** @tarea descolar elimina el elemento con mayor prioridad.
     * @Precondicion la estructura no debe estar vacia.
     */
    void descolar();

    /** @tarea primero obtiene el valor del dato de mayor prioridad
     * @Precondicion la estructura no debe estar vacia
     */
    int primero();

    /** @tarea prioridad obtiene la prioridad del valor del dato de mayor prioridad
     * @Precondicion la estructura no debe estar vacia
     */
    int prioridad();

    /** @tarea colaVacia indica so la cola contiene elementos o no
     * @Precondicion la estructura debe estar inicializada
     */
    boolean colaVacia();
}

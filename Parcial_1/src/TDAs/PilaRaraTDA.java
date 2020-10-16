/** @author Diego Sanchez
 * Primer parcial
 * Ejercicio A - Especificación TDA
 *
    Este tipo de dato almacena números enteros. El orden para obtener/sacar los datos es: primero los valores
    impares y luego los valores pares, todos en forma inversa al orden en que fueron llegando. Este tipo de dato
    posee las siguientes operaciones:

     - Agregar: agrega el valor. Para poder agregar un valor la pila debe estar inicializada.
     - Sacar: se elimina el elemento más reciente impar. En caso de que no haya más impares se eliminará el
        elemento par más reciente. La pila no debe está vacía.
     -Obtener: se obtiene el valor impar más reciente; en caso de que no haya más, se obtiene el valor par más
        reciente. Esta operación no modifica la pila. La pila no debe está vacía.
     - PilaVacia: devuelve verdadero si la pila no tiene elementos. La pila debe estar inicializada.
     - InicializarPila permite inicializar la pila
 */

package TDAs;

public interface PilaRaraTDA {

    /** @tarea agregar  agrega el valor.
     * @Precondicion Para poder agregar un valor la pila debe estar inicializada.
     */
    public void agregar(int num);

    /**@tarea sacar se elimina el elemento más reciente impar. En caso de que no haya más impares se eliminará el
     * elemento par más reciente.
     * @Precondicion La pila no debe está vacía.
     */
    public void sacar();

    /** @tarea obtener se obtiene el valor impar más reciente; en caso de que no haya más, se obtiene el valor par más
     * reciente. Esta operación no modifica la pila.
     * @Precondicion La pila no debe está vacía.
     */
    public int obtener();

    /** @tarea pilaVacia devuelve verdadero si la pila no tiene elementos.
     * @Precondicion La pila debe estar inicializada.
     */
    public boolean pilaVacia();

    /** @tarea inicializarPila permite inicializar la pila
     */
    public void inicializarPila();
}

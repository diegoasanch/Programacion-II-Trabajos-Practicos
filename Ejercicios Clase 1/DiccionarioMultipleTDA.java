/** @author Diego Sanchez
 * @DiccionarioMultiple es una coleccion de pares asociados (clave, valor), las
 * claves son unicas. No puede existir clave sin valor asociado. Los valores son
 * unicos para la misma clave
 */

public interface DiccionarioMultipleTDA {
    /* @tarea inicializarDiccionarioMultiple inicializa el diccionario */
    void inicializarDiccionarioMultiple();

    /** @tarea agregar agrega un elemento x a una clave, ambos datos son suministrados.
     * @Precondicion el diccionario debe estar inicializado y el valor no debe existir.
     */
    void agregar(int x, int clave);

    /** @tarea eliminar elimina una clave suministrada
     * @Precondicion la clave debe existir
     */
    void eliminar(int clave);

    /** @tarea eliminarValor elimina un valor dado x asociado a una clave, ambos
     * datos son suministrados.
     * @Precondicion tanto la clave como el valor deben existir
     */
    void eliminarValor(int x, int clave);

    /** @tarea obtener devuelve el conjunto de valores asociada a una clave suministrada
     * @Precondicion la clave debe existir
     */
    int obtener(int clave);

    /** @Tarea claves devuelve el conjunto de claves del diccionario.
     * @Precondicion el diccionario debe estar inicializado
     */
    int claves();
}

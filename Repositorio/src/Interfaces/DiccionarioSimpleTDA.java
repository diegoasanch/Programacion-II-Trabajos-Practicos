package Interfaces;


/** @author Diego Sanchez
 * @Diccionario es una coleccion de pares asociados (clave, valor), las
 * claves son unicas. No puede existir clave sin valor asociado
 */

public interface DiccionarioSimpleTDA {
    /* @tarea inicializarDiccionarioSimple inicializa el diccionario. */
    void inicializarDiccionarioSimple();

    /** @tarea agregar agrega un elemento x a una clave suministrados
     * @Precondicion el diccionario debe estar incializado y la clave no debe existir
     */
    void agregar(int clave, int valor);

    /** @tarea eliminar elimina una clave suministrada.
     * @Precondicion la clave debe existir
     */
    void eliminar(int a_sacar);

    /** @obtener devuelve el valor asociado a una clave suministrada
     * @Precondicion la clave debe existir
     */
    int obtener(int a_buscar);

    /** @tarea claves devueve el conjunto de claves del diccionario.
     * @Precondicion el diccionario debe estar inicializado
     */
    ConjuntoTDA claves();
}

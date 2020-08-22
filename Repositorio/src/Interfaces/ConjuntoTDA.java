package Interfaces;

/** @author diegoasanch
 * @Conjunto es una estructura que permite almacenar una coleccion de valores
 * enteros no repetidos y no necesariamente ordenado
 */

public interface ConjuntoTDA {
    /** @tarea InicializarConjunto Inicializa el conjunto
     */
    void inicializarConjunto();

    /** @tarea Agregar agrega un elemento x suministrado.
     * @Precondicion el conjunto debe estar inicializado y el elemento no debe existir
     */
    void agregar(int x);

    /** @tarea Sacar elimina un elemento suministrado x.
     * @Precondicion EL elemento debe pertenecer al conjunto.
     */
    void sacar(int x);

    /** @tarea Obtener devuelve un valor cualquiera del conjunto.
     * @Precondicion el conjunto no debe estar vacio
     */
    int obtener();

    /** @tarea ConjuntoVacio devuelve verdadero si el conjunto tiene elementos
     * @Precondicion El conjunto debe estar inicializado
     */
    boolean conjuntoVacio();

    /** @tarea Pertenece devuelve verdadero si el valor x recibido como parametro pertenece al conjunto
     * @Precondicion el conjunto debe estar incializado
     */
    boolean pertenece();
    
}


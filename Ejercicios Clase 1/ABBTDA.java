/** @author Diego Sanchez
 * @ABB arbol de busqueda binaria es una coleccion de elementos ordenados en
 * forma jerarquica. Entre dos elementos se define dos roles: padre e hijo.
 * Cada elemento tiene solo un padre, excepto el elemento raiz del arbol que
 * no tienen ningun padre
 */

public interface ABBTDA {
    /* @tarea inicializarABB inicializa el arbol */
    void inicializarABB();

    /** @tarea Raiz devuelve el valor de la raiz.
     * @Precondicion el arbol no puede estar vacio
     */
    int raiz();

    /** @tarea hijoIzq devuelve la referencia al subarbol izquierdo
     * @Precondicion el arbol no puede estar vacio
     */
    int hijoIzq();

    /** @tarea hijoDer devuelve la referencia al subarbol derecho
     * @Precondicion el arbol no puede estar vacio
     */
    int hijoDer();

    /** @tarea agregar agrega un valor x suministrado.
     * @Precondicion el arbol debe estar inicializado y no debe existir el valor
     */
    void agregar(int x);

    /** @tarea eliminar elimina un valor suministrado
     * @Precondicion el valor debe existir
    */
    void eliminar(int valor);

    /** @tarea arbolVacio indica si el arbol contiene elementos o no
     * @Precondicion la estructura debe estar inicializada
     */
    boolean arbolVacio();

    /** @tarea pertenece devuelve verdadero si el valor pertenece al arbol
     * @Precondicion el arbol debe estar incializado
     */
    boolean pertenece(int valor);    
}

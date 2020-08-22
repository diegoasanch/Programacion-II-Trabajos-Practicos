package Interfaces;

public interface ColaPrioridadTDA {
    /** @tarea InicializarCola incializa la estructura cola */
    void inicializarCola();
    
    /** @Tarea Acolar agrega un elemento a la cola
     * @Precondicion La estructura debe estar inicializda
     */
    void acolar(int valor, int prioridad);
    
    /** @Tarea Desacolar elimina el elemento mas antiguo agregado
     * @Precondicion La estructura no debe estar vacia
     */
    void desacolar();
    
    /** @Tarea Primero obtiene el primer elemento a eliminar
     * @Precondicion La estructura no debe estar vacia
     */
    int primero();
    
    /** @tarea ColaVacia indica si la cola contiene elementos o no
     * @Precondicion La estructura deve estar inicializada
     */
    boolean colaVacia();
}

package Ejercicios;
import TDAs.ColaTDA;
import TDAs.PilaTDA;
import Implementaciones.Pila;

/** Ejercicio A. 1 - Implementacion
 *  Ejercicio A. 2 - costos estan definido en la documentacion de cada metodo
 *  Ejercicio A. 3 - se descarto
 */
public class ParteA_Cola implements ColaTDA {

    // En pilaBase guardaremos los valores de la cola en el orden que deben salir, pilaAux
    // la utilizamos para maniobrar y mantener el orden de la pilaBase
    private PilaTDA pilaBase, pilaAux;

    /** Costo de tiempo Lineal, es directamente proporcional a la cantidad de elementos en la cola
     */
    @Override
    public void acolar(int x) {
        // Pasamos todo el contenido de la pilaBase a pilaAux
        transfierePila(pilaBase, pilaAux);

        // Apilamos el nuevo valor en la pilaBase
        pilaBase.apilar(x);

        // Traemos de nuevo el contenido de pilaAux a pilaBase
        transfierePila(pilaAux, pilaBase);
    }

    /** Costo de tiempo constante, independiente de la cantidad de datos
     */
    @Override
    public void desacolar() {
        // Sacamos el primer elemento de pilaBase
        pilaBase.desapilar();
    }

    /** Costo de tiempo constante, independiente de la cantidad de datos
     */
    @Override
    public int primero() {
        // Es el primer elemento de pilaBase
        return pilaBase.tope();
    }

    /** Costo de tiempo constante, independiente de la cantidad de datos
     */
    @Override
    public boolean colaVacia() {
        // Si la pilaBase esta vacia, la cola esta vacia
        return pilaBase.pilaVacia();
    }

    /** Costo de tiempo constante, independiente de la cantidad de datos
     */
    @Override
    public void inicializarCola() {
        pilaBase = new Pila();
        pilaAux = new Pila();
        pilaBase.inicializarPila();
        pilaAux.inicializarPila();

    }

    /** Metodo utilizado para mover todo el contenido de pila "origen" hasta la pila "destino"
     * @Precondicion Ambas pilas deben estar inicializadas
     *
     * Costo de tiempo Lineal, es directamente proporcional a la cantidad de elementos en la pila origen
     */
    private void transfierePila(PilaTDA origen, PilaTDA destino) {
        while (!origen.pilaVacia()) {
            destino.apilar(origen.tope());
            origen.desapilar();
        }
    }
}

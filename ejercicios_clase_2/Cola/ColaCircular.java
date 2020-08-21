/** @author Diego Sanchez
 * Completar la implementación estática de una Cola con almacenamiento
 * circular y probarla.
 */

public class ColaCircular implements ColaTDA {

    private int cant;
    private int primero;
    private int [] v;
    private int tamanio;

    public void inicializarCola() {
        tamanio = 100;
        v = new int[tamanio];
        primero = 0;
        cant = 0;
    }

    public void acolar(int x) {
        int disponible = primero + cant;

        // Si el proximo lugar a guardar pasa el tamaño de la cola comenzamos desde el principio
        if (disponible >= tamanio) {
            disponible -= tamanio;
        }
        v[disponible] = x;

        // Si se lleno la cola corremos la primera posicion un lugar
        if (cant == tamanio) {
            primero ++;
        }
        else {
            cant ++;
        }
    }

    public void desacolar() {
        if (primero < (tamanio - 1)) {
            primero ++;
        }
        else {
            primero = 0;
        }
        cant --;
    }

    public int primero() {
        return v[primero];
    }

    public boolean colaVacia() {
        return cant == 0;
    }
}
/** @author Diego Sanchez
 * Ejercicio A - Implementación TDA Dinamica del PilaRaraTDA
 */

package Implementaciones;

import TDAs.PilaRaraTDA;

public class PilaRara implements PilaRaraTDA {

    class Nodo {
        int valor;
        Nodo sig;
    }

    // Guardamos dos "sub-pilas" para que el costo de tiempo sea constante, de orden 1
    private Nodo primerImpar;
    private Nodo primerPar;

    @Override
    public void agregar(int num) {
        Nodo nuevo = new Nodo();
        nuevo.valor = num;

        // Lo apilamos en la secuencia correspondiente
        if (esPar(num)) {
            nuevo.sig = primerPar;
            primerPar = nuevo;
        }
        else {
            nuevo.sig = primerImpar;
            primerImpar = nuevo;
        }
    }

    @Override
    public void sacar() {
        // Se busca en la "sub-pila" correspondiente
        if (primerImpar != null)
            primerImpar = primerImpar.sig;
        else
            primerPar = primerPar.sig;
    }

    @Override
    public int obtener() {
        // Si quedan valores impares lo sacamos de ahi, si no, par
        if (primerImpar != null)
            return primerImpar.valor;
        return primerPar.valor;
    }

    @Override
    public boolean pilaVacia() {
        return (primerImpar == null) && (primerPar == null);
    }

    @Override
    public void inicializarPila() {
        primerImpar = null;
        primerPar = null;
    }

    private boolean esPar(int num) {
        return (num % 2) == 0;
    }
}

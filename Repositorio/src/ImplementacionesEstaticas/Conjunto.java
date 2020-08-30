/** @author Diego Sanchez
 * Implementacion estatica de un conjunto de numeros enteros
 */

package ImplementacionesEstaticas;

import Interfaces.ConjuntoTDA;
import java.util.Random;


public class Conjunto implements ConjuntoTDA {
    private int [] vector;
    private int cant;
    private Random random;

    public void inicializarConjunto() {
        vector = new int [100];
        cant = 0;
        random = new Random(System.currentTimeMillis());
    }

    public void agregar(int x) {
        vector[cant] = x;
        cant ++;
    }

    public void sacar(int x) {
        int i = cant - 1;
        
        // Buscamos la pos del elemento a sacar
        while (vector[i] != x)
            i --;
        // Movemos el ultimo elemento a esa pos
        vector[i] = vector[cant - 1];
        cant --;
    }

    public int obtener() {
        int pos = random.nextInt(cant);
        return vector[pos];
    }

    public boolean conjuntoVacio() {
        return cant == 0;
    }

    public boolean pertenece(int x) {
        boolean existe = false;
        int i = cant - 1;

        while (! existe && i >= 0) {
            existe = vector[i] == x;
            i --;
        }
        return existe;
    }
}
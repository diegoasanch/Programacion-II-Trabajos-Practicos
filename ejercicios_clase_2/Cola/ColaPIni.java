/** @author Diego Sanchez
 * @implementacion de cola Primero al inicio
*/

public class ColaPIni implements ColaTDA {
    private int cant, tamanio;
    private int[] v;

    public void inicializarCola() {
        tamanio = 100;
        v = new int[tamanio];
        cant = 0;    
    }

    public void acolar(int x) {
        v[cant] = x;
        cant++;
    }

    public void desacolar() {
        for (int i = 0; i < cant; i++) {
            v[i] = v[i + 1];
        }
        cant--;
    }

    public int primero() {
        return v[0];
    }

    public boolean colaVacia() {
        return cant == 0;
    }
}
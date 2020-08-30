package ImplementacionesEstaticas;
import Interfaces.ColaTDA;

public class ColaPrimIni implements ColaTDA {
    private int [] vector;
    private int cant;

    public void inicializarCola() {
        vector = new int[100];
        cant = 0;
    }
    public void acolar(int x) {
        vector[cant] = x;
        cant ++;
    }
    public void desacolar() {
        for (int i = 0; i < (cant - 1); i++) {
            vector[i] = vector[i + 1];
        }
        cant --;
    }
    public int primero() {
        return vector[0];
    }
    public boolean colaVacia() {
        return cant == 0;
    }
}
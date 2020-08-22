package Implementaciones;

import Interfaces.PilaTDA;

/**@author Diego Sanchez
* @Implementación tope al inicio */

public class PilaTopeIni implements PilaTDA {
    private int [] contenedor;
    private int cant;

    public void inicializarPila() {
        contenedor = new int[100];
        cant = 0;
    }

    public void apilar(int x) {
        if (cant != 0) {
            int i = cant;

            while (i > 0) {
                contenedor[i] = contenedor[i - 1];
                i--;
            }
        }
        contenedor[0] = x;
        cant++;
    }

    public int topeSacar() {
        int tope;
        if (cant != 0) {
            tope = contenedor[0];
            int i = 0;
            while (i < cant) {
                contenedor[i] = contenedor[i + 1];
                i++;
            }
            cant--;
        }
        else {
            tope = 0;
        }
        return tope;
    }

    public boolean pilaVacia () {
        return cant == 0;
    }
}
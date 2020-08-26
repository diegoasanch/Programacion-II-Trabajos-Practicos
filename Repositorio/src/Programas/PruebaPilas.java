package Programas;

import Metodos.MetodosPilas;
import Implementaciones.PilaTopeIni;

class PruebaPilas {
    public static void main(String[] args) {
        
        MetodosPilas metodos = new MetodosPilas();

        PilaTopeIni pila1 = new PilaTopeIni();
        pila1.inicializarPila();

        PilaTopeIni pila2 = new PilaTopeIni();
        pila2.inicializarPila();

        for (int i = 0; i < 10; i ++) {
            
            pila2.apilar(i);

            if (i < 9)
               pila1.apilar(i);
        }

        if (metodos.sonIguales(pila1, pila2))
            System.out.println("Las pilas son iguales");
        else
            System.out.println("Las pilas son distintas");

        
    }
}
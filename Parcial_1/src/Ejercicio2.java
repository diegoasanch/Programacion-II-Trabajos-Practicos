import java.util.Scanner;

import Api.ABBTDA;
import Api.ColaTDA;
import Implementaciones.ABB;
import Metodos.Algoritmos;

public class Ejercicio2 {
    public static void main(String[] args) {
        ABBTDA arbol1 = new ABB();
        ABBTDA arbol2 = new ABB();
        arbol1.inicializarABB();
        arbol2.inicializarABB();

        cargaColaCust(arbol1, -1);
        cargaColaCust(arbol2, -1);

        Algoritmos funcs = new Algoritmos();

        ColaTDA resultado = funcs.colaElemUnicos(arbol1, arbol2);

        while (!resultado.colaVacia()) {
            System.out.println(resultado.primero());
            resultado.desacolar();
        }
    }


    public static void cargaColaCust(ABBTDA arbol, int terminador) {
        Scanner teclado = new Scanner(System.in);
        int numero;

        System.out.print("Ingrese un numero: ");
        numero = teclado.nextInt();

        while (numero != terminador) {
            arbol.agregar(numero);
            System.out.print("Ingrese un numero: ");
            numero = teclado.nextInt();
        }
    }
}

import java.util.Scanner;

import Api.ConjuntoTDA;
import Api.DiccionarioSimpleTDA;
import Implementaciones.DiccionarioSimple;
import Metodos.Algoritmos;

public class Ejercicio3 {
    public static void main(String[] args) {
        DiccionarioSimpleTDA dic1 = new DiccionarioSimple();
        dic1.inicializarDiccionarioSimple();
        
        DiccionarioSimpleTDA dic2 = new DiccionarioSimple();
        dic2.inicializarDiccionarioSimple();

        cargaDiccionario(dic1);
        cargaDiccionario(dic2);

        Algoritmos funcs = new Algoritmos();


        DiccionarioSimpleTDA dic3 = funcs.clavesComunes(dic1, dic2);
        System.out.println("Resultado");
        imprimeDiccionario(dic3);


    }



    public static void cargaDiccionario(DiccionarioSimpleTDA a_cargar) {
        Scanner teclado = new Scanner(System.in);

        int clave;
        int valor;

        System.out.print("Ingrese una clave: ");
        clave = teclado.nextInt();

        while (clave != -1) {
            // Si la clave no existe en el diccionario lo agregamos
            if ( ! a_cargar.claves().pertenece(clave)) {
                System.out.print("Valor de la clave " + clave + ": ");
                valor = teclado.nextInt();
                a_cargar.agregar(clave, valor);
            }
            else {
                System.out.println("La clave " + clave + " ya tiene un valor asociado! Ingresa otra clave.");
            }

            System.out.print("Ingrese una clave: ");
            clave = teclado.nextInt();
        }
    }

    public static void imprimeDiccionario(DiccionarioSimpleTDA a_imprimir) {
        ConjuntoTDA claves = a_imprimir.claves();
        int clave;

        while ( ! claves.conjuntoVacio()) {
            clave = claves.elegir();
            claves.sacar(clave);

            System.out.println("Clave: " + clave + " ----- Valor: " + a_imprimir.obtener(clave));
        }
    }
    
}

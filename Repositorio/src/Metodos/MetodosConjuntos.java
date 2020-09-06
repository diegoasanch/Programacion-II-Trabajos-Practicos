package Metodos;

import java.util.Scanner;

import ImplementacionesEstaticas.Conjunto;
import Interfaces.ConjuntoTDA;


public class MetodosConjuntos {

    // Carga un conjunto de numeros enteros
    public void cargar(ConjuntoTDA conjunto) {

        Scanner teclado = new Scanner(System.in);
        int num;

        System.out.print("Ingrese un numero: ");
        num = teclado.nextInt();
        
        while (num != -1) {
            if (! conjunto.pertenece(num))
                conjunto.agregar(num);
            else
                System.out.println("El numero " + num + " ya pertenece al conjunto!.");

            System.out.print("Ingrese un numero: ");
            num = teclado.nextInt();
        }
        // teclado.close();
    }
    
    // Imprime de manera no destructiva un conjunto de numeros enteros
    public void imprimir(ConjuntoTDA conjunto) {
        ConjuntoTDA conjAux = new Conjunto();
        conjAux.inicializarConjunto();

        while (! conjunto.conjuntoVacio()) {
            int num = conjunto.obtener();
            conjunto.sacar(num);
            conjAux.agregar(num);

            System.out.print(num + " - ");
        }
        System.out.println(' ');
        conjToConj(conjAux, conjunto);
    }

    // Transfiere los elementos de conj1 a conj2
    public void conjToConj(ConjuntoTDA conj1, ConjuntoTDA conj2) {
        
        while (! conj1.conjuntoVacio()) {
            int num = conj1.obtener();
            conj1.sacar(num);
            conj2.agregar(num);
        }
    }

    // Devuelve una copia del conjunto recibido sin modificar el original
    public ConjuntoTDA copiaConjunto(ConjuntoTDA conj) {
        ConjuntoTDA conjAux = new Conjunto();
        conjAux.inicializarConjunto();
        
        ConjuntoTDA conj2 = new Conjunto();
        conj2.inicializarConjunto();

        conjToConj(conj, conjAux);

        while (!conjAux.conjuntoVacio()) {
            int num = conjAux.obtener();
            conjAux.sacar(num);

            conj.agregar(num);
            conj2.agregar(num);
        }
        return conj2;
    }

    // Verifica si los elementos de dos conjuntos son iguales
    public boolean sonIguales(ConjuntoTDA conj1, ConjuntoTDA conj2) {
        // Creamos copias de los conjuntos para no destruirlos
        ConjuntoTDA conj1C = copiaConjunto(conj1);
        ConjuntoTDA conj2C = copiaConjunto(conj2);

        boolean iguales = true;

        // iguales y ninguno de los conj sea vacio
        while (iguales && !(conj1C.conjuntoVacio() || conj2C.conjuntoVacio())) {
            int valor = conj1C.obtener();
            conj1C.sacar(valor);

            if (conj2C.pertenece(valor))
                conj2C.sacar(valor);
            else
                iguales = false;
        }
        // Ambos conjuntos deben quedar vacios si son iguales
        if (iguales)
            iguales = conj1C.conjuntoVacio() && conj2C.conjuntoVacio();
        return iguales;
    }

    // Retorna un conjunto resultante de la union de los dos conjuntos recibidos
    public ConjuntoTDA union(ConjuntoTDA conj1, ConjuntoTDA conj2) {
        
        // Empezamos con una copia de conj1 y a este le agregamos los de conj2 que no pertenecen a este
        ConjuntoTDA conjUnion = copiaConjunto(conj1);
        ConjuntoTDA conj2Copia = copiaConjunto(conj2);

        while (!conj2Copia.conjuntoVacio()) {
            int valor = conj2Copia.obtener();
            conj2Copia.sacar(valor);

            if (!conjUnion.pertenece(valor))
                conjUnion.agregar(valor);
        }
        return conjUnion;
    }

    // Retorna un conjunto resultante de la interseccion de los dos conjuntos recibidos
    public ConjuntoTDA interseccion(ConjuntoTDA conj1, ConjuntoTDA conj2) {
    
        // Empezamos con una copia de conj1 y conj2 para no modificarlos
        ConjuntoTDA conjInter = new Conjunto();
        conjInter.inicializarConjunto();

        ConjuntoTDA conj1Copia = copiaConjunto(conj1);
        ConjuntoTDA conj2Copia = copiaConjunto(conj2);

        while (!conj1Copia.conjuntoVacio()) {
            int valor = conj1Copia.obtener();
            conj1Copia.sacar(valor);

            if (conj2Copia.pertenece(valor)) {
                conj2Copia.sacar(valor);
                conjInter.agregar(valor);
            }
        }
        return conjInter;
    }

    // Retorna un conjunto con la diferencia de conj1 con conj2
    public ConjuntoTDA diferencia(ConjuntoTDA conj1, ConjuntoTDA conj2) {
        ConjuntoTDA conjDif = new Conjunto();
        conjDif.inicializarConjunto();

        ConjuntoTDA conj1Copia = copiaConjunto(conj1);

        while (!conj1Copia.conjuntoVacio()) {
            int valor = conj1Copia.obtener();
            conj1Copia.sacar(valor);

            if (!conj2.pertenece(valor))
                conjDif.agregar(valor);
        }
        return conjDif;
    }

    // retorna conjunto con la diferencia simetrica entre conj1 y conj2
    public ConjuntoTDA diferenciaSimetrica(ConjuntoTDA conjunto1, ConjuntoTDA conjunto2) {
        return union(diferencia(conjunto1, conjunto2), diferencia(conjunto2, conjunto1));
    }

    // Indica si el conj1 esta completamente incluido en conj2
    public boolean incluido(ConjuntoTDA conj1, ConjuntoTDA conj2) {

        ConjuntoTDA conj1Copia = copiaConjunto(conj1);
        boolean estaIncluido = true;

        while (estaIncluido && !conj1Copia.conjuntoVacio()) {
            int valor = conj1Copia.obtener();
            conj1Copia.sacar(valor);

            estaIncluido = conj2.pertenece(valor);
        }
        return estaIncluido;
    }
}

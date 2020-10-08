package Programas;
import Interfaces.ABBTDA;
import ImplementacionesDinamicas.ABB;
import Metodos.MetodosABB;

public class AppArbol {
    public static void main(String[] args) {
        MetodosABB funcs = new MetodosABB();
        ABBTDA arbol = new ABB();
        arbol.inicializarABB();

        arbol.agregar(10);
        arbol.agregar(15);
        arbol.agregar(12);
        arbol.agregar(17);
        arbol.agregar(16);
        arbol.agregar(19);
        arbol.agregar(5);
        arbol.agregar(7);
        arbol.agregar(3);
        arbol.agregar(4);

        System.out.println("-------------- Orden -------------------------");
        funcs.imprimeOrden(arbol);
        System.out.println("---------------------------------------");
        System.out.println(funcs.cantElem(arbol));
        // arbol.eliminar(7);
        System.out.println(funcs.cantElem(arbol));
        System.out.println("---------------------------------------");

        System.out.println("Suma de todos los elementos: " + funcs.sumaArbol(arbol));
        System.out.println("El menor valor del arbol es: " + funcs.menorValor(arbol));
        System.out.println("El mayor valor del arbol es: " + funcs.mayorValor(arbol));


        System.out.println("-------------- Copia ABB ----------------------");
        
        ABBTDA copia = new ABB();
        copia.inicializarABB();
        funcs.copiaArbol(arbol, copia);
        funcs.imprimePost(arbol);        
        
        System.out.println("-------------- Vaciar ABB ----------------------");
        
        funcs.vaciar(copia);
        funcs.imprimeOrden(copia);
        System.out.println("Aca estaria la copia del arbol... Si aun existiera");
        
        System.out.println("-------------- Cant Pares ----------------------");
        System.out.println("El arbol tiene un total de " + funcs.cantPares(arbol) + " numeros pares.");
        
        System.out.println("-------------- Cant Impares ----------------------");
        System.out.println("El arbol tiene un total de " + funcs.cantImpares(arbol) + " numeros impares.");
        
        System.out.println("-------------- Profundidad ----------------------");
        int a_buscar = 12;
        System.out.println("La profundidad del numero " + a_buscar + " es: " + funcs.profundidad(arbol, a_buscar));
        
        System.out.println("-------------- Altura ----------------------");
        System.out.println("La altura del arbol es de: " + funcs.altura(arbol));

        
    }
}

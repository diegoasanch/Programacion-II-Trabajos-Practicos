package Programas;

import java.util.Scanner;

import Interfaces.ConjuntoTDA;
import Interfaces.GrafoTDA;
// import ImplementacionesEstaticas.Grafo;
import ImplementacionesDinamicas.Grafo;

public class RecorreGrafo {
    public static void main(String[] args) {

        GrafoTDA grafo1 = new Grafo();
        grafo1.inicializarGrafo();
        GrafoTDA grafo2 = new Grafo();
        grafo2.inicializarGrafo();

        cargaGrafo(grafo1);
        copiaGrafo(grafo1, grafo2);
        imprimeGrafo(grafo1);
        System.out.println("------- Deleting vertice 30 -----------");
        grafo1.eliminarVertice(30);
        imprimeGrafo(grafo1);

    }

    /** Copia los elementos de grafo1 a grafo2 manteniendo su estructura */
    public static void copiaGrafo(GrafoTDA grafo1, GrafoTDA grafo2) {
        ConjuntoTDA vertices = grafo1.vertices();
        int vert;

        // Agregamos los vertices
        while (!vertices.conjuntoVacio()) {
            vert = vertices.obtener();
            vertices.sacar(vert);
            grafo2.agregarVertice(vert);
        }

        vertices = grafo1.vertices();

        // Aca guardaremos los vertices a recorrer en el ciclo anidado
        ConjuntoTDA verticesCiclo;
        int vertBase, vertRef;

        while (!vertices.conjuntoVacio()) {
            vertBase = vertices.obtener();
            vertices.sacar(vertBase);

            verticesCiclo = grafo1.vertices();
            
            while (!verticesCiclo.conjuntoVacio()) {
                vertRef = verticesCiclo.obtener();
                verticesCiclo.sacar(vertRef);

                // Si existe en el grafo original pero no en el segundo (para evitar duplicados)
                if (grafo1.existeArista(vertBase, vertRef) && !grafo2.existeArista(vertBase, vertRef))
                    grafo2.agregarArista(vertBase, vertRef, grafo1.pesoArista(vertBase, vertRef));
            }
        }
    }



    public static void imprimeGrafo(GrafoTDA grafo) {
        ConjuntoTDA verticesBase = grafo.vertices();
        ConjuntoTDA verticesRef;
        int vertActual, vertRef;
        
        while (!verticesBase.conjuntoVacio()) {
            vertActual = verticesBase.obtener();
            verticesBase.sacar(vertActual);

            System.out.println("\nVertice " + vertActual + ":");
            verticesRef = grafo.vertices();

            while (!verticesRef.conjuntoVacio()) {
                vertRef = verticesRef.obtener();
                verticesRef.sacar(vertRef);

                // Arista saliente
                if (grafo.existeArista(vertActual, vertRef))
                    System.out.println("    " + vertActual + " --- " + grafo.pesoArista(vertActual, vertRef) + " ---> " + vertRef);
                
                // Arista entrante
                else if (grafo.existeArista(vertRef, vertActual))
                    System.out.println("    " + vertRef + " <--- " + grafo.pesoArista(vertRef, vertActual) + " --- " + vertActual);
            }
        }
    }



    // Carga vertices y aristas en el grafo recibido hasta recibir un campo vacio
    public static void cargaGrafo(GrafoTDA grafo) {

        Scanner teclado = new Scanner(System.in);
        String linea;
        int vert1, vert2, peso;

        System.out.print("Ingrese (vertice1, vertice2, pesoArista): ");
        linea = teclado.nextLine();
        
        while (!linea.equals("")) {
            String[] valores = linea.split(",");
            vert1 = Integer.valueOf(valores[0]);
            vert2 = Integer.valueOf(valores[1]);
            peso = Integer.valueOf(valores[2]);

            if (!grafo.vertices().pertenece(vert1))
                grafo.agregarVertice(vert1);

            if (!grafo.vertices().pertenece(vert2))
                grafo.agregarVertice(vert2);

            if (! grafo.existeArista(vert1, vert2))
                grafo.agregarArista(vert1, vert2, peso);
            else
                System.out.println("La arista ya pertenece al grafo");


            System.out.print("Ingrese (vertice1, vertice2, pesoArista): ");
            linea = teclado.nextLine();
        }
        teclado.close();
    }
}

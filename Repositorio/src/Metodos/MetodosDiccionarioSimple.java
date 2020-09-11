package Metodos;
import Interfaces.DiccionarioSimpleTDA;
import Interfaces.ConjuntoTDA;
// import ImplementacionesEstaticas.DiccionarioSimple;
import java.util.Scanner;

public class MetodosDiccionarioSimple {

    /** Carga un diciconario con claves y valores, solo acepta claves unicas
     * Se le informara en caso de ingresar una clave repetida
     * @Precondicion El diccionario debe estar inicializado
     */
    public void cargaDiccionario(DiccionarioSimpleTDA a_cargar) {
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

    public void imprimeDiccionario(DiccionarioSimpleTDA a_imprimir) {
        ConjuntoTDA claves = a_imprimir.claves();
        int clave;

        while ( ! claves.conjuntoVacio()) {
            clave = claves.obtener();
            claves.sacar(clave);

            System.out.println("Clave: " + clave + " ----- Valor: " + a_imprimir.obtener(clave));
        }
    }


}

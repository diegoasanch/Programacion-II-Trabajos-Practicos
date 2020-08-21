import java.util.Scanner;  // Import the Scanner class

class Main {
    public static void main(String[] args) {
        PilaAlt2TDA pila = new PilaAlt2();
        pila.inicializarPila();
        cargarPila(pila);
        imprimirPila(pila);
    }
      
    public static void cargarPila(PilaAlt2TDA pila) {
        Scanner teclado = new Scanner(System.in);
        int dato;
        System.out.print("Dato? ");
        dato = teclado.nextInt();
        while (dato != 0) {
            pila.apilar(dato);
            System.out.print("Dato? ");
            dato = teclado.nextInt();
        }
    }

    public static void imprimirPila(PilaAlt2TDA pila) {
        while (!pila.pilaVacia()) {
            System.out.print(pila.topeSacar() + " - ");
        }
    }
}
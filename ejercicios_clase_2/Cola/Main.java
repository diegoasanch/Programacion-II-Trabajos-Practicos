import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        ColaTDA cola = new ColaPIni();
        cola.inicializarCola();

        cargarCola(cola);
        imprimirCola(cola);
    }

    public static void cargarCola(ColaTDA cola) {
        Scanner teclado = new Scanner(System.in);
        int dato;

        System.out.print("Ingrese un numero: ");
        dato = teclado.nextInt();
        while(dato != -1) {
            cola.acolar(dato);
            System.out.print("Ingrese un numero: ");
            dato = teclado.nextInt();
        }
    }

    public static void imprimirCola(ColaTDA cola) {

        while (! cola.colaVacia()) {
            System.out.print(cola.primero() + " - ");
            cola.desacolar();
        }
    }
}
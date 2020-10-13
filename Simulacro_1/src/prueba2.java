import java.util.Scanner;

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;

public class prueba2 {
    public static void main(String[] args) {
        sanchezEj1 dic = new sanchezEj1();
        dic.InicializarDiccionario();

        cargar(dic);
        imprime(dic);

        Scanner teclado = new Scanner(System.in); // para uso de teclado
        System.out.println("Ingrese una clave para eliminar: ");
        int clave = teclado.nextInt();
        System.out.println("Ingrese un valor para eliminar: ");
        int valor = teclado.nextInt();

        dic.EliminarValor(clave, valor);
        imprime(dic);

    }

    public static void cargar(DiccionarioMultipleTDA dic) {
        Scanner teclado = new Scanner(System.in); // para uso de teclado
        int clave, valor;
        System.out.print("clave: ");
        clave = teclado.nextInt();
        while (clave != 0) {
            System.out.print("Valor: ");
            valor = teclado.nextInt();
            dic.Agregar(clave, valor);
            System.out.print("clave: ");
            clave = teclado.nextInt();
        }
    }

    public static void imprime(DiccionarioMultipleTDA dic) {
        ConjuntoTDA claves = dic.Claves();
        int clave;

        while (!claves.ConjuntoVacio()) {
            clave = claves.Elegir();
            claves.Sacar(clave);
            System.out.printf("Clave: %d Valores: ", clave);

            ConjuntoTDA valores = dic.Recuperar(clave);
            int valor;

            while (!valores.ConjuntoVacio()) {
                valor = valores.Elegir();
                valores.Sacar(valor);
                System.out.printf(" - %d", valor);
            }

            System.out.println();
        }
    }
}

import java.util.Scanner;

import Api.ColaPrioridadTDA;
import Implementaciones.ColaPrioridad;


public class prueba1 {
    public static void main(String[] args) {
        ColaPrioridadTDA cola = new ColaPrioridad();
        cola.InicializarCola();
    
        cargarCPTeclado(cola);
        // imprimeCola(cola);

        System.out.println("\n------- Cola Filtrada -------\n");
        sanchezEj2 met = new sanchezEj2();
        ColaPrioridadTDA colaFIltrada = met.eliminaRep(cola);
        imprimeCola(colaFIltrada);
    
    }

    public static void imprimeCola(ColaPrioridadTDA cola) {
        while (!cola.ColaVacia()) {
            System.out.printf("Valor: %d --- Prioridad: %d%n", cola.Primero(), cola.Prioridad());
            cola.Desacolar();
        }
    }

    public static void cargarCPTeclado(ColaPrioridadTDA destino) {
		Scanner teclado = new Scanner(System.in); // para uso de teclado
		int dato, prioridad;
		System.out.print("Clave: ");
		dato = teclado.nextInt();
		while (dato != 0) {
			System.out.print("Valor: ");
			prioridad = teclado.nextInt();
			destino.AcolarPrioridad(dato, prioridad);
			System.out.print("Dato? ");
			dato = teclado.nextInt();
		}
	}
    
}

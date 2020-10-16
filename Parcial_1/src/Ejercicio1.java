import TDAs.PilaRaraTDA;
import Implementaciones.PilaRara;

public class Ejercicio1 {
    public static void main(String[] args)  {
        PilaRaraTDA pila = new PilaRara();
        pila.inicializarPila();

        for (int i = 0; i < 20; i++)
            pila.agregar(i);
        
        while (!pila.pilaVacia()) {
            System.out.println(pila.obtener());
            pila.sacar();
        }
        
    }
}

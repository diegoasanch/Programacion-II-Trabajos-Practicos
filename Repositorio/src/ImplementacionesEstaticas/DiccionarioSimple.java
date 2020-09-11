package ImplementacionesEstaticas;
import Interfaces.DiccionarioSimpleTDA;
import Interfaces.ConjuntoTDA;

public class DiccionarioSimple implements DiccionarioSimpleTDA {
    class Par {
        int clave;
        int valor;
    }

    private Par [] contenedor;
    private int cant;

    public void inicializarDiccionarioSimple() {
        contenedor = new Par[100];
        cant = 0;
    }
    
    public void agregar(int clave, int valor) {
        contenedor[cant] = new Par();
        contenedor[cant].clave = clave;
        contenedor[cant].valor = valor;
        cant ++;
    }

    public void eliminar(int a_sacar) {
        int i = cant - 1;
        // Buscamos la posicion del elemento a sacar
        while (contenedor[i].clave != a_sacar)
            i --;
        // Movemos la ultima posicion al elemento que vamos a sacar
        contenedor[i] = contenedor[cant - 1];
        cant --;
    }

    public int obtener(int a_buscar) {
        int i = 0;
        // Buscamos la pos del elemento a buscar
        while (contenedor[i].clave != a_buscar)
            i ++;
        
        return contenedor[i].valor;
    }

    public ConjuntoTDA claves() {

        ConjuntoTDA conjuntoClaves = new Conjunto();
        conjuntoClaves.inicializarConjunto();

        for (int i = 0; i < cant; i ++)
            conjuntoClaves.agregar(contenedor[i].clave);
        
        return conjuntoClaves;
    }
}

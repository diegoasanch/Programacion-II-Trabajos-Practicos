/**
    Lista de operaciones que nos permite especificar el TDA:
    Agregar:
        dada una clave y un valor, agrega al diccionario el valor quedando asociado a la clave. Una misma
        clave puede tener asociada un conjunto de valores, pero esos valores no se pueden repetir. Para poder agregar
        un par clave/valor la estructura debe estar inicializada.
    Eliminar:
        dada una clave elimina todos los valores asociados a la clave, y por consiguiente la clave ya que el
        diccionario no puede contener claves sin valores asociados. Si la clave no existe no se hace nada. Se supone que
        el diccionario esta inicializado.
    EliminarValor: 
        dada una clave y un valor se elimina el valor asociado a la clave, y en caso de que la clave o el
        valor no existan no se hace nada. Si al eliminar el valor, la clave no tiene otros valores asociados se debe
        eliminar la misma. Se supone que el diccionario esta inicializado.
    Recuperar:
        dada una clave devuelve el conjunto de valores asociados a la misma. Si la clave dada no pertenece
        al diccionario, se debe devolver un conjunto vacío. Se supone que el diccionario esta inicializado.
    Claves:
        devuelve el conjunto de todas las claves definidas en el diccionario. Se supone que el diccionario esta
        inicializado.
    InicializarDiccionario: 
        permite inicializar la estructura del diccionario.

    Realizar la implementación de los métodos agregar y recuperar de un diccionario múltiple, donde el
    almacenamiento de las claves será dinámico (no se sabe la cantidad máxima de claves a almacenar) y el
    almacenamiento de los valores será estática (no pueden superar los 100 valores).
    Se deberá entregar: el esqueleto de la implementación del diccionario con la declaración del nodo, variables de
    clase y codificación los métodos solicitados.
 */

import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;
import Implementaciones.Conjunto;

public class sanchezEj1 implements DiccionarioMultipleTDA {

    class Nodo {
        int clave;
        int[] valores;
        int cant;
        Nodo sig;
    }

    private Nodo inicio;

    @Override
    public void Agregar(int clave, int valor) {
        Nodo actual;

        // Buscamos el nodo si existe
        if (Claves().Pertenece(clave)) {
            // Si la clave ya tiene el valor asociado no hacemos nada
            if (Recuperar(clave).Pertenece(valor))
                return;
            actual = buscaNodo(clave);
        }
        // Si no existe lo creamos y colocamos al inicio
        else {
            actual = new Nodo();
            actual.clave = clave;
            actual.valores = new int[100];
            actual.cant = 0;
            actual.sig = inicio;
            inicio = actual;
        }
        actual.valores[actual.cant++] = valor;
    }

    @Override
    public ConjuntoTDA Claves() {
        ConjuntoTDA misClaves = new Conjunto();
        Nodo actual = inicio;

        while (actual != null) {
            misClaves.Agregar(actual.clave);
            actual = actual.sig;
        }
        return misClaves;
    }

    @Override
    public void Eliminar(int clave) {
        if (Claves().Pertenece(clave)) {
            if (inicio.clave == clave)
                inicio = inicio.sig;
            else {
                Nodo prev = inicio;
                Nodo actual = inicio.sig;

                while (actual.clave != clave) {
                    prev = actual;
                    actual = actual.sig;
                }
                prev.sig = actual.sig;
            }
        }
    }

    @Override
    public void EliminarValor(int clave, int valor) {

        if (Claves().Pertenece(clave) && Recuperar(clave).Pertenece(valor)) {
            Nodo actual = buscaNodo(clave);

            int i = 0, j;
            // Buscamos la posicion del valor
            while (actual.valores[i] != valor)
                i++;
            
            // Movemos todos los valores siguientes una posicion hacia atras
            for (j = i; j < (actual.cant - 1); j++)
                actual.valores[j] = actual.valores[j + 1];
            actual.cant--;

            // Si la clave quedo sin ningun valor asociado la eliminamos
            if (actual.cant == 0)
                Eliminar(clave);
        }
    }

    @Override
    public void InicializarDiccionario() {
        inicio = null;
    }

    @Override
    public ConjuntoTDA Recuperar(int clave) {
        ConjuntoTDA misClaves = new Conjunto();
        misClaves.InicializarConjunto();

        Nodo actual = buscaNodo(clave);
        int i;
        
        // Cargamos sus valores en el conj
        for (i = 0; i < actual.cant; i++)
            misClaves.Agregar(actual.valores[i]);
        
        return misClaves;
    }

    /** @tarea buscaNodo retirna el nodo correspondiente a la clave suministrada
     * @precond La clave debe pertenecer al diccionario
     */
    private Nodo buscaNodo(int clave) {
        Nodo actual = inicio;
        while (actual.clave != clave)
            actual = actual.sig;
        return actual;
    }
    
}

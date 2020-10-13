/**
  Codificar el siguiente método externo: dada una cola con prioridad en la que tanto las prioridades como los
  valores pueden estar repetidos dentro de ella, generar otra cola con prioridad nueva con los valores de la
  primera cola, tomando un solo ejemplar de los repetidos, la prioridad para cada valor de la nueva cola será el
  promedio de las prioridades de la cola origen asociadas a ese valor.
  Se deberá entregar el método en un archivo separado del punto A
 */

import Api.ColaPrioridadTDA;
import Api.ConjuntoTDA;
import Api.DiccionarioMultipleTDA;
import Implementaciones.ColaPrioridad;
import Implementaciones.DiccionarioMultiple;


public class sanchezEj2 {
    
    public ColaPrioridadTDA eliminaRep(ColaPrioridadTDA original)
    {
        /** Filtramos los valores en un diccionario DiccionarioMultiple, 
         * clave = valor de la cola
         * valores = prioridades de la cola
         */
        DiccionarioMultipleTDA filtrados = new DiccionarioMultiple();
        filtrados.InicializarDiccionario();

        // La nueva cola que retornaremos
        ColaPrioridadTDA nueva = new ColaPrioridad();
        nueva.InicializarCola();

        int prio, valor;

        while (!original.ColaVacia()) {
            filtrados.Agregar(original.Primero(), original.Prioridad());
            original.Desacolar();
        }

        // Cargamos la nueva cola con prioridad
        while (!filtrados.Claves().ConjuntoVacio()) {
            valor = filtrados.Claves().Elegir();
            prio = promedioConj(filtrados.Recuperar(valor));
            filtrados.Eliminar(valor);

            nueva.AcolarPrioridad(valor, prio);
        }
        return nueva;
    }

    /** @Tarea promedioConj retorna entero, promedio de los elementos del conjunto
     * @param conj conjunto a promediar
     * @precondicion el conjunto debe estar inicializado
     */
    public int promedioConj(ConjuntoTDA conj) {
        int total = 0, cant = 0;
        int res, valor;

        while (!conj.ConjuntoVacio()) {
            valor = conj.Elegir();
            total += valor;
            conj.Sacar(valor);
            cant++;
        }
        if (cant == 0)
            res = 0;
        else
            res = total / cant;
        return res;
    }
}

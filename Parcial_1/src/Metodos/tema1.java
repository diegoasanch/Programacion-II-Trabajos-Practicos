package Metodos;

import Api.ABBTDA;
import Api.DiccionarioMultipleTDA;
import Implementaciones.DiccionarioMultiple;

public class tema1 {
    
    public DiccionarioMultipleTDA recorrido(ABBTDA arbol, int valor) {
        DiccionarioMultipleTDA dic = new DiccionarioMultiple();
        dic.inicializarDiccionarioMultiple();

        if (arbol.pertenece(valor))
            agregaNodo(arbol, valor, dic);
        
        return dic;
    }

    private void agregaNodo(ABBTDA arbol, int valor, DiccionarioMultipleTDA dic) {
        if (valor != arbol.raiz()) {
            dic.agregar(valor, arbol.raiz());

            if (valor < arbol.raiz())
                agregaNodo(arbol.hijoIzq(), valor, dic);

            else if (valor > arbol.raiz())
                agregaNodo(arbol.hijoDer(), valor, dic);
        }
    }
}

package Programas;
import Interfaces.DiccionarioSimpleTDA;
import ImplementacionesEstaticas.DiccionarioSimple;
import Metodos.MetodosDiccionarioSimple;

public class PruebaDicc {
    public static void main(String[] args) {
        MetodosDiccionarioSimple metodos = new MetodosDiccionarioSimple();
        
        DiccionarioSimpleTDA diccionario = new DiccionarioSimple();
        diccionario.inicializarDiccionarioSimple();

        metodos.cargaDiccionario(diccionario);
        metodos.imprimeDiccionario(diccionario);
    }
}

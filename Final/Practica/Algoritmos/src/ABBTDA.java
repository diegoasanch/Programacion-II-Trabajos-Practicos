// ABB: no tiene repetidos
public interface ABBTDA {

    void inicializarABB();

    int raiz();               // el arbol no debe estar vacio

    ABBTDA hijoIzq();         // el arbol debe estar inicializado

    ABBTDA hijoDer();         // el arbol debe estar inicializado

    void agregar(int x);      // x no pertenece al arbol

    void eliminar(int x);     // x pertenece al arbol

    boolean pertenece(int x); // el arbol inicializado

    boolean arbolVacio();     // el arbol inicializado
}

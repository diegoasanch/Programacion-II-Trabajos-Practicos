package TDAs;

public interface ConjuntoTDA{
    void agregar(int x);
    void sacar(int x);
    boolean pertenece(int x);
    int elegir();
    boolean conjuntoVacio();
    void inicializarConjunto();
}

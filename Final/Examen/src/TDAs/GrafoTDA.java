package TDAs;

public interface GrafoTDA {
    void inicializarGrafo();
    void agregarVertice(int v);
    void eliminarVertice(int v);
    ConjuntoTDA vertices();
    void agregarArista(int v1, int v2, int p);
    void EliminarArista(int v1, int v2);
    boolean ExisteArista(int v1, int v2);
    int PesoArista(int v1 , int v2);
}

package interfaces;

import java.util.Comparator;

public interface IArbolBinario<T> {
    void insertar(T dato, Comparator<T> cmp);
    boolean buscar(T dato, Comparator<T> cmp);
    boolean eliminar(T dato, Comparator<T> cmp);
    void recorrerPreOrder();
    void recorrerInOrder();
    void recorrerPostOrder();
}

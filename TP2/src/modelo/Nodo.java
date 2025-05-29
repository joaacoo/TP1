package modelo;

public class Nodo<T> {
    T dato;
    Nodo<T> izquierda;
    Nodo<T> derecha;

    public Nodo(T dato) {
        this.dato = dato;
        izquierda = null;
        derecha = null;
    }
}

package modelo;

import interfaces.IArbolBinario;
import java.util.Comparator;

public class ArbolBinario<T> implements IArbolBinario<T> {
    private Nodo<T> raiz;

    @Override
    public void insertar(T dato, Comparator<T> cmp) {
        raiz = insertarRec(raiz, dato, cmp);
    }

    private Nodo<T> insertarRec(Nodo<T> nodo, T dato, Comparator<T> cmp) {
        if (nodo == null) {
            return new Nodo<>(dato);
        }
        if (cmp.compare(dato, nodo.dato) < 0) {
            nodo.izquierda = insertarRec(nodo.izquierda, dato, cmp);
        } else {
            nodo.derecha = insertarRec(nodo.derecha, dato, cmp);
        }
        return nodo;
    }

    @Override
    public boolean buscar(T dato, Comparator<T> cmp) {
        return buscarRec(raiz, dato, cmp);
    }

    private boolean buscarRec(Nodo<T> nodo, T dato, Comparator<T> cmp) {
        if (nodo == null) {
            return false;
        }
        int comp = cmp.compare(dato, nodo.dato);
        if (comp == 0) {
            return true;
        } else if (comp < 0) {
            return buscarRec(nodo.izquierda, dato, cmp);
        } else {
            return buscarRec(nodo.derecha, dato, cmp);
        }
    }

    @Override
    public boolean eliminar(T dato, Comparator<T> cmp) {
        if (!buscar(dato, cmp)) {
            return false;
        }
        raiz = eliminarRec(raiz, dato, cmp);
        return true;
    }

    private Nodo<T> eliminarRec(Nodo<T> nodo, T dato, Comparator<T> cmp) {
        if (nodo == null) {
            return null;
        }
        int comp = cmp.compare(dato, nodo.dato);
        if (comp < 0) {
            nodo.izquierda = eliminarRec(nodo.izquierda, dato, cmp);
        } else if (comp > 0) {
            nodo.derecha = eliminarRec(nodo.derecha, dato, cmp);
        } else {
            if (nodo.izquierda == null) {
                return nodo.derecha;
            } else if (nodo.derecha == null) {
                return nodo.izquierda;
            } else {
                Nodo<T> min = encontrarMin(nodo.derecha);
                nodo.dato = min.dato;
                nodo.derecha = eliminarRec(nodo.derecha, min.dato, cmp);
            }
        }
        return nodo;
    }

    private Nodo<T> encontrarMin(Nodo<T> nodo) {
        while (nodo.izquierda != null) {
            nodo = nodo.izquierda;
        }
        return nodo;
    }

    @Override
    public void recorrerPreOrder() {
        preOrderRec(raiz);
        System.out.println();
    }

    private void preOrderRec(Nodo<T> nodo) {
        if (nodo != null) {
            System.out.print(nodo.dato + " ");
            preOrderRec(nodo.izquierda);
            preOrderRec(nodo.derecha);
        }
    }

    @Override
    public void recorrerInOrder() {
        inOrderRec(raiz);
        System.out.println();
    }

    private void inOrderRec(Nodo<T> nodo) {
        if (nodo != null) {
            inOrderRec(nodo.izquierda);
            System.out.print(nodo.dato + " ");
            inOrderRec(nodo.derecha);
        }
    }

    @Override
    public void recorrerPostOrder() {
        postOrderRec(raiz);
        System.out.println();
    }

    private void postOrderRec(Nodo<T> nodo) {
        if (nodo != null) {
            postOrderRec(nodo.izquierda);
            postOrderRec(nodo.derecha);
            System.out.print(nodo.dato + " ");
        }
    }
}

package modelo;

import interfaces.IArbolBinario;

public class ArbolBinario implements IArbolBinario {
    private NodoArbol raiz;

    @Override
    public void insertar(Persona persona, boolean compararPorDni) {
        raiz = insertarRec(raiz, persona, compararPorDni);
    }

    private NodoArbol insertarRec(NodoArbol actual, Persona persona, boolean compararPorDni) {
        if (actual == null) return new NodoArbol(persona);

        int cmp = compararPorDni ? Integer.compare(persona.getDni(), actual.persona.getDni()) // Comaparamos por DNI
                                 : persona.getNombre().compareToIgnoreCase(actual.persona.getNombre());

        if (cmp < 0)
            actual.izquierdo = insertarRec(actual.izquierdo, persona, compararPorDni);
        else if (cmp > 0)
            actual.derecho = insertarRec(actual.derecho, persona, compararPorDni);

        return actual;
    }

    @Override
    public void eliminar(int valor, boolean compararPorDni) {
        raiz = eliminarRec(raiz, valor, compararPorDni);
    }

    private NodoArbol eliminarRec(NodoArbol nodo, int valor, boolean compararPorDni) {
        if (nodo == null) return null;

        int cmp = compararPorDni ? Integer.compare(valor, nodo.persona.getDni()) : 0;

        if (compararPorDni) {
            if (cmp < 0)
                nodo.izquierdo = eliminarRec(nodo.izquierdo, valor, true);
            else if (cmp > 0)
                nodo.derecho = eliminarRec(nodo.derecho, valor, true);
            else {
                if (nodo.izquierdo == null) return nodo.derecho;
                if (nodo.derecho == null) return nodo.izquierdo;

                NodoArbol menor = encontrarMin(nodo.derecho);
                nodo.persona = menor.persona;
                nodo.derecho = eliminarRec(nodo.derecho, menor.persona.getDni(), true);
            }
        }

        return nodo;
    }

    private NodoArbol encontrarMin(NodoArbol nodo) {
        while (nodo.izquierdo != null) nodo = nodo.izquierdo;
        return nodo;
    }

    @Override
    public boolean buscar(int valor, boolean compararPorDni) {
        return buscarRec(raiz, valor, compararPorDni);
    }

    private boolean buscarRec(NodoArbol nodo, int valor, boolean compararPorDni) {
        if (nodo == null) return false;
        int cmp = compararPorDni ? Integer.compare(valor, nodo.persona.getDni()) : 0;

        if (cmp == 0) return true;
        return cmp < 0 ? buscarRec(nodo.izquierdo, valor, compararPorDni) :
                         buscarRec(nodo.derecho, valor, compararPorDni);
    }

    @Override
    public void mostrarInOrden() {
        inOrden(raiz);
        System.out.println();
    }

    private void inOrden(NodoArbol nodo) {
        if (nodo != null) {
            inOrden(nodo.izquierdo);
            System.out.print(nodo.persona + " | ");
            inOrden(nodo.derecho);
        }
    }

    @Override
    public void mostrarPreOrden() {
        preOrden(raiz);
        System.out.println();
    }

    private void preOrden(NodoArbol nodo) {
        if (nodo != null) {
            System.out.print(nodo.persona + " | ");
            preOrden(nodo.izquierdo);
            preOrden(nodo.derecho);
        }
    }

    @Override
    public void mostrarPostOrden() {
        postOrden(raiz);
        System.out.println();
    }

    private void postOrden(NodoArbol nodo) {
        if (nodo != null) {
            postOrden(nodo.izquierdo);
            postOrden(nodo.derecho);
            System.out.print(nodo.persona + " | ");
        }
    }
}

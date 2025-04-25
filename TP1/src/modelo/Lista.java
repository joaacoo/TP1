package modelo;

import interfaces.ILista;
import interfaces.INodo;

public class Lista implements ILista {
    private INodo primero;
    private INodo ultimo;

    public Lista() {
        this.primero = null;
        this.ultimo = null;
    }

    public boolean esVacia() {
        return primero == null;
    }

    public void insertarPrimero(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = ultimo = nuevo;
        } else {
            nuevo.setSiguiente(primero);
            primero.setAnterior(nuevo);
            primero = nuevo;
        }
    }

    public void insertarUltimo(Vehiculo dato) {
        INodo nuevo = new Nodo(dato);
        if (esVacia()) {
            primero = ultimo = nuevo;
        } else {
            ultimo.setSiguiente(nuevo);
            nuevo.setAnterior(ultimo);
            ultimo = nuevo;
        }
    }

    public Vehiculo obtenerPrimero() {
        if (esVacia()) throw new IllegalStateException("Lista vacía");
        return primero.getDato();
    }

    public int cantidadElementos() {
        int contador = 0;
        INodo actual = primero;
        while (actual != null) {
            contador++;
            actual = actual.getSiguiente();
        }
        return contador;
    }

    public void mostrarLista() {
        INodo actual = primero;
        while (actual != null) {
            System.out.println(actual.getDato());
            actual = actual.getSiguiente();
        }
    }
}
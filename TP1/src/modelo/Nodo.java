package modelo;

import interfaces.INodo;

public class Nodo implements INodo {
    private Vehiculo dato;
    private INodo siguiente;
    private INodo anterior;

    public Nodo(Vehiculo dato) {
        this.dato = dato;
        this.siguiente = null;
        this.anterior = null;
    }

    public Vehiculo getDato() {
        return dato;
    }

    public void setDato(Vehiculo dato) {
        this.dato = dato;
    }

    public INodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(INodo siguiente) {
        this.siguiente = siguiente;
    }

    public INodo getAnterior() {
        return anterior;
    }

    public void setAnterior(INodo anterior) {
        this.anterior = anterior;
    }
}
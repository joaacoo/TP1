package modelo;

import interfaces.ILista;
import interfaces.INodo;

public class Lista implements ILista {

	//Hace referencia al primer nodo de la lista.
	private INodo primero;
	
	public Lista() {
		super();
		this.primero = null;
	}
	
	@Override
	//Obtener el primer nodo de la lista
	public INodo getPrimero() {
        return primero;
	}

	@Override
	//Modifica el primer nodo de la lista
	public void setPrimero(INodo primero) {
        this.primero = primero;
	}

	@Override
	//Agrega nodo al principio
	public void insertarPrimero(int d) {
        INodo nuevo = new Nodo(d);
        if (!estaVacia()) {
            nuevo.setSiguiente(primero);
            //le 
            primero.setAnterior(nuevo);
        }
        primero = nuevo;
	}

	@Override
	//Agrega nodo al final	
	public void insertarUltimo(int d) {
		INodo nuevo = new Nodo(d);
        if (estaVacia()) {
            primero = nuevo;
        } else {
            INodo actual = primero;
            //Recorre hasta el último nodo
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            //se conecta el ultimo nodo como siguiente el nuevo nodo insertado
            actual.setSiguiente(nuevo);
            //al nuevo nodo se le conecta como anterior el ultimo nodo que habia antes de insertar  
            nuevo.setAnterior(actual);
        }
	}

	@Override
	public void insertarGenerico(int d, int pos) {
		if (pos <= 0 || estaVacia()) {
            insertarPrimero(d);
            return;
        }

        INodo actual = primero;
        int index = 0;
        while (actual.getSiguiente() != null && index < pos - 1) {
            actual = actual.getSiguiente();
            index++;
        }

        INodo nuevo = new Nodo(d);
        INodo siguiente = actual.getSiguiente();
        
        nuevo.setSiguiente(siguiente);
        nuevo.setAnterior(actual);
        actual.setSiguiente(nuevo);
        
        if (siguiente != null) {
            siguiente.setAnterior(nuevo);
        }
	}

	@Override
	//Elimino el primer nodo
	public int eliminarPrimero() {
        if (estaVacia()) return -1;
        int dato = primero.getDato();
        primero = primero.getSiguiente();
        if (primero != null) { 
        	primero.setAnterior(null);
        }
        return dato;
	}

	@Override
	public int eliminarUltimo() {
        if (estaVacia()) return -1;
        if (primero.getSiguiente() == null) {
            int dato = primero.getDato();
            primero = null;
            return dato;
        }

        INodo actual = primero;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }

        int dato = actual.getSiguiente().getDato();
        actual.setSiguiente(null);
        return dato;
	}

	@Override
	public int eliminarGenerico(int pos) {
		if (estaVacia()) { 
			return -1;
		}
        if (pos == 0) { 
        	return eliminarPrimero(); 
        }

        INodo actual = primero;
        int index = 0;

        while (actual.getSiguiente() != null && index < pos - 1) {
            actual = actual.getSiguiente();
            index++;
        }

        INodo nodoAEliminar = actual.getSiguiente();
        if (nodoAEliminar == null) { 
        	return -1;
        }

        INodo siguiente = nodoAEliminar.getSiguiente();
        actual.setSiguiente(siguiente);
        if (siguiente != null) {
            siguiente.setAnterior(actual);
        }

        return nodoAEliminar.getDato();
	}

	@Override
	public int obtenerPrimero() {
        return estaVacia() ? -1 : primero.getDato();
	}

	@Override
	public int obtenerUltimo() {
		if (estaVacia()) return -1;
        INodo actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        return actual.getDato();
	}

	@Override
	public int obtenerGenerico(int pos) {
		// if (estaVacia()) return -1;
        INodo actual = primero;
        int index = 0;
        while (actual != null && index < pos) {
            actual = actual.getSiguiente();
            index++;
        }
        return (actual != null) ? actual.getDato() : -1;
	}

	@Override
	public boolean estaVacia() {
        return primero == null;
	}

	@Override
	public int cantidadElementos() {
		int count = 0;
        INodo actual = primero;
        while (actual != null) {
            count++;
            actual = actual.getSiguiente();
        }
        return count;
	}

	@Override
	public void ordenar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mostrar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int buscar(int d) {
		INodo actual = primero;
        int pos = 0;
        while (actual != null) {
            if (actual.getDato() == d) {
                return pos;
            }
            actual = actual.getSiguiente();
            pos++;
        }
        return -1;
	}

}

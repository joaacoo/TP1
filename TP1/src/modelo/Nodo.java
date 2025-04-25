package modelo;

import interfaces.INodo;

public class Nodo implements INodo {
	private int dato;
    private INodo siguiente;
    private INodo anterior;

    //El constructor no es un método!!!
  	///Constructor = reserva la memoria
  	public Nodo(int dato) {
  		super();
  		this.dato = dato;
  		this.siguiente = null;
  		this.anterior = null;
  	}
  	
  	
	@Override
	//Devuelve el valor que guarda el nodo
	public int getDato() {
		return dato;
	}

	@Override
	//Cambiar el valor del nodo
	public void setDato(int dato) {
        this.dato = dato;
	}

	@Override
	//Devuelve el nodo que esta anterior al actual
	public INodo getAnterior() {
		return anterior;
	}

	@Override
	//Devuelve el nodo que esta despues del actual
	public INodo getSiguiente() {
		return siguiente;
	}

	@Override
	//Establece cuál será el nodo anterior.
	public void setAnterior(INodo anterior) {
		this.anterior = anterior;		
	}

	@Override
	//Establece cuál será el nodo siguiente de este
	public void setSiguiente(INodo siguiente) {
		this.siguiente = siguiente;
	}

	@Override
	//Devuelve el valor del nodo como texto
	public String toString() {
		return "Nodo [dato=" + dato + ", siguiente=" + siguiente + ", anterior=" + anterior + "]";
	}
}

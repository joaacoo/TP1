package test;

import interfaces.ILista;
import modelo.Lista;

public class TestListaDoblementeEnlazada {
	public static void main(String[] args) {

		ILista l = new Lista();
		System.out.println("Vacia: "+ l.estaVacia() );
		System.out.println("Cantidad: "+ l.cantidadElementos());		
		
		l.insertarPrimero(11);
		l.insertarPrimero(2);
		l.insertarUltimo(100);
		l.insertarGenerico(23,2);
		l.insertarUltimo(1);
		
		System.out.println("Vacia: "+ l.estaVacia());
		l.mostrar();
		System.out.println("Cantidad: "+ l.cantidadElementos());
		
		System.out.println("Agarrar el elemento 2: " + l.obtenerGenerico(2));
		
		System.out.println("Buscar un elemento 100: " + l.buscar(100));
		
		l.eliminarPrimero();
		l.eliminarGenerico(2);
		l.eliminarUltimo();
		
		l.mostrar();
	}
}

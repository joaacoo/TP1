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
        	// Le asignamos la nodo nuevo como siguiente el nodo que estaba primero
            nuevo.setSiguiente(primero); 
            //le asignamos al nodo que estaba primero como anterior el nuevo nodo
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
	// La funcion sirve para agregar el nodo en una posicion determinada
	public void insertarGenerico(int d, int pos) {
		if (pos <= 0 || estaVacia()) {
            insertarPrimero(d);
            return;
        }

        INodo actual = primero;
        int index = 0;
        // Recorremos hasta que index llegue al valor de posicion o se llegue al final la lista
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
		//Si esta vacia la lista, corto la funcion porque no tengo nada que eliminar
        if (estaVacia()) { 
        	return -1;
        }
        int dato = primero.getDato();
        //Obtengo el segundo nodo para asignarlo como primero, ya que voy a eliminar el primer nodo
        primero = primero.getSiguiente();
        if (primero != null) { 
        	//el segundo nodo pasa a ser el primero de la lista por lo que no va tener un nodo anterior, asi que se le asigna nulo
        	primero.setAnterior(null);
        }
        return dato;
	}

	@Override
	public int eliminarUltimo() {
		//Si esta vacia la lista, corto la funcion porque no tengo nada que eliminar
        if (estaVacia()) {
        	return -1;
        }
        //Si el siguiente del primero es nulo, significa que el primero es tambien el ultimo nodo. Es decir solo tenia un nodo la lista
        if (primero.getSiguiente() == null) {
            int dato = primero.getDato();
            primero = null;
            return dato;
        }
        
        //Recorremos la lista hasta llegar a la anteultima posicion, ya que la ultima posicion la voy a eliminar
        INodo actual = primero;
        while (actual.getSiguiente().getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        
        
        int dato = actual.getSiguiente().getDato();
        //el anteultimo pasa a ser el ultimo, por lo que no va a tener ningun nodo como siguiente.
        actual.setSiguiente(null);
        return dato;
	}

	@Override
	public int eliminarGenerico(int pos) {
		//Si esta vacia la lista, corto la funcion porque no tengo nada que eliminar
		if (estaVacia()) { 
			return -1;
		}
		//Si la posicion es cero es porque quiere eliminar el primero
        if (pos == 0) { 
        	return eliminarPrimero(); 
        }

        INodo actual = primero;
        int index = 0;
        //Recorremos hasta que index llegue al valor de posicion o se llegue al final la lista	
        while (actual.getSiguiente() != null && index < pos - 1) {
            actual = actual.getSiguiente();
            index++;
        }

        //Si no tiene siguiente es que la posicion que se quiere eliminar no existe
        INodo nodoAEliminar = actual.getSiguiente();
        if (nodoAEliminar == null) { 
        	return -1;
        }

        //Salteo al nodo que deseo eliminar	
        INodo siguiente = nodoAEliminar.getSiguiente();
        if (siguiente != null) {
        	actual.setSiguiente(siguiente);
            siguiente.setAnterior(actual);
        }

        return nodoAEliminar.getDato();
	}

	@Override
	public int obtenerPrimero() {
		if(estaVacia()) {
			//Esta vacia no tengo nodos
			return -1;
		}else {
			//Devuelvo los datos del primer nodo
			return primero.getDato();
		}
	}

	@Override
	public int obtenerUltimo() {
		if (estaVacia()) {
			//Esta vacia no tengo nodos
			return -1;
		}
		//Recorro hasta el final para obtener el ultimo nodo
        INodo actual = primero;
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
      //Devuelvo los datos del ultimo nodo
        return actual.getDato();
	}

	@Override
	public int obtenerGenerico(int pos) {
		if (estaVacia()) {
			return -1;
		}
        INodo actual = primero;
        int index = 0;
        while (actual != null && index < pos) {
            actual = actual.getSiguiente();
            index++;
        }
        if(actual == null) {
			//No encontro nodo en la posicion
			return -1;
		}else {
			//Devuelvo los datos del primer nodo
			return actual.getDato();
		}
	}

	@Override
	public boolean estaVacia() {
		boolean respuesta;
		if(primero == null) {
			respuesta = true;
		}else {
			respuesta = false;
		}
		return respuesta;
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

	@Override
	public void mostrar() {
		INodo actual = primero;
        while (actual != null) {
        	System.out.println(actual.getDato());
        	actual = actual.getSiguiente();
        }
	}

}

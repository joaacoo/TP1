package interfaces;

public interface ILista {
	
	public INodo getPrimero();
	public void setPrimero(INodo primero);

	@Override
	public String toString();
	

	public void insertarPrimero(int d);
	public void insertarUltimo(int d); //Cola -Pila
	public void insertarGenerico(int d, int pos);//Tarea
 
	public int eliminarPrimero(); //Cola
	public int eliminarUltimo();//-Pila
	public int eliminarGenerico(int pos);
	

	public int obtenerPrimero(); //Cola
	public int obtenerUltimo(); //Cola -Pila
	public int obtenerGenerico(int pos);

	public boolean estaVacia();
	public int cantidadElementos();
	
	//public void ordenar(); //selec - inse -burbu 
	public void mostrar();
	public int buscar(int d);  //retorna la pos

}

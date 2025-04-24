package interfaces;

public interface INodo {
	//Solo los métodos
	public int getDato();
	public void setDato(int dato);
	
	public INodo getAnterior();
	public INodo getSiguiente();

	public void setAnterior(INodo anterior);
	public void setSiguiente(INodo siguiente);
	
	@Override
	public String toString();
}

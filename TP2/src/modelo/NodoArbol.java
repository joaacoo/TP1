package modelo;

public class NodoArbol {
    public Persona persona;
    public NodoArbol izquierdo;
    public NodoArbol derecho;

    public NodoArbol(Persona persona) {
        this.persona = persona;
        izquierdo = derecho = null;
    }
}

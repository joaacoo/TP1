package interfaces;

import modelo.Persona;

public interface IArbolBinario {
    void insertar(Persona persona, boolean compararPorDni);
    void eliminar(int valor, boolean compararPorDni);
    boolean buscar(int valor, boolean compararPorDni);
    void mostrarInOrden();
    void mostrarPreOrden();
    void mostrarPostOrden();
}

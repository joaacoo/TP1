package interfaces;

import modelo.Lista;

public interface IPersona {
    int getDni();
    void setDni(int dni);
    String getNombre();
    void setNombre(String nombre);
    Lista getListaVehiculos();
    void setListaVehiculos(Lista listaVehiculos);
    void mostrarPersona();
}
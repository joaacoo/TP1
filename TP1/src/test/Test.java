package test;

import modelo.Persona;
import modelo.Vehiculo;

public class Test {

    public static void main(String[] args) {
        Persona persona = crearPersona();
        agregarVehiculos(persona);
        mostrarDatos(persona);
    }

    public static Persona crearPersona() {
        return new Persona(46912018, "Franco Brossi");
    }

    public static void agregarVehiculos(Persona persona) {
        Vehiculo v1 = new Vehiculo("ABC123", "Mclaren Senna");
        Vehiculo v2 = new Vehiculo("DEF456", "Honda Civic");
        Vehiculo v3 = new Vehiculo("GHI789", "Toyota Etios");

        persona.getListaVehiculos().insertarPrimero(v1);
        persona.getListaVehiculos().insertarUltimo(v2);
        persona.getListaVehiculos().insertarUltimo(v3);
    }

    public static void mostrarDatos(Persona persona) {
        persona.mostrarPersona();
    }
}
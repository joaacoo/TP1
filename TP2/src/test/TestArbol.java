package test;

import modelo.ArbolBinario;
import modelo.Persona;

public class TestArbol {
    public static void main(String[] args) {
        ArbolBinario arbolPorDni = new ArbolBinario();
        ArbolBinario arbolPorNombre = new ArbolBinario();

        Persona[] personas = {
            new Persona("Joaquin", 12345678), new Persona("Martin", 23456789), new Persona("Carlos", 34567890),
            new Persona("Lautaro", 45678901), new Persona("Elena", 56789012), new Persona("Fernando", 67890123),
            new Persona("Lucas", 78901234), new Persona("Hugo", 89012345), new Persona("Irene", 90123456),
            new Persona("Martina", 11223344), new Persona("Karla", 22334455), new Persona("Lucas", 33445566),
            new Persona("Marta", 44556677), new Persona("Nora", 55667788), new Persona("Oscar", 66778899)
        };

        // Inserción en ambos árboles
        for (Persona p : personas) {
            arbolPorDni.insertar(p, true);     // Comparar por DNI
            arbolPorNombre.insertar(p, false); // Comparar por Nombre
        }

        System.out.println("Recorrido InOrden por DNI");
        arbolPorDni.mostrarInOrden();
        System.out.println();

        System.out.println("Recorrido PreOrden por DNI");
        arbolPorDni.mostrarPreOrden();
        System.out.println();

        System.out.println("Recorrido PostOrden por DNI");
        arbolPorDni.mostrarPostOrden();
        System.out.println();

        System.out.println("Buscar y eliminar DNI 45678901 (Lautaro)");
        boolean encontrado = arbolPorDni.buscar(45678901, true);
        System.out.println("¿Encontrado? " + encontrado);

        if (encontrado) {
            System.out.println("Eliminando");
            arbolPorDni.eliminar(45678901, true);
        }
        System.out.println();

        System.out.println("Recorrido InOrden por DNI (actualizado)");
        arbolPorDni.mostrarInOrden();
        System.out.println();

        System.out.println("Recorrido InOrden por Nombre");
        arbolPorNombre.mostrarInOrden();
        System.out.println();

        System.out.println("Recorrido PreOrden por Nombre");
        arbolPorNombre.mostrarPreOrden();
        System.out.println();

        System.out.println("Recorrido PostOrden por Nombre");
        arbolPorNombre.mostrarPostOrden();
        System.out.println();
    }
}

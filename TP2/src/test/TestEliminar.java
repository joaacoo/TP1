package test;

import modelo.Persona;
import modelo.ArbolBinario;
import interfaces.IComparadorNombre;

public class TestEliminar {
    public static void main(String[] args) {
        ArbolBinario<Persona> arbol = new ArbolBinario<>();
        IComparadorNombre cmp = new IComparadorNombre();

        arbol.insertar(new Persona("Lucía", "30457892"), cmp);
        arbol.insertar(new Persona("Mateo", "25893412"), cmp);
        arbol.insertar(new Persona("Sofía", "32145678"), cmp);
        arbol.insertar(new Persona("Tomás", "27684315"), cmp);
        arbol.insertar(new Persona("Valentina", "30876543"), cmp);
        arbol.insertar(new Persona("Lucas", "29763482"), cmp);
        arbol.insertar(new Persona("Martina", "28574912"), cmp);
        arbol.insertar(new Persona("Julián", "30548712"), cmp);
        arbol.insertar(new Persona("Camila", "26984317"), cmp);
        arbol.insertar(new Persona("Santiago", "30274658"), cmp);
        arbol.insertar(new Persona("Florencia", "27463982"), cmp);
        arbol.insertar(new Persona("Facundo", "28917423"), cmp);
        arbol.insertar(new Persona("Ana", "25398741"), cmp);
        arbol.insertar(new Persona("Diego", "31247896"), cmp);
        arbol.insertar(new Persona("Victoria", "29837614"), cmp);

        System.out.println("Test Eliminar:");
        System.out.println("Eliminar Santiago: " + arbol.eliminar(new Persona("Santiago", "30274658"), cmp));
        System.out.println("Eliminar Ana: " + arbol.eliminar(new Persona("Ana", "25398741"), cmp));
        System.out.println("Eliminar Pedro (no existe): " + arbol.eliminar(new Persona("Pedro", "12345678"), cmp));

        System.out.print("PreOrder: ");
        arbol.recorrerPreOrder();

        System.out.print("InOrder: ");
        arbol.recorrerInOrder();

        System.out.print("PostOrder: ");
        arbol.recorrerPostOrder();
    }
}

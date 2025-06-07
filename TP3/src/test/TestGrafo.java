package test;

import modelo.*;
import interfaces.IGrafo;

public class TestGrafo {

    public static void main(String[] args) {

        IGrafo<Persona> grafo = new Grafo<>(true); // true = dirigido

        Persona a = new Persona("Vicky");
        Persona b = new Persona("Dante");
        Persona c = new Persona("Joaco");
        Persona d = new Persona("Lean");

        grafo.agregarNodo(a);
        grafo.agregarNodo(b);
        grafo.agregarNodo(c);
        grafo.agregarNodo(d);

        grafo.agregarArista(a, b);
        grafo.agregarArista(b, c);
        grafo.agregarArista(c, d);
        grafo.agregarArista(a, d);

        grafo.mostrarMatrizAdyacencia();
        grafo.mostrarListaAdyacencia();

        grafo.bfs(a);
        grafo.dfs(a);
    }
}

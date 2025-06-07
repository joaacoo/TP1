package modelo;

import java.util.*;
import interfaces.IGrafo;
import interfaces.INodo;

public class Grafo<T> implements IGrafo<T> {

    private Map<T, Nodo<T>> nodos = new HashMap<>();
    private boolean dirigido;

    public Grafo(boolean dirigido) {
        this.dirigido = dirigido;
    }

    public void agregarNodo(T valor) {
        if (!nodos.containsKey(valor)) {
            nodos.put(valor, new Nodo<>(valor));
        }
    }

    public void agregarArista(T origen, T destino) {
        if (nodos.containsKey(origen) && nodos.containsKey(destino)) {
            Nodo<T> nodoOrigen = nodos.get(origen);
            Nodo<T> nodoDestino = nodos.get(destino);

            // Si el grafo es dirigido, solo se agrega una arista desde origen hacia destino
            // Si es no dirigido, se agregan ambas direcciones (origen <-> destino)
            if (dirigido) {
                nodoOrigen.agregarVecino(nodoDestino);
            } else {
                nodoOrigen.agregarVecino(nodoDestino);
                nodoDestino.agregarVecino(nodoOrigen);
            }
        }
    } 
    		// Tanto DFS como BFS funcionan igual en grafos dirigidos y no dirigidos.
    		// Lo único que cambia es el conjunto de nodos alcanzables desde el nodo inicial.
    		// En grafos dirigidos, se sigue solo el sentido de las aristas.
    
    
    public void mostrarMatrizAdyacencia() {
        System.out.println("Matriz de Adyacencia:");
        List<T> claves = new ArrayList<>(nodos.keySet());

  
        System.out.print(String.format("%-10s", ""));
        
        for (T i : claves) System.out.print(String.format("%-10s", i));
        
        System.out.println();

        for (T i : claves) {
            System.out.print(String.format("%-10s", i + ":"));
            for (T j : claves) {
                Nodo<T> nodoI = nodos.get(i);
                Nodo<T> nodoJ = nodos.get(j);
                String val = nodoI.getVecinos().contains(nodoJ) ? "1" : "0";
                System.out.print(String.format("%-10s", val));
            }
            System.out.println();
        }
    }


    public void mostrarListaAdyacencia() {
        System.out.println("Lista de Adyacencia:");
        for (Map.Entry<T, Nodo<T>> entrada : nodos.entrySet()) {
            System.out.print(entrada.getKey() + ": ");
            for (INodo<T> vecino : entrada.getValue().getVecinos()) {
                System.out.print(vecino.getValor() + " ");
            }
            System.out.println();
        }
    }

    public void bfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        Queue<Nodo<T>> cola = new LinkedList<>();

        Nodo<T> nodoInicio = nodos.get(inicio);
        cola.add(nodoInicio);
        visitados.add(inicio);

        System.out.println("Recorrido BFS:");
        while (!cola.isEmpty()) {
            Nodo<T> actual = cola.poll();
            System.out.print(actual.getValor() + " ");

            for (INodo<T> vecino : actual.getVecinos()) {
                T valorVecino = vecino.getValor();
                if (!visitados.contains(valorVecino)) {
                    visitados.add(valorVecino);
                    cola.add((Nodo<T>) vecino);
                }
            }
        }
        System.out.println();
    }

    public void dfs(T inicio) {
        if (!nodos.containsKey(inicio)) return;

        Set<T> visitados = new HashSet<>();
        System.out.println("Recorrido DFS:");
        dfsRec(nodos.get(inicio), visitados);
        System.out.println();
    }

    private void dfsRec(Nodo<T> actual, Set<T> visitados) {
        visitados.add(actual.getValor());
        System.out.print(actual.getValor() + " ");

        for (INodo<T> vecino : actual.getVecinos()) {
            T valorVecino = vecino.getValor();
            if (!visitados.contains(valorVecino)) {
                dfsRec((Nodo<T>) vecino, visitados);
            }
        }
    }
}
	
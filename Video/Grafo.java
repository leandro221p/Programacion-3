// Importa clases para manejar listas y mapas
import java.util.*;

/**
 * Representa un grafo no dirigido con pesos en las aristas.
 * Usa una lista de adyacencia para almacenar conexiones.
 * Ahora usa LinkedList en lugar de ArrayList para las listas de aristas,
 * ya que LinkedList es eficiente para inserciones y eliminaciones frecuentes.
 */
public class Grafo {
    // Mapa: clave = nodo, valor = lista de aristas conectadas
    // Usamos LinkedList para la lista de aristas, como se pidió
    private Map<String, LinkedList<Arista>> listaAdyacencia;

    /**
     * Crea un grafo vacío.
     * Inicializa el mapa que contendrá las listas de adyacencia.
     */
    public Grafo() {
        this.listaAdyacencia = new HashMap<>();
    }

    /**
     * Agrega un nodo al grafo si no existe.
     * Cada nodo tendrá una LinkedList para sus aristas conectadas.
     * @param nodo Nombre del nodo (ciudad en este caso).
     */
    public void agregarNodo(String nodo) {
        listaAdyacencia.putIfAbsent(nodo, new LinkedList<>()); // Crea una LinkedList vacía para el nodo si no existe
    }

    /**
     * Agrega una arista entre dos nodos con peso.
     * Como es no dirigido, conecta en ambas direcciones.
     * Esto significa que puedes ir de A a B y de B a A con el mismo peso.
     * @param origen Nodo origen (ciudad de salida).
     * @param destino Nodo destino (ciudad de llegada).
     * @param peso Peso de la arista (distancia aproximada en km).
     */
    public void agregarArista(String origen, String destino, int peso) {
        listaAdyacencia.get(origen).add(new Arista(destino, peso)); // Agrega arista de origen a destino
        listaAdyacencia.get(destino).add(new Arista(origen, peso)); // Agrega arista de destino a origen (para grafo no dirigido)
    }

    /**
     * Devuelve la lista de adyacencia del grafo.
     * @return Mapa con nodos y sus listas de aristas.
     */
    public Map<String, LinkedList<Arista>> obtenerListaAdyacencia() {
        return listaAdyacencia;
    }

    /**
     * Representa una arista con destino y peso.
     * Una arista es una conexión entre dos nodos con un costo.
     */
    public static class Arista {
        private String destino; // Nodo al que llega la arista
        private int peso; // Costo de la arista (distancia en km)

        /**
         * Crea una arista.
         * @param destino Nodo destino.
         * @param peso Peso (distancia).
         */
        public Arista(String destino, int peso) {
            this.destino = destino;
            this.peso = peso;
        }

        /**
         * Obtiene el destino.
         * @return Nombre del nodo destino.
         */
        public String getDestino() {
            return destino;
        }

        /**
         * Obtiene el peso.
         * @return Peso de la arista.
         */
        public int getPeso() {
            return peso;
        }
    }
}
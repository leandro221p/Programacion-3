import java.util.*;

/**
 * Clase que incluye dos funciones principales:
 * 1. Encontrar todas las rutas posibles entre dos ciudades usando búsqueda profunda.
 * 2. Calcular distancias mínimas usando Dijkstra.
 * 
 * También contiene una clase interna para representar rutas.
 */
public class Dijkstra {

    /**
     * Esta clase modela un camino completo entre ciudades.
     * Guarda la lista de ciudades recorridas y la distancia total.
     */
    public static class Camino {
        private List<String> ruta;
        private int distanciaTotal;

        /**
         * Crea un nuevo camino copiando la ruta que llega como parámetro
         * para evitar que se modifique accidentalmente desde afuera.
         */
        public Camino(List<String> ruta, int distanciaTotal) {
            this.ruta = new ArrayList<>(ruta);     // Copia la ruta exacta
            this.distanciaTotal = distanciaTotal;  // Guarda la distancia
        }

        /** Retorna la secuencia exacta de ciudades del trayecto. */
        public List<String> getRuta() {
            return ruta;
        }

        /** Retorna cuántos kilómetros suma ese recorrido. */
        public int getDistanciaTotal() {
            return distanciaTotal;
        }

        /** Permite imprimir la ruta de manera fácil. */
        @Override
        public String toString() {
            return "Ruta: " + ruta + " | Kilómetros: " + distanciaTotal;
        }
    }

    /**
     * Busca todas las posibles rutas entre dos ciudades.
     * Utiliza DFS (búsqueda en profundidad) para explorar todos los caminos posibles.
     */
    public static List<Camino> encontrarTodosLosCaminos(Grafo grafo, String inicio, String fin) {
        List<Camino> caminos = new ArrayList<>();     // Aquí se guardarán todos los caminos terminados
        List<String> rutaActual = new ArrayList<>();  // Ruta temporal que se va construyendo
        Set<String> usados = new HashSet<>();         // Evita visitar la misma ciudad dentro del mismo camino

        rutaActual.add(inicio);  // El recorrido comienza en la ciudad inicial

        // Llamada al método recursivo que hace toda la exploración
        explorar(grafo, inicio, fin, usados, rutaActual, 0, caminos);
        return caminos;
    }

    /**
     * Método que se encarga de recorrer el grafo de forma recursiva.
     * Cada vez que avanza, suma peso; y cuando retrocede, resta la última ciudad.
     */
    private static void explorar(Grafo grafo, String ciudad, String destino, Set<String> usados,
                                 List<String> recorrido, int distancia, List<Camino> caminos) {

        // Si ya llegamos al destino, guardamos el camino actual como uno válido
        if (ciudad.equals(destino)) {
            caminos.add(new Camino(recorrido, distancia));
            return;
        }

        usados.add(ciudad);  // Marcamos la ciudad como visitada en este trayecto

        // Recorremos todas las ciudades vecinas
        for (Grafo.Arista arista : grafo.obtenerListaAdyacencia().get(ciudad)) {
            String sig = arista.getDestino();

            // Solo continuamos si no hemos pasado por esa ciudad previamente en este camino
            if (!usados.contains(sig)) {

                recorrido.add(sig);  // Avanzamos hacia esa ciudad

                // Llamada recursiva acumulando distancia
                explorar(grafo, sig, destino, usados,
                        recorrido, distancia + arista.getPeso(), caminos);

                recorrido.remove(recorrido.size() - 1);  // Se quita la ciudad para intentar otro camino
            }
        }

        usados.remove(ciudad); // Liberamos la ciudad para que pueda ser usada en caminos alternos
    }

    /**
     * Ordena la lista de caminos según su distancia, de menor a mayor.
     * Se usa burbuja por simplicidad y claridad.
     */
    public static void ordenarCaminosPorDistancia(List<Camino> caminos) {
        // Dos ciclos que comparan de a pares
        for (int i = 0; i < caminos.size() - 1; i++) {
            for (int j = 0; j < caminos.size() - i - 1; j++) {

                // Si el camino actual es más largo que el siguiente, se intercambian
                if (caminos.get(j).getDistanciaTotal() > caminos.get(j + 1).getDistanciaTotal()) {
                    Camino tmp = caminos.get(j);
                    caminos.set(j, caminos.get(j + 1));
                    caminos.set(j + 1, tmp);
                }
            }
        }
    }

    /**
     * Implementación del algoritmo de Dijkstra.
     * Encuentra la distancia más corta desde un nodo origen hacia todos los demás.
     */
    public static Map<String, Integer> calcularCaminoMasCorto(Grafo grafo, String origen) {

        Map<String, Integer> dist = new HashMap<>();     // Distancias más cortas conocidas
        Map<String, String> previo = new HashMap<>();    // Guarda por dónde se llegó
        Set<String> marcas = new HashSet<>();            // Indica qué nodos ya fueron procesados

        // Cola de prioridad que siempre saca el nodo con menor distancia provisional
        PriorityQueue<NodoDistancia> cola = new PriorityQueue<>(
                Comparator.comparingInt(NodoDistancia::getDistancia)
        );

        // Todas las distancias comienzan infinitas
        for (String nodo : grafo.obtenerListaAdyacencia().keySet()) {
            dist.put(nodo, Integer.MAX_VALUE);
        }

        // El origen comienza con distancia cero
        dist.put(origen, 0);
        cola.offer(new NodoDistancia(origen, 0));

        // Comienza el algoritmo de Dijkstra
        while (!cola.isEmpty()) {

            NodoDistancia actual = cola.poll();
            String ciudad = actual.getNodo();

            // Si ya se trabajó esa ciudad, se omite
            if (marcas.contains(ciudad)) continue;
            marcas.add(ciudad);

            // Se revisan los vecinos del nodo actual
            for (Grafo.Arista arista : grafo.obtenerListaAdyacencia().get(ciudad)) {

                String vecino = arista.getDestino();
                int nueva = dist.get(ciudad) + arista.getPeso();

                // Si encontramos una ruta más corta, se actualiza
                if (nueva < dist.get(vecino)) {
                    dist.put(vecino, nueva);
                    previo.put(vecino, ciudad);
                    cola.offer(new NodoDistancia(vecino, nueva));
                }
            }
        }

        return dist;  // Devuelve las distancias mínimas desde el origen
    }

    /**
     * Clase auxiliar para manejar los nodos dentro de la cola de prioridad.
     * Guarda el nombre del nodo y la distancia actual calculada.
     */
    private static class NodoDistancia {
        private String nodo;
        private int distancia;

        public NodoDistancia(String nodo, int distancia) {
            this.nodo = nodo;
            this.distancia = distancia;
        }

        public String getNodo() {
            return nodo;
        }

        public int getDistancia() {
            return distancia;
        }
    }

    /**
     * Aquí se arma el grafo de ejemplo con varias ciudades de Colombia
     * y se prueban las funciones de búsqueda de rutas.
     */
    public static void main(String[] args) {

        Grafo mapa = new Grafo();

        // Se agregan ciudades como nodos del grafo
        mapa.agregarNodo("Cali");
        mapa.agregarNodo("Bogotá");
        mapa.agregarNodo("Medellín");
        mapa.agregarNodo("Barranquilla");
        mapa.agregarNodo("Cartagena");
        mapa.agregarNodo("Pereira");
        mapa.agregarNodo("Manizales");
        mapa.agregarNodo("Armenia");
        mapa.agregarNodo("Ibagué");
        mapa.agregarNodo("Tunja");

        // Conexiones directas entre ciudades (aristas) con su distancia
        mapa.agregarArista("Cali", "Pereira", 150);
        mapa.agregarArista("Pereira", "Medellín", 200);
        mapa.agregarArista("Medellín", "Cartagena", 600);

        mapa.agregarArista("Cali", "Armenia", 100);
        mapa.agregarArista("Armenia", "Ibagué", 120);
        mapa.agregarArista("Ibagué", "Bogotá", 200);
        mapa.agregarArista("Bogotá", "Tunja", 150);
        mapa.agregarArista("Tunja", "Barranquilla", 700);
        mapa.agregarArista("Barranquilla", "Cartagena", 100);

        mapa.agregarArista("Cali", "Manizales", 180);
        mapa.agregarArista("Manizales", "Pereira", 50);

        mapa.agregarArista("Cali", "Bogotá", 450);
        mapa.agregarArista("Bogotá", "Cartagena", 1000);

        // Se generan todas las posibles rutas entre Cali y Cartagena
        List<Camino> rutas = encontrarTodosLosCaminos(mapa, "Cali", "Cartagena");

        // Se ordenan por distancia total
        ordenarCaminosPorDistancia(rutas);

        // Se imprimen todas las rutas encontradas
        System.out.println("Rutas posibles desde Cali a Cartagena:");
        for (Camino c : rutas) {
            System.out.println(c);
        }

        // Se muestra el mejor camino encontrado
        if (!rutas.isEmpty()) {
            System.out.println("\nRuta más corta encontrada:");
            System.out.println(rutas.get(0));
        } else {
            System.out.println("No se registraron rutas disponibles.");
        }
    }
}

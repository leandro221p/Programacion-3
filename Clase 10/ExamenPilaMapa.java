
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ExamenPilaMapa {

    static class PilaEnteros {
        private int[] datos;
        private int tope; // -1 si está vacío

        public PilaEnteros(int capacidad) {
            datos = new int[capacidad];
            tope = -1;
        }

        public boolean estaVacia() {
            return tope == -1;
        }

        public boolean estaLlena() {
            return tope + 1 == datos.length;
        }

        public void apilar(int x) {
            if (estaLlena()) {
                throw new IllegalStateException("Pila llena");
            }
            tope++;
            datos[tope] = x;
        }

        public int desapilar() {
            if (estaVacia()) {
                throw new IllegalStateException("Pila vacía");
            }
            int v = datos[tope];
            tope--;
            return v;
        }
    }

    // (50 pts) Verifica si los paréntesis están balanceados.
    public static boolean esBalanceado(String s) {
        PilaEnteros pila = new PilaEnteros(s.length());

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
                pila.apilar(1); // Apilamos un valor cuando se abre paréntesis
            } else if (c == ')') {
                if (pila.estaVacia()) {
                    // Si hay un cierre sin apertura previa → no está balanceado
                    return false;
                }
                pila.desapilar();
            }
        }
        // Si la pila está vacía al final, los paréntesis están balanceados
        return pila.estaVacia();
    }

    // (50 pts) Actualiza la calificación si existe el ID y está en rango 0..100.
    public static boolean actualizarCalificacion(Map<Integer, Integer> califPorId, int id, int nuevo) {
        // Verificar si el mapa es null para evitar NullPointerException
        if (califPorId == null) {
            return false;  // No podemos actualizar un mapa nulo
        }
        
        // Validar rango 0..100
        if (nuevo < 0 || nuevo > 100) {
            return false;  // Valor fuera de rango
        }
        
        // Validar existencia y actualizar
        if (califPorId.containsKey(id)) {
            califPorId.put(id, nuevo);  // Actualizar el valor
            return true;  // Actualización exitosa
        } else {
            return false;  // ID no existe
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String cadena = sc.nextLine();
        System.out.println("Balanceado: " + esBalanceado(cadena));

        Map<Integer, Integer> mapa = new HashMap<>();
        mapa.put(101, 70);
        System.out.println("Actualizado: " + actualizarCalificacion(mapa, 101, 95));
        
        sc.close();
    }
}

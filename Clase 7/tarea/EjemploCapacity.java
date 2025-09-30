package tarea;
import java.util.Vector;

public class EjemploCapacity {
    public static void main(String[] args) {
        // Creamos un vector con capacidad inicial de 2
        Vector<Integer> numeros = new Vector<>(2);
        numeros.add(10);
        numeros.add(20);

        System.out.println("Capacidad inicial: " + numeros.capacity());

        // Aumentamos capacidad manualmente
        numeros.ensureCapacity(10);
        System.out.println("Capacidad después de ensureCapacity(10): " + numeros.capacity());
    }
}

package tarea;
import java.util.Vector;

public class EjemploTrimToSize {
    public static void main(String[] args) {
        Vector<Integer> numeros = new Vector<>(20); // capacidad inicial de 20
        numeros.add(1);
        numeros.add(2);
        numeros.add(3);

        System.out.println("Capacidad antes: " + numeros.capacity());
        numeros.trimToSize();
        System.out.println("Capacidad después de trimToSize: " + numeros.capacity());
    }
}

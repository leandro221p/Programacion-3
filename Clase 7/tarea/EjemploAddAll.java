package tarea;
import java.util.*;

public class EjemploAddAll {
    public static void main(String[] args) {
        Vector<String> animales = new Vector<>();
        animales.add("Perro");
        animales.add("Gato");

        // Creamos otra lista para agregar de una vez
        List<String> masAnimales = Arrays.asList("Loro", "Conejo", "Tortuga");
        animales.addAll(masAnimales);

        System.out.println("Animales después de addAll: " + animales);
    }
}

package tarea;
import java.util.Vector;

public class EjemploSetSize {
    public static void main(String[] args) {
        Vector<String> nombres = new Vector<>();
        nombres.add("Ana");
        nombres.add("Luis");

        System.out.println("Tamaño actual: " + nombres.size());

        // Aumentamos tamaño a 5 (se rellenan con null)
        nombres.setSize(5);
        System.out.println("Después de setSize(5): " + nombres);

        // Disminuimos tamaño a 2 (los últimos elementos se eliminan)
        nombres.setSize(2);
        System.out.println("Después de setSize(2): " + nombres);
    }
}


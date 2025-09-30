package tarea;
import java.util.Vector;

public class EjemploAdd {
    public static void main(String[] args) {
        Vector<String> frutas = new Vector<>();

        // add() agrega al final
        frutas.add("Manzana");
        frutas.add("Banano");

        // addElement() es equivalente a add()
        frutas.addElement("Mango");

        System.out.println("Frutas después de agregar: " + frutas);
    }
}

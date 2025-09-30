import java.util.*;

public class Telefono {
    public static String formatoTelefono(int[] digitos) {
        if (digitos.length != 10) throw new IllegalArgumentException("Se requieren 10 dígitos");
        
        Queue<Integer> cola = new LinkedList<>();
        for (int d : digitos) cola.offer(d);

        return String.format("(%d%d%d) %d%d%d-%d%d%d%d",
            cola.poll(), cola.poll(), cola.poll(),
            cola.poll(), cola.poll(), cola.poll(),
            cola.poll(), cola.poll(), cola.poll(), cola.poll());
    }

    public static void main(String[] args) {
        System.out.println(formatoTelefono(new int[]{1,2,3,4,5,6,7,8,9,0})); // (123) 456-7890
        System.out.println(formatoTelefono(new int[]{3,0,0,1,2,3,4,5,6,7})); // (300) 123-4567
    }
}

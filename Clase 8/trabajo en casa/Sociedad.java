import java.util.*;

public class Sociedad {
    public static String sociedadSecreta(List<String> nombres) {
        Queue<String> cola = new LinkedList<>(nombres);
        List<String> iniciales = new ArrayList<>();

        while (!cola.isEmpty()) {
            String nombre = cola.poll();
            iniciales.add(nombre.substring(0,1).toUpperCase());
        }

        Collections.sort(iniciales);
        return String.join("", iniciales);
    }

    public static void main(String[] args) {
        System.out.println(sociedadSecreta(Arrays.asList("Adam","Sarah","Malcolm"))); 
        System.out.println(sociedadSecreta(Arrays.asList("bruce","clark","diana")));  
        System.out.println(sociedadSecreta(Arrays.asList("Zoe","anna","leo")));       
    }
}

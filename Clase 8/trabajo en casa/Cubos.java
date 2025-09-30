import java.util.*;

public class Cubos {
    public static boolean compararRaices(int a, int b) {
        Stack<Integer> pila = new Stack<>();
        pila.push(a);
        pila.push(b);

        int bVal = pila.pop();
        int aVal = pila.pop();

        double raizA = Math.sqrt(aVal);
        double raizCubicaB = Math.cbrt(bVal);

        return Math.abs(raizA - raizCubicaB) < 0.0001;
    }

    public static void main(String[] args) {
        System.out.println(compararRaices(4, 8));   
        System.out.println(compararRaices(16, 48)); 
        System.out.println(compararRaices(9, 27));  
    }
}

import java.util.*;

public class Voto {
    public static int votosDiferencia(int upvotos, int downvotos) {
        Queue<Integer> cola = new LinkedList<>();
        
        // Encolamos
        for (int i = 0; i < upvotos; i++) cola.offer(1);
        for (int i = 0; i < downvotos; i++) cola.offer(-1);
        
        int suma = 0;
        while (!cola.isEmpty()) {
            suma += cola.poll();
        }
        return suma;
    }

    public static void main(String[] args) {
        System.out.println(votosDiferencia(13, 0));   // 13
        System.out.println(votosDiferencia(2, 33));   // -31
        System.out.println(votosDiferencia(132, 132));// 0
    }
}


import java.util.*;

public class segundo {
    public static int segundoMayor(int[] arr) {
        if (arr.length < 2) throw new IllegalArgumentException("Mínimo dos elementos");

        Queue<Integer> cola = new LinkedList<>();
        for (int n : arr) cola.offer(n);

        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE;
        while (!cola.isEmpty()) {
            int val = cola.poll();
            if (val > max1) {
                max2 = max1;
                max1 = val;
            } else if (val > max2) {
                max2 = val;
            }
        }
        return max2;
    }

    public static void main(String[] args) {
        System.out.println(segundoMayor(new int[]{10,40,30,20,50})); 
        System.out.println(segundoMayor(new int[]{5,4,7,3,9}));     
        System.out.println(segundoMayor(new int[]{-3,-1,-7,-2}));   
    }
}

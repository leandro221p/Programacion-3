import java.util.*;

public class similar {
    public static boolean panSimilar(List<String> s1, List<String> s2) {
        Deque<String> d1 = new ArrayDeque<>(s1);
        Deque<String> d2 = new ArrayDeque<>(s2);

        return d1.peekFirst().equals(d2.peekFirst()) &&
               d1.peekLast().equals(d2.peekLast());
    }

    public static void main(String[] args) {
        System.out.println(panSimilar(
            Arrays.asList("pan blanco","lechuga","pan blanco"),
            Arrays.asList("pan blanco","tomate","pan blanco"))); // true

        System.out.println(panSimilar(
            Arrays.asList("pan integral","queso","pan integral"),
            Arrays.asList("pan blanco","queso","pan integral"))); // false
    }
}

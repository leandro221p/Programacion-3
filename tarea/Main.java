public class Main {
    public static void main(String[] args) {

        int[] datos = {34, 12, 54, 2, 72, 32, 52, 62};

        System.out.println("=== Ordenamiento por Burbuja ===");
        BubbleSort.ordenar(datos.clone());

        System.out.println("\n=== Ordenamiento por QuickSort ===");
        QuickSort.ordenar(datos.clone());

        System.out.println("\n=== Ordenamiento por MergeSort ===");
        MergeSort.ordenar(datos.clone());

         System.out.println("\n=== Ordenamiento por Inserción ===");
        InsertionSort.ordenar(datos.clone());

        System.out.println("\n=== Ordenamiento por Selección ===");
        SelectionSort.ordenar(datos.clone());

    }
}

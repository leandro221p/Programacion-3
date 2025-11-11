public class QuickSort {

    public static void ordenar(int[] arr) {

        System.out.print("Entrada: ");
        imprimir(arr);

        // Llamamos al método recursivo
        quicksort(arr, 0, arr.length - 1);

        System.out.print("Salida:  ");
        imprimir(arr);
    }

    // Método recursivo que divide el arreglo
    private static void quicksort(int[] arr, int inicio, int fin) {
        if (inicio < fin) {
            // Se obtiene el índice del pivote ya colocado
            int pivote = particion(arr, inicio, fin);

            // Ordena la parte izquierda
            quicksort(arr, inicio, pivote - 1);

            // Ordena la parte derecha
            quicksort(arr, pivote + 1, fin);
        }
    }

    // Reorganiza el arreglo tomando un pivote
    private static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];   // Se toma el último como pivote
        int i = inicio - 1;

        // Coloca menores que pivote a la izquierda
        for (int j = inicio; j < fin; j++) {
            if (arr[j] < pivote) {
                i++;
                // Intercambio
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        // Coloca el pivote en su posición final
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;

        return i + 1; // Se devuelve la posición final del pivote
    }

    // Imprime los elementos
    private static void imprimir(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}

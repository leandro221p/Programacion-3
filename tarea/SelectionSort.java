public class SelectionSort {

    public static void ordenar(int[] arr) {
        int n = arr.length;
        int cambios = 0, comparaciones = 0;

        System.out.print("Entrada: ");
        imprimir(arr);

        // Recorre el arreglo
        for (int i = 0; i < n - 1; i++) {
            int min = i;   // Suponemos que el mínimo es i

            // Busca el valor más pequeño en el resto
            for (int j = i + 1; j < n; j++) {
                comparaciones++;      // Compara arr[j] con arr[min]
                if (arr[j] < arr[min]) {
                    min = j;          // Se actualiza la posición del mínimo
                }
            }

            cambios++; // Se intercambia
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }

        System.out.print("Salida:  ");
        imprimir(arr);

        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Cambios: " + cambios);
    }

    // Imprime los elementos
    private static void imprimir(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}

public class BubbleSort {


    public static void ordenar(int[] arr) {
        int n = arr.length;   
        int cambios = 0,       // Contador de intercambios realizados
            comparaciones = 0; // Contador de comparaciones realizadas

        // Imprime el arreglo antes de ordenarlo
        System.out.print("Entrada: ");
        imprimir(arr);

        // Bucle externo: recorre el arreglo (n-1) veces
        for (int i = 0; i < n - 1; i++) {

            // Bucle interno: compara elementos adyacentes
            // En cada pasada, el último elemento ya queda ordenado
            for (int j = 0; j < n - i - 1; j++) {

                comparaciones++;  // Cada comparación se contabiliza

                // Si el elemento actual es mayor que el siguiente, se intercambian
                if (arr[j] > arr[j + 1]) {
                    cambios++;   // Contabiliza intercambio

                    // Intercambio de valores
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        // Imprime el arreglo después de ordenarlo
        System.out.print("Salida:  ");
        imprimir(arr);

        // Muestra estadísticas
        System.out.println("Comparaciones: " + comparaciones);
        System.out.println("Cambios: " + cambios);
    }

    // Método auxiliar para imprimir el contenido del arreglo
    private static void imprimir(int[] arr) {
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println();
    }
}

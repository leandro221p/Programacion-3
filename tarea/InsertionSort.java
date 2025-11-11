public class InsertionSort {

    
    public static void ordenar(int[] arr) {
        int comparaciones = 0,   // Contador de comparaciones realizadas
            cambios = 0;         // Contador de desplazamientos / cambios

        // Imprimir el arreglo antes de ordenarlo
        System.out.print("Entrada: ");
        imprimir(arr);

        // Recorremos el arreglo desde el índice 1
        // porque asumimos que el primer elemento ya está "ordenado"
        for (int i = 1; i < arr.length; i++) {

            int clave = arr[i]; // Elemento actual que se va a insertar
            int j = i - 1;      // Índice para recorrer la parte izquierda ordenada

            // Mientras no salgamos del arreglo y los elementos anteriores
            // sean mayores a la clave, se desplazan a la derecha
            while (j >= 0 && arr[j] > clave) {
                comparaciones++;     // Contabilizamos la comparación
                cambios++;           // Se cuenta como cambio porque movemos datos
                arr[j + 1] = arr[j]; // Desplazamos el elemento hacia la derecha
                j--;
            }

            // Se hace una comparación extra que rompe el while
            comparaciones++;

            // Insertamos la clave en la posición correcta
            arr[j + 1] = clave;
        }

        // Imprimir el arreglo ya ordenado
        System.out.print("Salida:  ");
        imprimir(arr);

        // Mostrar estadísticas de ejecución
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

public class MergeSort {

    public static void ordenar(int[] arr) {
        mergeSort(arr, 0, arr.length - 1);
    }

    // Método recursivo que divide el arreglo en mitades
    private static void mergeSort(int[] arr, int left, int right) {
        // Solo divide si hay más de un elemento
        if (left < right) {
            // Calcula el punto medio
            int middle = (left + right) / 2;

            // Ordena la mitad izquierda
            mergeSort(arr, left, middle);

            // Ordena la mitad derecha
            mergeSort(arr, middle + 1, right);

            // Une las dos mitades ya ordenadas
            merge(arr, left, middle, right);
        }
    }

    // Une dos subarreglos ordenados
    private static void merge(int[] arr, int left, int middle, int right) {

        // Tamaños de los subarreglos
        int n1 = middle - left + 1; // elementos en la mitad izquierda
        int n2 = right - middle;    // elementos en la mitad derecha

        // Se crean arreglos temporales
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copiamos los elementos correspondientes a L[]
        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];

        // Copiamos los elementos correspondientes a R[]
        for (int i = 0; i < n2; i++)
            R[i] = arr[middle + 1 + i];

        // Índices iniciales para recorrer L, R y el arreglo original
        int i = 0, j = 0;
        int k = left;

        // Recorre L y R comparando y colocando en arr
        while (i < n1 && j < n2) {
            // Copia el menor de los dos valores
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++; // avanza en L
            } else {
                arr[k] = R[j];
                j++; // avanza en R
            }
            k++; // avanza en el arreglo original
        }

        // Copia los elementos restantes de L si faltan
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de R si faltan
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}

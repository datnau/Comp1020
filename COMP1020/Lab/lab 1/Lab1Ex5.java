
public class Lab1Ex5 {

    public static void main(String[] args) {
        final int MAX_SIZE = 10;

        int[] array1 = new int[MAX_SIZE];
        int[] array2 = new int[MAX_SIZE];
        int[] array3 = new int[MAX_SIZE];
        int[] arrayAll = new int[3 * MAX_SIZE];
        int[] arrayDouble = new int[arrayAll.length * 2];

        int size1 = Math.min(MAX_SIZE, 8);
        int size2 = Math.min(MAX_SIZE, 3);
        int size3 = Math.min(MAX_SIZE, 10);
        int sizeAll = 0;
        int sizeDouble = 0;

        fillArray(array1, size1);
        fillArray(array2, size2);
        fillArray(array3, size3);

        System.out.print("Array #1: ");
        printArray(array1, size1);
        System.out.print("\nArray #2: ");
        printArray(array2, size2);
        System.out.print("\nArray #3: ");
        printArray(array3, size3);

        // call your concatenateArrays method twice to join array1, array2, array3 into arrayAll
        System.out.println("\nConcatenated array:");
        printArray(arrayAll, sizeAll);

        // call it again to join arrayAll, arrayAll into arrayDouble
        System.out.println("\nDoubled array:");
        printArray(arrayDouble, sizeDouble);

        System.out.println("\nEnd of processing.");
    }

    public static void fillArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            // an "interesting" pattern
            array[i] = (size % 2 + 1) + i * size;
        }
    }

    public static void printArray(int[] array, int size) {
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}


public class Lab1Ex6 {

    public static void main(String[] args) {
        int[] array1 = {3, 3, 9, 3, 7, 7}, array2 = {15, 3, 3, 4, 4, 7}, array3 = {7, 10, 8, 6, 4, 5, 15}, array4 = {9, 7, 3};
        int[] arrayTemp;
        int[] arrayFinal;

        arrayTemp = combineArrays(array1, array2);
        arrayTemp = combineArrays(arrayTemp, array3);
        arrayFinal = combineArrays(arrayTemp, array4);

        printArray(arrayFinal);

        System.out.println("End of processing.");
    }

    public static int[] combineArrays(int[] a1, int[] a2) {
        //combine 2 arrays
        int[] temp = new int[a1.length + a2.length];
        int pos = 0;
        for (int i = 0; i < a1.length; i++) {
            temp[pos++] = a1[i];
        }
        for (int i = 0; i < a2.length; i++) {
            temp[pos++] = a2[i];

        }

        // remove duplicate values
        int size = 0;
        int[] a3 = new int[temp.length];

        for (int i = 0; i < temp.length; i++) {
            int value = temp[i];
            boolean seen = false;
            for (int j = 0; j < size; j++) {
                if (value == a3[j]) {
                    seen = true;
                    break;
                }
            }
            if (!seen) {
                a3[size] = value;
                size++;
            }
        }

        int[] result = new int[size];
        for (int i = 0; i < size; i++) {
            result[i] = a3[i];

        }

        return result;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(array[i]);
        }
        System.out.println();
    }
}

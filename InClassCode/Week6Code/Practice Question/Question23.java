public class Question23 {
    public static void main(String[] args) {

        int[] arr = {1,4,3,2,5};
        int[] arr2 = {2,3,4,5};

        System.out.println(isSorted(arr, 0));
        System.out.println(isSorted(arr2, 0));
        
    }

    public static boolean isSorted(int[] arr, int index){
        if(index >= arr.length - 1) return true;
        if(arr[index] > arr[index + 1])return false;
        return isSorted(arr, index + 1);
    }


}

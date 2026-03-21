

public class searchingAlgorithm{
    public static void main(String[] args) {
        int array[] = new int[100];
        int target = 90;

        for(int i = 0; i < array.length; i++){
            array[i] = i;
        }

        int linear = linearSearch(array, target);
        int binary = binarySearch(array, linear);
        
        System.out.println(linear);
        System.out.println(binary);

    }

    public static int linearSearch(int[] a, int key){
        for(int i = 0; i < a.length; i++){
            if(a[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int binarySearch(int[] a, int key){
        int lo = 0;
        int hi = a.length - 1;
        while(lo <= hi){
            int mid = lo + (hi - lo)/2;
            if(a[mid] == key){
                return mid;
            }
            if(a[mid] < key){
                lo = mid + 1;
            }
            if(a[mid] > key){
                hi = mid - 1;
            }
        }
        return -1;
    }
}
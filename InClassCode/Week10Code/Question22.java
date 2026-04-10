public class Question22 {
    public static void main(String[] args) {
        int[] a = {1,2};
        int[] b = {3,4};

        int[] arr = addArrays(a, b);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
            
        }
        
    }

    public static int[] addArrays(int[] a, int[] b){
        int n = Math.min(a.length,b.length);
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = a[i] + b[i];
            
        }
        return arr;
    }
}

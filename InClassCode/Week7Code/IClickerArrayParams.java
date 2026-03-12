public class IClickerArrayParams {
    public static void main(String[] args) {
        int [][] m = {{1,1}, {1,1}};
        reassign(m);
        System.out.println(m[0][0]);

        otherReassign(m);
        System.out.println(m[0][0]);
    }
    public static void reassign(int[][] arr){
        arr = new int[2][2];
        arr[0][0] = 5;
    }
    public static void otherReassign(int[][] arr) {
        arr[0] = new int[2];

        arr[0][0] = 5;
    }
}

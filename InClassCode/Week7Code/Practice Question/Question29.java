import java.util.ArrayList;

public class Question29 {
    public static void main(String[] args) {
        int[][] a = {
            {1, 2, 3},
            {2, 4, 5},
            {3, 5, 6}
        };
        ArrayList<Integer> arrayList = flatten(a);
        
        for(int i = 0; i < arrayList.size(); i++){
            System.out.print(arrayList.get(i) + " ");
        }

    }

    public static ArrayList<Integer> flatten(int[][] data){
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int r = 0; r < data.length; r++) {
            for (int c = 0; c < data[r].length; c++) {
                arrayList.add(data[r][c]);
            }
        }
        return arrayList;
    }
}

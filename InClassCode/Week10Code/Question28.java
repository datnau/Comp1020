import java.util.List;

public class Question28 {
    public static void main(String[] args) {
        
    }

    public static int countEvenNode(List<Integer> list){
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) % 2 == 0){
                count++;
            }
            
        }
        return count;
    }

}

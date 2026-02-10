import java.util.ArrayList;
public class Question11{
    public static void main(String[] args) {
        String[] arr = {"Hello", "Hi" , "Bonjour"};
        System.out.println(toList(arr));
        
    }
    public static ArrayList<String> toList(String[] arr){
        ArrayList<String> list = new ArrayList<>();

        for(int i = 0; i < arr.length;i++){
            list.add(arr[i]);
        }
        return list;
    }
}
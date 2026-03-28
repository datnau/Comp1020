public class question5{
    public static void main(String[] args) {
        Object[] data = {"Apple" , 5 , "Banana"};
    int count = 0;
    for(int i = 0; i < data.length; i++){
        String str = (String) data[i];
        count += str.length();
    }
    System.out.println(count);
        
    }
    
}
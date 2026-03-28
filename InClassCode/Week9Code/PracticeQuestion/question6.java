public class question6 {
    public static void main(String[] args) {
    Object [] data = { 2, "Dog", 3, "Cat"};
    int result = 0;

    for (int i = 0; i < data. length ; i++) {
        if (data[i] instanceof Integer ){
            Integer val = ( Integer ) data[i];
            result += val;
        }
    }
    System .out. println ( result );
        
    }
    
}

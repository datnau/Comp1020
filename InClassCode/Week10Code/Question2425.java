public class Question2425 implements Searchable {

    public boolean evaluate(int target, int[] arr){
        boolean found = false;
        for(int i = 0; i < arr.length && !found; i++){
            if(arr[i] == target) found = true;
        }
        return found;

    }

    public int getSearchComplexity(){
        return  1;

    }
    
}

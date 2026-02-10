

public class test{
    public static void main(String[] args) {
        // ArrayList<String> list = new ArrayList<>();
        // list.add("A");
        // list.add(0,"B");
        // list.add("C");
        // list.set(1,"D");
        // list.remove(2);
        // System.out.println(list);



        // ArrayList<Integer> nums = new ArrayList<>();
        // nums.add(5);
        // nums.add(2);
        // nums.remove(Integer.valueOf(5));
        // System.out.println(nums);


        ArrayList<Box> list = new ArrayList<>();
        Box b = new 






    }
    
}
class Box{
    int val;
    Box(int v){
        val = v;
    }
    public String toString(){
        return "" + val;
    }

}
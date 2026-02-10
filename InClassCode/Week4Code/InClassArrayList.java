import java.util.ArrayList;

public class InClassArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> aList = new ArrayList<Integer>();

        aList.add(5);
        aList.add(3);
        aList.add(5);
        aList.add(2);
        aList.add(8);
        aList.add(3);

        aList.add(2,10);

        System.out.println(aList);

        aList.remove(2);

        System.out.println(aList);

        // aList.remove(new Integer(5));
        aList.remove(Integer.valueOf(5));

        System.out.println(aList);

        System.out.println(aList.get(3));
        System.out.println(aList.indexOf(Integer.valueOf(3)));
        System.out.println(aList.lastIndexOf(Integer.valueOf(3)));
        System.out.println(aList.contains(Integer.valueOf(20)));
    }
}

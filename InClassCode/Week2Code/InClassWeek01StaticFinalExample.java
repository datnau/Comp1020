public class InClassWeek01StaticFinalExample {

    // static final: one constant value shared by ALL objects, cannot change
    public static final int CLASS_CONST_INT = 20;
    // static (non-final): one shared variable for the whole class, can change
    public static int classCount = 0;

    // non-static final: a constant value per object; each object has its
    // own copy, but that copy can never change after it is set
    public final int MY_CONST_INT = 10;
    // non-static (neither static nor final): normal instance variable;
    // each object has its own copy and it can change
    public int myCount = 0;


    public static void main(String[] args) {
        InClassWeek01StaticFinalExample var1 = new InClassWeek01StaticFinalExample(); // default constructor
        InClassWeek01StaticFinalExample var2 = new InClassWeek01StaticFinalExample();

        System.out.println("Static final int : " + CLASS_CONST_INT);
        System.out.println("Instance final int : " + var2.MY_CONST_INT);
        System.out.println("Initial class count: " + classCount);
        var1.increment();
        var2.increment();
        System.out.println("var1 count: " + var1.myCount);
        System.out.println("var2 count: " + var2.myCount);
        System.out.println("Final class count: " + classCount);
    }


    public void increment() {
        // increases the shared static counter for the whole class
        classCount += 1;
        // increases this object's own instance counter only
        myCount += 1;
    }
}

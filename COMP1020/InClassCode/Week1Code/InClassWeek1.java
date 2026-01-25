package InClassCode;

public class InClassWeek1 {
    public final int MY_INT = 10;

    public static void main(String[] args) {
        InClassWeek1 someVar = new InClassWeek1();
        otherMethod(someVar);
    }
    public static void otherMethod(InClassWeek1 someVar){
        System.out.println("Hello: " + someVar.MY_INT);
    }
}

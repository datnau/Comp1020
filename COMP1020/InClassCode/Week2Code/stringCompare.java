
public class stringCompare {

    public static void main(String[] args) {
        String s1 = "Some String";
        String s2 = new String(s1);
        String s3 = "Some String";
        String s4 = "Some String" + "";

        System.out.println("Compare S1 and S2");
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));

        System.out.println("Compare S1 and S3");
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));

        System.out.println("Compare S1 and S4");
        System.out.println(s1 == s4);
        System.out.println(s1.equals(s4));
    }
}

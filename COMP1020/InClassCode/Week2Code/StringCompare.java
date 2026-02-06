public class StringCompare {
    public static void main(String[] args){
        // String Literals are "interned" by the compiler/JVM.
        // They are stored in a special "String Pool".
        String s1 = "Some String";

        // 'new String(...)' explicitely forces the creation of a NEW object on the heap,
        // even if the content is the same. It does NOT use the pool for the object itself.
        String s2 = new String(s1);

        // Since this is the exact same literal as s1, the JVM reuses the reference
        // from the String Pool. s3 points to the exact same memory address as s1.
        String s3 = "Some String";

        // This is a "Constant Expression". The compiler is smart enough to perform
        // the concatenation ("Some String" + "") at compile time.
        // The result is "Some String", which matches the literal in the pool.
        String s4 = "Some String" + "";

        // Compare s1 and s2 (Literal vs New Object)
        System.out.println("Compare S1 and S2");
        System.out.println(s1 == s2);      // false: Different memory addresses
        System.out.println(s1.equals(s2)); // true:  Same characters (content)


        // Compare s1 and s3 (Literal vs Literal)
        System.out.println("Compare S1 and S3");
        System.out.println(s1 == s3);      // true:  optimized to same reference
        System.out.println(s1.equals(s3)); // true:  Same content

        // Compare s1 and s4 (Literal vs Calculated Literal)
        System.out.println("Compare S1 and S4");
        System.out.println(s1 == s4);      // true:  Compiler optimization makes this same ref
        System.out.println(s1.equals(s4)); // true:  Same content
    }
}

public class ScopeExample {

    // 1. Class-scope variable (static field)
    static int value = 100;

    public static void main(String[] args) {
        System.out.println("--- Variable Shadowing ---");
        System.out.println("Class-level 'value': " + value);

        // This local variable 'shadows' the class-level variable named 'value'
        int value = 10;
        System.out.println("Local variable 'value' (shadowing): " + value);

        // We can still access the class variable using the class name
        System.out.println("Explicitly accessing ScopeExample.value: " + ScopeExample.value);

        System.out.println("\n--- Block Scope (if statement) ---");
        int outer = 5;

        if (outer > 0) {
            // New scope created by braces
            int inner = 20;
            System.out.println("Inside if-block, outer: " + outer);
            System.out.println("Inside if-block, inner: " + inner);

            // In Java, you CANNOT redeclare a variable that is already local to the method
            // int outer = 99; // ERROR: This would cause a compile error
        }

        // 'inner' ceases to exist here
        // System.out.println(inner); // ERROR: inner cannot be resolved to a variable
        System.out.println("Outside if-block, 'inner' is gone.");

        System.out.println("\n--- Block Scope (for loop) ---");
        for (int i = 0; i < 3; i++) {
            // 'i' is only visible inside this loop structure
            int loopVar = i * 10;
            System.out.println("Loop i: " + i + ", loopVar: " + loopVar);
        }

        // 'i' and 'loopVar' are not visible here
        // System.out.println(i); // ERROR
    }
}

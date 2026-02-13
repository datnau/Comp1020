import java.util.ArrayList;

public class InClassBox {
    public static void main(String[] args) {
        ArrayList<Box> boxes = new ArrayList<>();
        Box myBox = new Box(20);
        boxes.add(new Box(10));
        boxes.add(myBox);

        System.out.println("Initial list: " + boxes);

        // indexOf uses the .equals(Object e) method of the object in the list
        // If we implement equals(), this finds the box (index 0)
        // If we comment out equals(), this fails to find it (-1) because it looks for the exact
        // same object in memory
        System.out.println("Index of new Box(10): " + boxes.indexOf(new Box(10)));
        System.out.println("Index of myBox: " + boxes.indexOf(myBox));

        // remove() also relies on .equals()
        // If equals() is implemented, this removes the box with size 10
        // If equals() is NOT implemented, this does nothing (cannot find matching object)
        boxes.remove(new Box(10));

        System.out.println("After remove attempt: " + boxes);
    }
}

// NOTE: Helper non-public class MUST come after the public class
class Box{
    private int size;
    public Box(int size) {
        this.size = size;
    }

    public String toString() {
        return "Box(size:"+this.size+")";
    }

    public boolean equals(Box other) {
        return this.size == other.size;
    }

    // ---------------------------------------------------------
    // TRY COMMENTING OUT THE METHOD BELOW TO SEE THE DIFFERENCE
    // ---------------------------------------------------------


    // This method is what ArrayList calls (indexOf, remove, contains, etc)
    // It MUST accept 'Object' to override the default behavior
    // NOTE: We should use the keyword `instanceof` to make this more flexable, but we
    //       do not use that keyword in this class
    //       DO NOT use the keyword instanceof in your assignments or tests.
    public boolean equals(Object other) {
        return this.equals((Box)other);
    }
}

public class InClassConstructorPerson{
    public static void main(String[] args) {
        // Demonstrate multiple constructors
        Person a = new Person("Alex", 19);
        Person b = new Person(); // Calls the no-arg constructor
        Person c = new Person("Guy"); // Calls the name-only constructor

        System.out.println(a);
        System.out.println(c);

        // Demonstrate Pass by Reference (Reference Types)
        // Java passes references by value. The method gets a copy of the reference,
        // so it points to the SAME object on the heap.
        System.out.println(b);
        passByRefMethod(b);
        System.out.println(b); // The name will be changed

        // Demonstrate Pass by Value (Primitive Types)
        // Java passes primitives by value. The method gets a copy of the value.
        // Changes inside the method do NOT affect the original variable.
        int myVal = 10;
        System.out.println(myVal);
        passByValueMethod(myVal);
        System.out.println(myVal); // Will still be 10

    }

    public static void passByRefMethod(Person person) {
        // This modifies the object that 'person' refers to.
        // Since 'b' in main points to this same object, the change is visible there.
        person.changeName("Some new Name");
    }
    public static void passByValueMethod(int val) {
        // 'val' is a local copy of the value passed in (10).
        // Modifying this local copy has NO effect on 'myVal' in main.
        val += 1;
        System.out.println("Inside passByValueMethod: " + val);
    }
}


class Person {
    String name;
    int age;

    // Full constructor: initializes all fields
    Person(String name, int age) {
        this.name = name;
        this.age= age;
    }

    // No-arg constructor
    // Chains to the main constructor using 'this(...)', providing default values.
    Person() {
        this("Default Name", -1);
    }

    // Partial constructor
    // Chains to the main constructor, providing a default age.
    Person(String name) {
        this(name, -1);
    }

    public String getName() {return this.name;}

    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name);
    }
    public String toString(){
        return this.name + " (" + this.age + ")";
    }
    public void changeName(String newName) {
        this.name = newName;
    }
}

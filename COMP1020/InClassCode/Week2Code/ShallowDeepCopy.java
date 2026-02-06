public class ShallowDeepCopy{
    public static void main(String[] args) {
        Person[] array = new Person[4];

        array[0] = new Person("Alex");
        array[1] = new Person("Bob");
        array[2] = new Person("Charels");
        array[3] = new Person("Dave");

        // Create Shallow Copy
        // A shallow copy creates a new array, but the ELEMENTS point to the SAME objects.
        // Changing a Person's name in 'array' would also show up in 'shallowArray'.
        Person[] shallowArray = new Person[array.length];
        for(int i=0;i<array.length; i+=1) {
            shallowArray[i]= array[i]; // Copying the reference (address)
        }

        // Create Deep Copy
        // A deep copy creates a new array AND new objects for every element.
        // Changing a Person's name in 'array' would NOT affect 'deepArray'.
        Person[] deepArray = new Person[array.length];
        for(int i=0;i<array.length; i+=1) {
            deepArray[i]= new Person(array[i].getName()); // Calling constructor to make a NEW object
        }

        // Compare with Shallow Copy
        System.out.println("Compare with shallow array");
        for(int i=0;i<array.length; i+=1) {
            // '==' checks if they are the SAME object in memory (Reference Equality)
            System.out.println(array[i] == shallowArray[i]);       // true
            // '.equals' checks if they have the same content (Content Equality)
            System.out.println(array[i].equals(shallowArray[i]));  // true
        }

        // Compare with Deep Copy
        System.out.println("Compare with deep array");
        for(int i=0;i<array.length; i+=1) {
            // '==' checks Reference Equality. Result is FALSE because they are different objects.
            System.out.println(array[i] == deepArray[i]);      // false
            // '.equals' checks Content Equality. Result is TRUE because we copied the name.
            System.out.println(array[i].equals(deepArray[i])); // true
        }

    }
}


class Person {
    String name;

    Person(String name) { this.name = name; }

    public String getName() {return this.name;}

    public boolean equals(Person otherPerson) {
        return this.name.equals(otherPerson.name);
    }
}

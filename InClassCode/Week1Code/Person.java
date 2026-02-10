
public class Person {

    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    private void incrementAge(int delta) {
        this.age += delta;
    }

    public void hadBirthday() {
        this.incrementAge(1);
    }

    public boolean isOlder(Person person) {
        return this.age > person.age;
    }

    public String toString() {
        System.out.println("Inside the toString!");
        return "Name" + this.name + " (" + this.age + ")";

    }

    public static void main(String[] args) {
        Person newPerson = new Person("Bod", 18);
        System.out.println("The student name is: " + newPerson.getName());

        Person p1 = new Person("Alice", 24);
        Person p2 = new Person("Brown", 30);
        Person p3 = new Person("John", 16);
        System.out.println("The student name is: " + p1.getName());
        System.out.println("The student name is: " + p2.getName());
        System.out.println("The student name is: " + p3.getName());

        System.out.println("P1 > P2: " + p1.isOlder(p2));
        System.out.println("P3 age is: " + p3.getAge());
        p3.hadBirthday();
        System.out.println("P3 age is: " + p3.getAge());

        System.out.println(p3);

    }
}

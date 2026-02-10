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

    public boolean isOlder(Person other) {
        return this.age > other.age;
    }

    private void incrementAge(int delta) {
        this.age += delta;
    }

    public void hasBirthday() {
        this.incrementAge(1);
    }

    public String toString(){
        System.out.println("Inside the toString!");

        return "Name: " + this.name + "(" + this.age  + ")";
    }

    public static void main(String[] args) {
        Person somePerson = new Person ("Stew Dent", 20);

        System.out.println("The studnets name is: " + somePerson.getName());
    }
}

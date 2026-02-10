public class InClassPerson {
    public static void main(String[] args) {
        Person somePerson = new Person("Stew Dent", 20);

        System.out.println("The studnets name is: " + somePerson.getName());


        Person p1 = new Person("p1", 10);
        Person p2 = new Person("p2", 11);
        Person p3 = new Person("p3", 12);

        System.out.println("P1 > P2 : " + p1.isOlder(p2));

        System.out.println("P3 age is: " + p3.getAge());
        p3.hasBirthday();
        System.out.println("P3 age is: " + p3.getAge());

        // p3.incrementAge(3); // method is private, so cannot access


        System.out.println(p3);
    }
}

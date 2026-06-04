import java.util.List;
import java.util.stream.Collectors;

public class RecordsDemo {

    // Define a Record
    record Person(String name, int age) {}

    public static void main(String[] args) {
        System.out.println("=== Records Example ===\n");

        // Create instances
        Person p1 = new Person("Alice",   22);
        Person p2 = new Person("Bob",     17);
        Person p3 = new Person("Carol",   25);
        Person p4 = new Person("David",   15);
        Person p5 = new Person("Eve",     30);

        // Display all
        System.out.println("All Persons:");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
        System.out.println(p4);
        System.out.println(p5);

        // Access fields
        System.out.println("\nAccessing fields:");
        System.out.println("First person name : " + p1.name());
        System.out.println("First person age  : " + p1.age());

        // Use in a List and filter by age using Stream
        List<Person> people = List.of(p1, p2, p3, p4, p5);

        List<Person> adults = people.stream()
            .filter(p -> p.age() >= 18)
            .collect(Collectors.toList());

        System.out.println("\nAdults (age >= 18):");
        adults.forEach(p ->
            System.out.println("  " + p.name() +
                " (age: " + p.age() + ")"));

        List<Person> minors = people.stream()
            .filter(p -> p.age() < 18)
            .collect(Collectors.toList());

        System.out.println("\nMinors (age < 18):");
        minors.forEach(p ->
            System.out.println("  " + p.name() +
                " (age: " + p.age() + ")"));
    }
}
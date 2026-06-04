import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        System.out.println("=== Lambda Expressions ===\n");

        // Create list of strings
        List<String> names = new ArrayList<>();
        names.add("Charlie");
        names.add("Alice");
        names.add("Eve");
        names.add("Bob");
        names.add("David");

        System.out.println("Original List:");
        names.forEach(name -> System.out.println("  " + name));

        // Sort A-Z using lambda
        Collections.sort(names, (a, b) -> a.compareTo(b));
        System.out.println("\nSorted A → Z:");
        names.forEach(name -> System.out.println("  " + name));

        // Sort Z-A using lambda
        Collections.sort(names, (a, b) -> b.compareTo(a));
        System.out.println("\nSorted Z → A:");
        names.forEach(name -> System.out.println("  " + name));

        // Sort by length using lambda
        Collections.sort(names, (a, b) ->
            Integer.compare(a.length(), b.length()));
        System.out.println("\nSorted by Length:");
        names.forEach(name ->
            System.out.println("  " + name +
                " (length: " + name.length() + ")"));
    }
}
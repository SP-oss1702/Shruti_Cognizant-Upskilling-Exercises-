import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemo {
    public static void main(String[] args) {
        System.out.println("=== Stream API Example ===\n");

        List<Integer> numbers = Arrays.asList(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20
        );

        System.out.println("Original List:");
        System.out.println(numbers);

        // Filter even numbers
        List<Integer> evenNumbers = numbers.stream()
            .filter(n -> n % 2 == 0)
            .collect(Collectors.toList());

        System.out.println("\nEven Numbers:");
        System.out.println(evenNumbers);

        // Filter odd numbers
        List<Integer> oddNumbers = numbers.stream()
            .filter(n -> n % 2 != 0)
            .collect(Collectors.toList());

        System.out.println("\nOdd Numbers:");
        System.out.println(oddNumbers);

        // Filter numbers greater than 10
        List<Integer> greaterThan10 = numbers.stream()
            .filter(n -> n > 10)
            .collect(Collectors.toList());

        System.out.println("\nNumbers Greater Than 10:");
        System.out.println(greaterThan10);

        // Sum of even numbers
        int sum = numbers.stream()
            .filter(n -> n % 2 == 0)
            .mapToInt(Integer::intValue)
            .sum();

        System.out.println("\nSum of Even Numbers: " + sum);

        // Count even numbers
        long count = numbers.stream()
            .filter(n -> n % 2 == 0)
            .count();

        System.out.println("Count of Even Numbers: " + count);
    }
}
public class MethodOverloading {

    // Method 1: add two integers
    static int add(int a, int b) {
        return a + b;
    }

    // Method 2: add two doubles
    static double add(double a, double b) {
        return a + b;
    }

    // Method 3: add three integers
    static int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {

        System.out.println("=== Method Overloading ===");

        // Call method 1
        int sum1 = add(10, 20);
        System.out.println("add(10, 20)          = " + sum1);

        // Call method 2
        double sum2 = add(5.5, 3.3);
        System.out.println("add(5.5, 3.3)        = " + sum2);

        // Call method 3
        int sum3 = add(10, 20, 30);
        System.out.println("add(10, 20, 30)      = " + sum3);

        System.out.println();
        System.out.println("Same method name 'add' used 3 times");
        System.out.println("Java picks the right one based on parameters!");
    }
}
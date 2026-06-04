package Ex_37;

public class BytecodeDemo {

    // Field
    static int counter = 0;

    // Method 1 — Simple addition
    public int add(int a, int b) {
        return a + b;
    }

    // Method 2 — Loop
    public void countLoop(int n) {
        for (int i = 0; i < n; i++) {
            counter++;
        }
    }

    // Method 3 — String operation
    public String greet(String name) {
        return "Hello, " + name + "!";
    }

    // Method 4 — Conditional
    public String checkAge(int age) {
        if (age >= 18) {
            return "Adult";
        } else {
            return "Minor";
        }
    }

    // Method 5 — Recursion
    public int factorial(int n) {
        if (n <= 1) return 1;
        return n * factorial(n - 1);
    }

    // Main method
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        Bytecode Demo Program         ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        BytecodeDemo demo = new BytecodeDemo();

        System.out.println("➕ add(5, 3)       = " + demo.add(5, 3));
        System.out.println("👋 greet(Java)     = " + demo.greet("Java"));
        System.out.println("🔢 checkAge(20)    = " + demo.checkAge(20));
        System.out.println("🔢 checkAge(15)    = " + demo.checkAge(15));
        System.out.println("📐 factorial(5)    = " + demo.factorial(5));

        demo.countLoop(5);
        System.out.println("🔄 counter after loop = " + counter);

        System.out.println("\n✅ Run javap commands below to");
        System.out.println("   inspect the bytecode!");
    }
}
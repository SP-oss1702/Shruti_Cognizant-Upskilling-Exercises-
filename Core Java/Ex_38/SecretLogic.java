package Ex_38;

public class SecretLogic {

    // Obfuscated-style logic — interesting to decompile!
    private static final int MAGIC = 42;
    private int[] data;

    public SecretLogic(int size) {
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = (i + 1) * MAGIC;
        }
    }

    // Bitwise operations — interesting bytecode!
    public int compute(int x) {
        int result = x ^ MAGIC;      // XOR
        result     = result << 2;    // left shift
        result     = result & 0xFF;  // AND mask
        return result;
    }

    // Ternary chain
    public String classify(int n) {
        return n < 0   ? "Negative"
             : n == 0  ? "Zero"
             : n < 10  ? "Small"
             : n < 100 ? "Medium"
             :            "Large";
    }

    // Lambda-style iteration (interesting decompile!)
    public void printData() {
        System.out.println("Data array:");
        for (int val : data) {
            System.out.println("  → " + val);
        }
    }

    // Try-catch (interesting bytecode!)
    public int safeDivide(int a, int b) {
        try {
            return a / b;
        } catch (ArithmeticException e) {
            System.out.println("⚠️  Division by zero caught!");
            return -1;
        } finally {
            System.out.println("✅ safeDivide() completed.");
        }
    }

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║         Secret Logic Program         ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        SecretLogic logic = new SecretLogic(4);

        System.out.println("🔢 compute(10)    = " + logic.compute(10));
        System.out.println("🔢 compute(255)   = " + logic.compute(255));
        System.out.println();
        System.out.println("🏷️  classify(-5)  = " + logic.classify(-5));
        System.out.println("🏷️  classify(0)   = " + logic.classify(0));
        System.out.println("🏷️  classify(7)   = " + logic.classify(7));
        System.out.println("🏷️  classify(50)  = " + logic.classify(50));
        System.out.println("🏷️  classify(500) = " + logic.classify(500));
        System.out.println();

        logic.printData();

        System.out.println();
        System.out.println("➗ safeDivide(10,2) = "
                + logic.safeDivide(10, 2));
        System.out.println();
        System.out.println("➗ safeDivide(10,0) = "
                + logic.safeDivide(10, 0));

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("✅ Now decompile SecretLogic.class");
        System.out.println("   and see how it looks!");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
    }
}
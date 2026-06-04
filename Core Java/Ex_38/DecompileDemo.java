package Ex_38;

import java.util.ArrayList;
import java.util.List;

public class DecompileDemo {

    // Fields
    private String name;
    private int    age;
    private static final String VERSION = "1.0.0";

    // Constructor
    public DecompileDemo(String name, int age) {
        this.name = name;
        this.age  = age;
    }

    // Method 1 — Simple getter
    public String getName() {
        return name;
    }

    // Method 2 — Conditional logic
    public String getCategory() {
        if (age < 13) {
            return "Child";
        } else if (age < 18) {
            return "Teenager";
        } else if (age < 60) {
            return "Adult";
        } else {
            return "Senior";
        }
    }

    // Method 3 — Loop with List
    public List<String> generateList(int count) {
        List<String> items = new ArrayList<>();
        for (int i = 1; i <= count; i++) {
            items.add("Item_" + i);
        }
        return items;
    }

    // Method 4 — Switch expression
    public String getDayType(int day) {
        return switch (day) {
            case 1, 7 -> "Weekend";
            case 2, 3, 4, 5, 6 -> "Weekday";
            default -> "Invalid";
        };
    }

    // Method 5 — String builder
    public String buildProfile() {
        StringBuilder sb = new StringBuilder();
        sb.append("Name    : ").append(name).append("\n");
        sb.append("Age     : ").append(age).append("\n");
        sb.append("Category: ").append(getCategory()).append("\n");
        sb.append("Version : ").append(VERSION);
        return sb.toString();
    }

    // Main
    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║        Decompile Demo Program        ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        DecompileDemo demo = new DecompileDemo("Alice", 25);

        System.out.println("👤 Name     : " + demo.getName());
        System.out.println("📋 Category : " + demo.getCategory());
        System.out.println("📅 Day Type : " + demo.getDayType(1));
        System.out.println("📅 Day Type : " + demo.getDayType(3));
        System.out.println("\n📦 List     : " + demo.generateList(4));
        System.out.println("\n📄 Profile  :\n" + demo.buildProfile());

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("✅ Compiled! Now decompile using:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("   java -jar cfr.jar Ex_38/DecompileDemo.class");
        System.out.println("   (or open in JD-GUI)");
    }
}
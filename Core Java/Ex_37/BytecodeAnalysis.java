package Ex_37;

public class BytecodeAnalysis {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      javap Bytecode Analysis         ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📖 javap Command Reference:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
        System.out.println("1️⃣  Basic — Show class structure:");
        System.out.println("   javap Ex_37/BytecodeDemo");
        System.out.println();
        System.out.println("2️⃣  Bytecode — Show instructions:");
        System.out.println("   javap -c Ex_37/BytecodeDemo");
        System.out.println();
        System.out.println("3️⃣  Verbose — Full details:");
        System.out.println("   javap -verbose Ex_37/BytecodeDemo");
        System.out.println();
        System.out.println("4️⃣  Private members too:");
        System.out.println("   javap -private Ex_37/BytecodeDemo");
        System.out.println();
        System.out.println("5️⃣  Line numbers:");
        System.out.println("   javap -l Ex_37/BytecodeDemo");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📖 Bytecode Instruction Guide:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        String[][] instructions = {
            {"iload_0",    "Load int from local variable 0"},
            {"iload_1",    "Load int from local variable 1"},
            {"istore_1",   "Store int into local variable 1"},
            {"iadd",       "Add two integers"},
            {"isub",       "Subtract two integers"},
            {"imul",       "Multiply two integers"},
            {"idiv",       "Divide two integers"},
            {"iinc",       "Increment local variable by constant"},
            {"ireturn",    "Return integer value"},
            {"areturn",    "Return object/string reference"},
            {"return",     "Return void (nothing)"},
            {"aload_0",    "Load object reference (this)"},
            {"invokevirtual", "Call instance method"},
            {"invokespecial", "Call constructor or super method"},
            {"invokestatic",  "Call static method"},
            {"getstatic",  "Get static field value"},
            {"putstatic",  "Set static field value"},
            {"getfield",   "Get instance field value"},
            {"putfield",   "Set instance field value"},
            {"new",        "Create new object"},
            {"dup",        "Duplicate top stack value"},
            {"pop",        "Remove top stack value"},
            {"goto",       "Jump to instruction"},
            {"if_icmpge",  "If int >= jump"},
            {"if_icmplt",  "If int < jump"},
            {"bipush",     "Push byte as integer"},
            {"ldc",        "Load constant (String/int)"},
            {"iconst_0",   "Push integer constant 0"},
            {"iconst_1",   "Push integer constant 1"},
        };

        System.out.printf("%-20s %s%n", "Instruction", "Meaning");
        System.out.println("─".repeat(55));
        for (String[] row : instructions) {
            System.out.printf("%-20s %s%n", row[0], row[1]);
        }

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📖 How add(int a, int b) looks in bytecode:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
        System.out.println("Java Code:");
        System.out.println("  public int add(int a, int b) {");
        System.out.println("      return a + b;");
        System.out.println("  }");
        System.out.println();
        System.out.println("Bytecode (javap -c output):");
        System.out.println("  0: iload_1   ← push 'a' onto stack");
        System.out.println("  1: iload_2   ← push 'b' onto stack");
        System.out.println("  2: iadd      ← pop both, add, push result");
        System.out.println("  3: ireturn   ← return top of stack");
        System.out.println();
        System.out.println("Stack visualization:");
        System.out.println("  After iload_1: [a]");
        System.out.println("  After iload_2: [a, b]");
        System.out.println("  After iadd:    [a+b]");
        System.out.println("  After ireturn: [] ← returned a+b");

        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("📖 How if/else looks in bytecode:");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println();
        System.out.println("Java Code:");
        System.out.println("  if (age >= 18) {");
        System.out.println("      return \"Adult\";");
        System.out.println("  } else {");
        System.out.println("      return \"Minor\";");
        System.out.println("  }");
        System.out.println();
        System.out.println("Bytecode:");
        System.out.println("  0: iload_1       ← push age");
        System.out.println("  1: bipush 18     ← push 18");
        System.out.println("  3: if_icmplt 12  ← if age < 18, jump to 12");
        System.out.println("  6: ldc \"Adult\"  ← push \"Adult\"");
        System.out.println("  8: areturn       ← return \"Adult\"");
        System.out.println(" 12: ldc \"Minor\"  ← push \"Minor\"");
        System.out.println(" 14: areturn       ← return \"Minor\"");
    }
}
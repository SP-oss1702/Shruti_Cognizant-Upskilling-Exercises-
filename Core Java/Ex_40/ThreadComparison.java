package Ex_40;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadComparison {

    static final int THREAD_COUNT = 10_000;

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║  Virtual vs Platform Thread Comparison║");
        System.out.println("╚══════════════════════════════════════╝\n");

        System.out.println("📊 Launching " + THREAD_COUNT
                + " threads each...\n");

        // ─────────────────────────────────────────
        // TEST 1 — Platform (Traditional) Threads
        // ─────────────────────────────────────────
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 1: Platform Threads");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        AtomicInteger platformCounter = new AtomicInteger(0);
        long platformStart = System.currentTimeMillis();

        Thread[] platformThreads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            platformThreads[i] = Thread.ofPlatform()
                    .start(() -> {
                        try {
                            Thread.sleep(10); // simulate I/O
                            platformCounter.incrementAndGet();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
        }

        for (Thread t : platformThreads) t.join();

        long platformTime = System.currentTimeMillis()
                - platformStart;

        System.out.println("✅ Platform threads done!");
        System.out.println("   Count : " + platformCounter.get());
        System.out.println("   Time  : " + platformTime + " ms");

        // ─────────────────────────────────────────
        // TEST 2 — Virtual Threads
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TEST 2: Virtual Threads");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        AtomicInteger virtualCounter = new AtomicInteger(0);
        long virtualStart = System.currentTimeMillis();

        Thread[] virtualThreads = new Thread[THREAD_COUNT];

        for (int i = 0; i < THREAD_COUNT; i++) {
            virtualThreads[i] = Thread.ofVirtual()
                    .start(() -> {
                        try {
                            Thread.sleep(10); // simulate I/O
                            virtualCounter.incrementAndGet();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    });
        }

        for (Thread t : virtualThreads) t.join();

        long virtualTime = System.currentTimeMillis()
                - virtualStart;

        System.out.println("✅ Virtual threads done!");
        System.out.println("   Count : " + virtualCounter.get());
        System.out.println("   Time  : " + virtualTime + " ms");

        // ─────────────────────────────────────────
        // RESULTS
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("RESULTS: Performance Comparison");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("  🖥️  Platform Threads : %6d ms%n",
                platformTime);
        System.out.printf("  🧵 Virtual Threads  : %6d ms%n",
                virtualTime);

        if (virtualTime < platformTime) {
            long diff = platformTime - virtualTime;
            double speedup = (double) platformTime / virtualTime;
            System.out.printf("%n  🚀 Virtual threads were FASTER!%n");
            System.out.printf("     Saved   : %d ms%n", diff);
            System.out.printf("     Speedup : %.2fx faster%n",
                    speedup);
        } else {
            System.out.println("\n  ℹ️  Similar performance at "
                    + THREAD_COUNT + " threads.");
            System.out.println("     Virtual threads shine at"
                    + " 100k+ threads!");
        }

        // ─────────────────────────────────────────
        // COMPARISON TABLE
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("COMPARISON TABLE");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("%-25s %-20s %-20s%n",
                "Feature", "Platform Thread", "Virtual Thread");
        System.out.println("─".repeat(65));
        String[][] table = {
            {"Memory per thread",   "~1MB stack",     "~few KB"},
            {"Max threads",         "~10,000",         "Millions"},
            {"Creation cost",       "Heavy",           "Lightweight"},
            {"OS thread mapping",   "1:1",             "M:N"},
            {"Blocking I/O",        "Blocks OS thread","Unmounts only"},
            {"Best for",            "CPU tasks",       "I/O tasks"},
            {"Java version",        "All versions",    "Java 21+"},
            {"isVirtual()",         "false",           "true"},
        };
        for (String[] row : table) {
            System.out.printf("%-25s %-20s %-20s%n",
                    row[0], row[1], row[2]);
        }
    }
}
package Ex_40;

import java.util.concurrent.atomic.AtomicInteger;

public class VirtualThreadDemo {

    public static void main(String[] args)
            throws InterruptedException {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║     Virtual Threads Demo (Java 21)   ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // ─────────────────────────────────────────
        // DEMO 1 — Single Virtual Thread
        // ─────────────────────────────────────────
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 1: Single Virtual Thread");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        Thread vThread = Thread.ofVirtual()
                .name("my-virtual-thread")
                .start(() -> {
                    System.out.println("✅ Running in  : "
                            + Thread.currentThread());
                    System.out.println("🔹 Is Virtual  : "
                            + Thread.currentThread()
                                     .isVirtual());
                    System.out.println("🔹 Thread Name : "
                            + Thread.currentThread()
                                     .getName());
                });
        vThread.join(); // wait for it to finish

        // ─────────────────────────────────────────
        // DEMO 2 — 100,000 Virtual Threads
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 2: Launching 100,000 Virtual Threads");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        int threadCount = 100_000;
        AtomicInteger counter = new AtomicInteger(0);

        long startTime = System.currentTimeMillis();

        // Store all threads to join later
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            final int threadNum = i;
            threads[i] = Thread.ofVirtual()
                    .name("vthread-" + threadNum)
                    .start(() -> {
                        // Each thread does some work
                        counter.incrementAndGet();
                        // Print only first 5 and last 5
                        int num = Integer.parseInt(
                            Thread.currentThread()
                                  .getName()
                                  .split("-")[1]);
                        if (num < 5 || num >= threadCount - 5) {
                            System.out.println(
                                "  🧵 "
                                + Thread.currentThread()
                                         .getName()
                                + " → count = "
                                + counter.get());
                        }
                    });
        }

        // Wait for ALL threads to finish
        for (Thread t : threads) {
            t.join();
        }

        long endTime = System.currentTimeMillis();

        System.out.println("  ...(100,000 threads ran)...");
        System.out.println("\n✅ Total threads completed : "
                + counter.get());
        System.out.println("⏱️  Time taken             : "
                + (endTime - startTime) + " ms");

        // ─────────────────────────────────────────
        // DEMO 3 — Thread.startVirtualThread()
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 3: Thread.startVirtualThread()");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        Thread t1 = Thread.startVirtualThread(() -> {
            System.out.println("✅ Virtual Thread 1 running!");
            System.out.println("   Is Virtual: "
                    + Thread.currentThread().isVirtual());
        });

        Thread t2 = Thread.startVirtualThread(() -> {
            System.out.println("✅ Virtual Thread 2 running!");
            System.out.println("   Thread: "
                    + Thread.currentThread());
        });

        Thread t3 = Thread.startVirtualThread(() -> {
            try {
                Thread.sleep(100); // simulate I/O wait
                System.out.println(
                    "✅ Virtual Thread 3 — after sleep!");
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        t1.join();
        t2.join();
        t3.join();

        // ─────────────────────────────────────────
        // DEMO 4 — Virtual vs Platform Thread Info
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 4: Virtual vs Platform Thread Info");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // Platform (traditional) thread
        Thread platformThread = Thread.ofPlatform()
                .name("platform-thread")
                .start(() -> {
                    System.out.println("🖥️  Platform Thread:");
                    System.out.println("   Name      : "
                            + Thread.currentThread()
                                     .getName());
                    System.out.println("   Is Virtual: "
                            + Thread.currentThread()
                                     .isVirtual());
                    System.out.println("   Thread    : "
                            + Thread.currentThread());
                });

        // Virtual thread
        Thread virtualThread = Thread.ofVirtual()
                .name("virtual-thread")
                .start(() -> {
                    System.out.println("🧵 Virtual Thread:");
                    System.out.println("   Name      : "
                            + Thread.currentThread()
                                     .getName());
                    System.out.println("   Is Virtual: "
                            + Thread.currentThread()
                                     .isVirtual());
                    System.out.println("   Thread    : "
                            + Thread.currentThread());
                });

        platformThread.join();
        virtualThread.join();

        // ─────────────────────────────────────────
        // SUMMARY
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("SUMMARY: Virtual Thread Key Points");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("  Thread.ofVirtual().start(task)");
        System.out.println("    → Creates and starts virtual thread");
        System.out.println("  Thread.startVirtualThread(task)");
        System.out.println("    → Shortcut to start virtual thread");
        System.out.println("  thread.isVirtual()");
        System.out.println("    → Returns true for virtual threads");
        System.out.println("  thread.join()");
        System.out.println("    → Wait for thread to complete");
        System.out.println("  AtomicInteger");
        System.out.println("    → Thread-safe counter");
    }
}
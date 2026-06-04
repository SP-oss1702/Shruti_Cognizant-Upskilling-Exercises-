package Ex_41;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class CallableTaskDemo {

    // ─────────────────────────────────────────
    // Custom Callable classes
    // ─────────────────────────────────────────

    // Callable 1 — Factorial
    static class FactorialTask
            implements Callable<Long> {
        private final int n;
        FactorialTask(int n) { this.n = n; }

        @Override
        public Long call() throws Exception {
            Thread.sleep(50);
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i;
            }
            System.out.println("  🔢 Factorial("
                    + n + ") = " + result
                    + "  [" + Thread.currentThread()
                                    .getName() + "]");
            return result;
        }
    }

    // Callable 2 — Prime check
    static class PrimeTask
            implements Callable<Boolean> {
        private final int n;
        PrimeTask(int n) { this.n = n; }

        @Override
        public Boolean call() throws Exception {
            Thread.sleep(30);
            if (n < 2) return false;
            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) return false;
            }
            System.out.println("  🔍 isPrime("
                    + n + ") = "
                    + (n >= 2) + "  ["
                    + Thread.currentThread()
                             .getName() + "]");
            return true;
        }
    }

    // Callable 3 — String processor
    static class StringTask
            implements Callable<String> {
        private final String text;
        StringTask(String text) {
            this.text = text;
        }

        @Override
        public String call() throws Exception {
            Thread.sleep(80);
            String result = text.toUpperCase()
                    + " (len=" + text.length() + ")";
            System.out.println("  📝 Processed: "
                    + result + "  ["
                    + Thread.currentThread()
                             .getName() + "]");
            return result;
        }
    }

    public static void main(String[] args)
            throws InterruptedException,
                   ExecutionException {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║      Custom Callable Tasks Demo      ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // ─────────────────────────────────────────
        // TASK 1 — Factorial tasks
        // ─────────────────────────────────────────
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TASK 1: Factorial Callable Tasks");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService pool1 =
                Executors.newFixedThreadPool(4);

        List<Future<Long>> factFutures =
                new ArrayList<>();
        int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8};

        for (int n : numbers) {
            factFutures.add(
                pool1.submit(new FactorialTask(n)));
        }

        System.out.println("📋 Factorial Results:\n");
        long factTotal = 0;
        for (Future<Long> f : factFutures) {
            factTotal += f.get();
        }
        System.out.println("\n  📊 Sum of all factorials: "
                + factTotal);
        pool1.shutdown();

        // ─────────────────────────────────────────
        // TASK 2 — Prime check tasks
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TASK 2: Prime Check Callable Tasks");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService pool2 =
                Executors.newFixedThreadPool(4);

        int[] testNumbers = {
            2, 3, 4, 7, 10, 13, 17, 20, 23, 29
        };
        List<Future<Boolean>> primeFutures =
                new ArrayList<>();

        for (int n : testNumbers) {
            primeFutures.add(
                pool2.submit(new PrimeTask(n)));
        }

        System.out.println("📋 Prime Check Results:\n");
        List<Integer> primes = new ArrayList<>();
        for (int i = 0; i < testNumbers.length; i++) {
            if (primeFutures.get(i).get()) {
                primes.add(testNumbers[i]);
            }
        }
        System.out.println("\n  ✅ Prime numbers found: "
                + primes);
        pool2.shutdown();

        // ─────────────────────────────────────────
        // TASK 3 — String tasks
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("TASK 3: String Processing Tasks");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService pool3 =
                Executors.newFixedThreadPool(3);

        String[] words = {
            "hello", "java", "concurrency",
            "callable", "future", "executor"
        };

        List<Future<String>> stringFutures =
                new ArrayList<>();

        for (String word : words) {
            stringFutures.add(
                pool3.submit(new StringTask(word)));
        }

        System.out.println("📋 String Results:\n");
        List<String> processed = new ArrayList<>();
        for (Future<String> f : stringFutures) {
            processed.add(f.get());
        }
        System.out.println("\n  ✅ All processed: "
                + processed);
        pool3.shutdown();

        // ─────────────────────────────────────────
        // SUMMARY TABLE
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("SUMMARY: Key Classes & Methods");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.printf("%-30s %s%n",
                "Class/Method", "Purpose");
        System.out.println("─".repeat(60));
        String[][] summary = {
            {"Executors.newFixedThreadPool(n)",
             "Create pool of n threads"},
            {"executor.submit(callable)",
             "Submit task, get Future"},
            {"future.get()",
             "Block and get result"},
            {"future.get(timeout, unit)",
             "Get with timeout"},
            {"future.isDone()",
             "Check if completed"},
            {"future.cancel(true)",
             "Cancel the task"},
            {"executor.invokeAll(tasks)",
             "Run all, wait for all"},
            {"executor.invokeAny(tasks)",
             "Run all, return fastest"},
            {"executor.shutdown()",
             "Stop accepting new tasks"},
            {"Callable<T>",
             "Task that returns T"},
            {"Future<T>",
             "Handle to pending result"},
        };
        for (String[] row : summary) {
            System.out.printf("%-30s %s%n",
                    row[0], row[1]);
        }
    }
}
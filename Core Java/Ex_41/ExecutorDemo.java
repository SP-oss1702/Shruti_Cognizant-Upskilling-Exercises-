package Ex_41;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorDemo {

    public static void main(String[] args) {

        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║    ExecutorService & Callable Demo   ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        // ─────────────────────────────────────────
        // DEMO 1 — Basic Callable with Future
        // ─────────────────────────────────────────
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 1: Basic Callable with Future");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        // Step 1 — Create fixed thread pool
        ExecutorService executor =
                Executors.newFixedThreadPool(3);

        // Step 2 — Create Callable tasks
        Callable<String> task1 = () -> {
            Thread.sleep(100);
            return "✅ Task 1 completed by "
                    + Thread.currentThread().getName();
        };

        Callable<String> task2 = () -> {
            Thread.sleep(200);
            return "✅ Task 2 completed by "
                    + Thread.currentThread().getName();
        };

        Callable<String> task3 = () -> {
            Thread.sleep(50);
            return "✅ Task 3 completed by "
                    + Thread.currentThread().getName();
        };

        try {
            // Step 3 — Submit tasks and get Future
            Future<String> future1 = executor.submit(task1);
            Future<String> future2 = executor.submit(task2);
            Future<String> future3 = executor.submit(task3);

            System.out.println("📤 Tasks submitted...");
            System.out.println("⏳ Waiting for results...\n");

            // Step 4 — Get results using Future.get()
            System.out.println(future1.get());
            System.out.println(future2.get());
            System.out.println(future3.get());

        } catch (InterruptedException
                | ExecutionException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }

        executor.shutdown();

        // ─────────────────────────────────────────
        // DEMO 2 — Multiple Callable returning int
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 2: Callable Returning Integer");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService executor2 =
                Executors.newFixedThreadPool(5);

        List<Future<Integer>> futures = new ArrayList<>();

        // Submit 10 tasks that return squares
        for (int i = 1; i <= 10; i++) {
            final int num = i;
            Callable<Integer> squareTask = () -> {
                Thread.sleep(50);
                return num * num;
            };
            futures.add(executor2.submit(squareTask));
        }

        System.out.println("📦 Results — Squares of 1 to 10:\n");
        int total = 0;
        for (int i = 0; i < futures.size(); i++) {
            try {
                int result = futures.get(i).get();
                total += result;
                System.out.printf(
                    "  %2d² = %3d  [Thread: %s]%n",
                    i + 1, result,
                    "pool-thread");
            } catch (InterruptedException
                    | ExecutionException e) {
                System.out.println("❌ Error: "
                        + e.getMessage());
            }
        }
        System.out.println("\n  📊 Total sum of squares: " + total);
        executor2.shutdown();

        // ─────────────────────────────────────────
        // DEMO 3 — invokeAll()
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 3: invokeAll() — Run All Tasks");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService executor3 =
                Executors.newFixedThreadPool(4);

        List<Callable<String>> tasks = new ArrayList<>();
        String[] cities = {
            "Chennai", "Mumbai", "Delhi",
            "Bangalore", "Hyderabad", "Kolkata"
        };

        for (String city : cities) {
            tasks.add(() -> {
                Thread.sleep(
                    (long)(Math.random() * 200));
                return "🌆 Weather fetched for: "
                        + city + " — "
                        + (25 + (int)(Math.random()
                                * 10)) + "°C";
            });
        }

        try {
            // invokeAll waits for ALL tasks to finish
            List<Future<String>> results =
                    executor3.invokeAll(tasks);

            System.out.println("📋 All weather results:\n");
            for (Future<String> f : results) {
                System.out.println("  " + f.get());
            }
        } catch (InterruptedException
                | ExecutionException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        executor3.shutdown();

        // ─────────────────────────────────────────
        // DEMO 4 — invokeAny()
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 4: invokeAny() — Fastest Wins");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService executor4 =
                Executors.newFixedThreadPool(3);

        List<Callable<String>> raceTasks =
                new ArrayList<>();

        raceTasks.add(() -> {
            Thread.sleep(300);
            return "🥇 Server A responded first! (300ms)";
        });
        raceTasks.add(() -> {
            Thread.sleep(100);
            return "🥇 Server B responded first! (100ms)";
        });
        raceTasks.add(() -> {
            Thread.sleep(200);
            return "🥇 Server C responded first! (200ms)";
        });

        try {
            // invokeAny returns result of FASTEST task
            String fastest = executor4.invokeAny(raceTasks);
            System.out.println("⚡ Fastest result:\n  "
                    + fastest);
        } catch (InterruptedException
                | ExecutionException e) {
            System.out.println("❌ Error: " + e.getMessage());
        }
        executor4.shutdown();

        // ─────────────────────────────────────────
        // DEMO 5 — Future status checks
        // ─────────────────────────────────────────
        System.out.println("\n━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");
        System.out.println("DEMO 5: Future Status Checks");
        System.out.println("━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━");

        ExecutorService executor5 =
                Executors.newFixedThreadPool(2);

        Callable<String> slowTask = () -> {
            Thread.sleep(500);
            return "✅ Slow task done!";
        };

        Future<String> slowFuture =
                executor5.submit(slowTask);
public class ThreadDemo {

    // Thread 1 - extends Thread
    static class MyThread extends Thread {
        String threadName;

        MyThread(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName +
                    " → Message " + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupted!");
                }
            }
            System.out.println(threadName + " finished!");
        }
    }

    // Thread 2 - implements Runnable
    static class MyRunnable implements Runnable {
        String threadName;

        MyRunnable(String name) {
            this.threadName = name;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 5; i++) {
                System.out.println(threadName +
                    " → Message " + i);
                try {
                    Thread.sleep(400);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " interrupted!");
                }
            }
            System.out.println(threadName + " finished!");
        }
    }

    public static void main(String[] args) {
        System.out.println("=== Thread Creation Example ===\n");

        // Create threads
        MyThread thread1 = new MyThread("Thread-A");
        Thread   thread2 = new Thread(new MyRunnable("Thread-B"));

        // Start both threads
        thread1.start();
        thread2.start();

        System.out.println("Both threads started!\n");
    }
}
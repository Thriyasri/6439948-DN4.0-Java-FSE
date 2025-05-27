public class VirtualThreadsExample {
    public static void main(String[] args) throws InterruptedException {
        int count = 100_000;

        long start = System.currentTimeMillis();

        Thread[] threads = new Thread[count];

        for (int i = 0; i < count; i++) {
            threads[i] = Thread.startVirtualThread(() -> {
                // For demo, just print thread name (can comment this out to reduce console spam)
                // System.out.println("Hello from " + Thread.currentThread().getName());
            });
        }

        for (Thread t : threads) {
            t.join();
        }

        long end = System.currentTimeMillis();

        System.out.println("Launched and joined " + count + " virtual threads in " + (end - start) + " ms");
    }
}

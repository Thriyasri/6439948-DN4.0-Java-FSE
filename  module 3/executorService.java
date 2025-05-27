import java.util.concurrent.*;
import java.util.*;

public class ExecutorCallableExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Create a fixed thread pool with 3 threads
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // Prepare a list of Callable tasks
        List<Callable<String>> tasks = new ArrayList<>();

        tasks.add(() -> {
            Thread.sleep(1000); // simulate work
            return "Task 1 completed";
        });

        tasks.add(() -> {
            Thread.sleep(500);
            return "Task 2 completed";
        });

        tasks.add(() -> {
            Thread.sleep(700);
            return "Task 3 completed";
        });

        // Submit tasks and get Future objects
        List<Future<String>> futures = new ArrayList<>();
        for (Callable<String> task : tasks) {
            futures.add(executor.submit(task));
        }

        // Retrieve and print results
        for (Future<String> future : futures) {
            System.out.println(future.get());
        }

        // Shutdown the executor service
        executor.shutdown();
    }
}

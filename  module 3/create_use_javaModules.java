class Utils {
    public static String getGreeting(String name) {
        return "Hello, " + name + "!";
    }
}

public class Main {
    public static void main(String[] args) {
        String message = Utils.getGreeting("Java Modules (Simulated)");
        System.out.println(message);
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaSortDemo {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Zara");
        names.add("Mohan");
        names.add("Anita");
        names.add("Ravi");
        names.add("Leela");

        Collections.sort(names, (s1, s2) -> s1.compareToIgnoreCase(s2));

        System.out.println("Sorted names:");
        for (String name : names) {
            System.out.println(name);
        }
    }
}

import java.lang.reflect.Method;

public class ReflectionExample {
    public static void main(String[] args) throws Exception {
        // Load the class dynamically by name
        Class<?> clazz = Class.forName("Sample");

        // Print all declared methods and their parameter types
        Method[] methods = clazz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.print("Method: " + method.getName() + "(");
            Class<?>[] params = method.getParameterTypes();
            for (int i = 0; i < params.length; i++) {
                System.out.print(params[i].getSimpleName());
                if (i < params.length - 1) System.out.print(", ");
            }
            System.out.println(")");
        }

        // Create an instance of the class
        Object obj = clazz.getDeclaredConstructor().newInstance();

        // Invoke a method dynamically (e.g., multiply(int, int))
        Method multiplyMethod = clazz.getDeclaredMethod("multiply", int.class, int.class);
        Object result = multiplyMethod.invoke(obj, 6, 7);

        System.out.println("Result of multiply(6,7): " + result);
    }
}

// Sample class to be loaded dynamically
class Sample {
    public int multiply(int a, int b) {
        return a * b;
    }
}

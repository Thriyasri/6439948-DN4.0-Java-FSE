public class Sample {
    public int multiply(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        Sample s = new Sample();
        int result = s.multiply(5, 4);
        System.out.println("Result: " + result);
    }
}

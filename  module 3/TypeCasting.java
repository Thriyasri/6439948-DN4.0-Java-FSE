public class TypeCastingExample {
    public static void main(String[] args) {
        double decimalValue = 9.75;
        int intValue = (int) decimalValue;

        int wholeNumber = 7;
        double convertedDouble = (double) wholeNumber;

        System.out.println("Double to int: " + intValue);
        System.out.println("Int to double: " + convertedDouble);
    }
}

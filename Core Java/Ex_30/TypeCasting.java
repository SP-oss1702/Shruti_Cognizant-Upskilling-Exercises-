public class TypeCasting {
    public static void main(String[] args) {

        // double to int (explicit casting)
        double decimalValue = 9.99;
        int castedToInt = (int) decimalValue;

        System.out.println("=== Type Casting Example ===");
        System.out.println("Original double value : " + decimalValue);
        System.out.println("Casted to int         : " + castedToInt);
        System.out.println("(decimal part is lost)");

        System.out.println();

        // int to double (implicit casting)
        int wholeNumber = 42;
        double castedToDouble = wholeNumber;

        System.out.println("Original int value    : " + wholeNumber);
        System.out.println("Casted to double      : " + castedToDouble);
        System.out.println("(automatically becomes decimal)");
    }
}
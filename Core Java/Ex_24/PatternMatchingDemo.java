public class PatternMatchingDemo {

    // Method using pattern matching switch
    static void checkType(Object obj) {
        String result = switch (obj) {
            case Integer i ->
                "Integer  : " + i +
                " (doubled = " + (i * 2) + ")";
            case Double d ->
                "Double   : " + d +
                " (rounded = " + Math.round(d) + ")";
            case String s ->
                "String   : \"" + s +
                "\" (length = " + s.length() + ")";
            case Boolean b ->
                "Boolean  : " + b +
                " (opposite = " + !b + ")";
            case null ->
                "Null     : No value provided!";
            default ->
                "Unknown type: " + obj.getClass().getName();
        };
        System.out.println(result);
    }

    public static void main(String[] args) {
        System.out.println("=== Pattern Matching Switch (Java 21) ===\n");

        // Test different types
        checkType(42);
        checkType(3.14);
        checkType("Hello Java!");
        checkType(true);
        checkType(null);
        checkType('A');

        System.out.println("\n=== Multiple Objects ===");
        Object[] objects = {100, 9.99, "Stream", false, 777};
        for (Object obj : objects) {
            checkType(obj);
        }
    }
}
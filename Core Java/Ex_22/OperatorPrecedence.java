public class OperatorPrecedence {
    public static void main(String[] args) {

        System.out.println("=== Operator Precedence ===");

        // Expression 1
        int result1 = 10 + 5 * 2;
        System.out.println("10 + 5 * 2 = " + result1);
        System.out.println("Reason: * done first → 5*2=10, then 10+10=20");

        System.out.println();

        // Expression 2
        int result2 = (10 + 5) * 2;
        System.out.println("(10 + 5) * 2 = " + result2);
        System.out.println("Reason: () done first → 10+5=15, then 15*2=30");

        System.out.println();

        // Expression 3
        int result3 = 20 / 4 + 3 * 2;
        System.out.println("20 / 4 + 3 * 2 = " + result3);
        System.out.println("Reason: / and * first → 20/4=5, 3*2=6, then 5+6=11");

        System.out.println();

        // Expression 4
        int result4 = 100 - 50 / 5 + 2 * 3;
        System.out.println("100 - 50 / 5 + 2 * 3 = " + result4);
        System.out.println("Reason: 50/5=10, 2*3=6, then 100-10+6=96");

        System.out.println();

        // Expression 5 - Modulus
        int result5 = 10 % 3 + 4 * 2;
        System.out.println("10 % 3 + 4 * 2 = " + result5);
        System.out.println("Reason: 10%3=1, 4*2=8, then 1+8=9");
    }
}
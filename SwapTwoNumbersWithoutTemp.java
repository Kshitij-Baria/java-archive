public class SwapTwoNumbersWithoutTemp {
    public static void main(String[] args) {
        int a = 5;
        int b = -10;

        System.out.println(String.format("Before swapping, a = %d and b = %d", a, b));

        a = a + b;
        b = a - b;
        a = a - b;

        // another approach
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(String.format("After swapping, a = %d and b = %d", a, b));
    }
}
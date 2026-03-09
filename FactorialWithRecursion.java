public class FactorialWithRecursion {
    public static void main(String[] args) {
        int number = 6;
        System.out.println(String.format("Factorial of %d is %d", number, factorial(number)));
    }

    public static int factorial(int number) {
        if (number > 1) {
            return number * factorial(number - 1);
        }
        return 1;
    }
}
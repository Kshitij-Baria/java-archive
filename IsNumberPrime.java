public class IsNumberPrime {
    public static void main(String[] args) {
        int number = 5;
        System.out.println(String.format("Is %d a prime number? %s", number, isNumberPrime(number)));
    }

    public static boolean isNumberPrime(int number) {
        if (number <= 1) {
            return false;
        }

        int divisors = 0;
        for(int i = 1; i <= Math.sqrt(number); i++) {
            divisors += number % i == 0 ? 1 : 0;
        }

        return divisors <= 1;
    }
}